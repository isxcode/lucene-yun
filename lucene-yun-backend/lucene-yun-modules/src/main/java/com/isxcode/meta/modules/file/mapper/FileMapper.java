package com.isxcode.meta.modules.file.mapper;

import com.isxcode.meta.api.file.pojos.res.PageFileRes;
import com.isxcode.meta.modules.file.entity.FileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {

    PageFileRes fileEntityToPageFileRes(FileEntity fileEntity);
}
