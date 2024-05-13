package com.isxcode.meta.modules.monitor.mapper;

import com.isxcode.meta.api.monitor.pojos.dto.NodeMonitorInfo;
import com.isxcode.meta.modules.monitor.entity.MonitorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonitorMapper {

    MonitorEntity nodeMonitorInfoToMonitorEntity(NodeMonitorInfo nodeMonitorInfo);
}
