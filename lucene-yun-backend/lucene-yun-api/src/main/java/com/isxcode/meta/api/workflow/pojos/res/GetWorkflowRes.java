package com.isxcode.meta.api.workflow.pojos.res;

import com.isxcode.meta.api.work.pojos.dto.CronConfig;
import lombok.Data;

@Data
public class GetWorkflowRes {

    private Object webConfig;

    private CronConfig cronConfig;
}
