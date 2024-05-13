package com.isxcode.meta.modules.func.mapper;

import com.isxcode.meta.api.func.pojos.dto.FuncInfo;
import com.isxcode.meta.api.func.pojos.req.AddFuncReq;
import com.isxcode.meta.api.func.pojos.req.UpdateFuncReq;
import com.isxcode.meta.api.func.pojos.res.PageFuncRes;
import com.isxcode.meta.modules.func.entity.FuncEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * mapstruct映射.
 */
@Mapper(componentModel = "spring")
public interface FuncMapper {

    FuncEntity addFuncReqToFuncEntity(AddFuncReq addFuncReq);

    @Mapping(source = "updateFuncReq.type", target = "type")
    @Mapping(source = "updateFuncReq.funcName", target = "funcName")
    @Mapping(source = "updateFuncReq.className", target = "className")
    @Mapping(source = "updateFuncReq.resultType", target = "resultType")
    @Mapping(source = "updateFuncReq.id", target = "id")
    @Mapping(source = "updateFuncReq.remark", target = "remark")
    @Mapping(source = "updateFuncReq.fileId", target = "fileId")
    FuncEntity updateFuncReqToFuncEntity(UpdateFuncReq updateFuncReq, FuncEntity udfEntity);

    PageFuncRes funcEntityToPageFuncRes(FuncEntity funcEntity);

    List<FuncInfo> funcEntityListToFuncInfoList(List<FuncEntity> funcEntities);
}
