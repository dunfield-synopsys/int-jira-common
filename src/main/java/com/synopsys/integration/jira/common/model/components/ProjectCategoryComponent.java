/*
 * int-jira-common
 *
 * Copyright (c) 2022 Synopsys, Inc.
 *
 * Use subject to the terms and conditions of the Synopsys End User Software License and Maintenance Agreement. All rights reserved worldwide.
 */
package com.synopsys.integration.jira.common.model.components;

import com.synopsys.integration.rest.component.IntRestComponent;

public class ProjectCategoryComponent extends IntRestComponent {
    private String self;
    private String id;
    private String name;
    private String description;

    public ProjectCategoryComponent() {
    }

    public ProjectCategoryComponent(final String self, final String id, final String name, final String description) {
        this.self = self;
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getSelf() {
        return self;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
