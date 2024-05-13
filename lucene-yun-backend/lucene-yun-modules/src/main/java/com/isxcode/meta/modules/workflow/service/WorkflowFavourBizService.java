package com.isxcode.meta.modules.workflow.service;

import static com.isxcode.meta.common.config.CommonConfig.USER_ID;

import com.isxcode.meta.backend.api.base.exceptions.IsxAppException;
import com.isxcode.meta.modules.workflow.entity.WorkflowFavourEntity;
import com.isxcode.meta.modules.workflow.repository.WorkflowFavourRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户模块接口的业务逻辑.
 */
@Service
@RequiredArgsConstructor
public class WorkflowFavourBizService {

    private final WorkflowBizService workflowBizService;

    private final WorkflowFavourRepository workflowFavourRepository;

    public void favourWorkflow(String workflowId) {

        workflowBizService.getWorkflowEntity(workflowId);

        // 判断工作流是否被收藏过
        Optional<WorkflowFavourEntity> workflowFavourEntityOptional =
            workflowFavourRepository.findByWorkflowIdAndUserId(workflowId, USER_ID.get());
        if (!workflowFavourEntityOptional.isPresent()) {
            throw new IsxAppException("已收藏");
        }

        WorkflowFavourEntity workflowFavour =
            WorkflowFavourEntity.builder().workflowId(workflowId).userId(USER_ID.get()).build();
        workflowFavourRepository.save(workflowFavour);
    }
}
