/*
 * int-jira-common
 *
 * Copyright (c) 2022 Synopsys, Inc.
 *
 * Use subject to the terms and conditions of the Synopsys End User Software License and Maintenance Agreement. All rights reserved worldwide.
 */
package com.synopsys.integration.jira.common.model.response;

import java.util.List;

import com.synopsys.integration.jira.common.model.JiraResponseModel;
import com.synopsys.integration.jira.common.model.components.IssuePropertyKeyComponent;

public class IssuePropertyKeysResponseModel extends JiraResponseModel {
    private List<IssuePropertyKeyComponent> keys;

    public IssuePropertyKeysResponseModel() {
    }

    public IssuePropertyKeysResponseModel(List<IssuePropertyKeyComponent> keys) {
        this.keys = keys;
    }

    public List<IssuePropertyKeyComponent> getKeys() {
        return keys;
    }

}
