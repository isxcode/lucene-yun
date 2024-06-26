package com.isxcode.meta.modules.func.service;

import com.isxcode.meta.api.func.pojos.req.AddFuncReq;
import com.isxcode.meta.api.func.pojos.req.DeleteFuncReq;
import com.isxcode.meta.api.func.pojos.req.PageFuncReq;
import com.isxcode.meta.api.func.pojos.req.UpdateFuncReq;
import com.isxcode.meta.api.func.pojos.res.PageFuncRes;
import com.isxcode.meta.backend.api.base.exceptions.IsxAppException;
import com.isxcode.meta.modules.file.entity.FileEntity;
import com.isxcode.meta.modules.file.repository.FileRepository;
import com.isxcode.meta.modules.func.entity.FuncEntity;
import com.isxcode.meta.modules.func.mapper.FuncMapper;
import com.isxcode.meta.modules.func.repository.FuncRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FuncBizService {

    private final FuncRepository funcRepository;

    private final FuncService funcService;

    private final FuncMapper funcMapper;

    private final FileRepository fileRepository;

    public void addFunc(AddFuncReq addFuncReq) {

        // 判断函数名是否重复
        Optional<FuncEntity> funcEntityOptional = funcRepository.findByFuncName(addFuncReq.getFuncName());
        if (funcEntityOptional.isPresent()) {
            throw new IsxAppException("函数已重复存在");
        }

        FuncEntity funcEntity = funcMapper.addFuncReqToFuncEntity(addFuncReq);

        // 持久化数据
        funcRepository.save(funcEntity);
    }

    public void updateFunc(UpdateFuncReq updateFuncReq) {

        FuncEntity func = funcService.getFunc(updateFuncReq.getId());
        func = funcMapper.updateFuncReqToFuncEntity(updateFuncReq, func);
        funcRepository.save(func);
    }

    public void deleteFunc(DeleteFuncReq deleteFuncReq) {

        FuncEntity func = funcService.getFunc(deleteFuncReq.getId());

        funcRepository.deleteById(func.getId());
    }

    public Page<PageFuncRes> pageFunc(PageFuncReq pageFuncReq) {

        Page<FuncEntity> funcPage = funcRepository.pageSearch(pageFuncReq.getSearchKeyWord(),
            PageRequest.of(pageFuncReq.getPage(), pageFuncReq.getPageSize()));

        Page<PageFuncRes> result = funcPage.map(funcMapper::funcEntityToPageFuncRes);
        result.getContent().forEach(e -> {
            Optional<FileEntity> fileEntityOptional = fileRepository.findById(e.getFileId());
            if (fileEntityOptional.isPresent()) {
                e.setFileName(fileEntityOptional.get().getFileName());
            } else {
                e.setFileName("文件不存在");
            }
        });

        return result;
    }
}
