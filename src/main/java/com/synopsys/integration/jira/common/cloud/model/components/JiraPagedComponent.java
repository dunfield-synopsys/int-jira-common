/**
 * int-jira-common
 *
 * Copyright (c) 2019 Synopsys, Inc.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.synopsys.integration.jira.common.cloud.model.components;

import com.synopsys.integration.jira.common.model.JiraPagedModel;
import com.synopsys.integration.rest.component.IntRestComponent;

public class JiraPagedComponent extends IntRestComponent implements JiraPagedModel {
    private Integer startAt;
    private Integer maxResults;
    private Integer total;

    @Override
    public Integer getStartAt() {
        return startAt;
    }

    @Override
    public Integer getMaxResults() {
        return maxResults;
    }

    @Override
    public Integer getTotal() {
        return total;
    }
}
