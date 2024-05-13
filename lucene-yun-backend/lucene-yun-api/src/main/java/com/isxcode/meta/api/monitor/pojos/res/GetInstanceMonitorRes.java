package com.isxcode.meta.api.monitor.pojos.res;

import com.isxcode.meta.api.monitor.pojos.dto.WorkflowInstanceLineDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetInstanceMonitorRes {

    List<WorkflowInstanceLineDto> instanceNumLine;
}
