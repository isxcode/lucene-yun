package com.isxcode.meta.api.tenant.pojos.res;

import lombok.Data;

@Data
public class QueryUserTenantRes {

    private boolean isCurrentTenant;

    private String id;

    private String name;
}
