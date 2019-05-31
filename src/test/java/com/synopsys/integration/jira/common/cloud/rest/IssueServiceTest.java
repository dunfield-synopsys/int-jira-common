package com.synopsys.integration.jira.common.cloud.rest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.synopsys.integration.jira.common.cloud.builder.IssueRequestModelFieldsBuilder;
import com.synopsys.integration.jira.common.cloud.model.FieldUpdateOperationComponent;
import com.synopsys.integration.jira.common.cloud.model.IssueComponent;
import com.synopsys.integration.jira.common.cloud.model.ProjectComponent;
import com.synopsys.integration.jira.common.cloud.model.UserDetailsComponent;
import com.synopsys.integration.jira.common.cloud.model.request.IssueRequestModel;
import com.synopsys.integration.jira.common.cloud.model.response.IssueTypeResponseModel;
import com.synopsys.integration.jira.common.cloud.model.response.PageOfProjectsResponseModel;
import com.synopsys.integration.jira.common.cloud.rest.service.IssueService;
import com.synopsys.integration.jira.common.cloud.rest.service.IssueTypeService;
import com.synopsys.integration.jira.common.cloud.rest.service.JiraCloudServiceFactory;
import com.synopsys.integration.jira.common.cloud.rest.service.ProjectService;
import com.synopsys.integration.jira.common.cloud.rest.service.UserSearchService;
import com.synopsys.integration.jira.common.model.EntityProperty;

public class IssueServiceTest extends JiraServiceTest {
    @Test
    public void createIssue() throws Exception {
        validateConfiguration();
        JiraCloudServiceFactory serviceFactory = createServiceFactory();
        IssueService issueService = serviceFactory.createIssueService();
        UserSearchService userSearchService = serviceFactory.createUserSearchService();
        ProjectService projectService = serviceFactory.createProjectService();
        IssueTypeService issueTypeService = serviceFactory.createIssueTypeService();

        IssueTypeResponseModel bugIssueType = issueTypeService.getAllIssueTypes().stream()
                                                  .filter(issueType -> "bug".equalsIgnoreCase(issueType.getName()))
                                                  .findFirst()
                                                  .orElseThrow(() -> new IllegalStateException("Jira Bug issue type not found."));
        PageOfProjectsResponseModel projects = projectService.getProjects();
        UserDetailsComponent userDetails = userSearchService.findUser(getEnvUserEmail()).stream()
                                               .findFirst()
                                               .orElseThrow(() -> new IllegalStateException("Jira User not found"));
        ProjectComponent project = projects.getProjects().stream()
                                       .findFirst()
                                       .orElseThrow(() -> new IllegalStateException("Jira Projects not found"));
        UUID uniqueId = UUID.randomUUID();

        IssueRequestModelFieldsBuilder fieldsBuilder = new IssueRequestModelFieldsBuilder();
        fieldsBuilder.setReporter(userDetails.getAccountId());
        fieldsBuilder.setProject(project.getId());
        fieldsBuilder.setDescription("Description of the test issue: " + uniqueId.toString());
        fieldsBuilder.setSummary("Test Issue " + uniqueId.toString());
        fieldsBuilder.setIssueType(bugIssueType.getId());

        Map<String, List<FieldUpdateOperationComponent>> update = new HashMap<>();
        List<EntityProperty> properties = new LinkedList<>();
        IssueRequestModel requestModel = new IssueRequestModel(fieldsBuilder, update, properties);

        // create an issue
        IssueComponent createdIssue = issueService.createIssue(requestModel);
        //TODO fix the get issue to a response model.
        //IssueComponent foundIssue = issueService.getIssue(createdIssue.getId());
        // delete the issue
        issueService.deleteIssue(createdIssue.getId());

        // assertEquals(createdIssue.getId(), foundIssue.getId());
        // assertEquals(createdIssue.getKey(), foundIssue.getKey());
        // assertEquals(createdIssue.getFields().getDescription(), foundIssue.getFields().getDescription());

    }
}
