package com.isxcode.meta.agent.run;

import com.isxcode.meta.api.agent.pojos.req.GetJobInfoReq;
import com.isxcode.meta.api.agent.pojos.req.GetJobLogReq;
import com.isxcode.meta.api.agent.pojos.req.StopJobReq;
import com.isxcode.meta.api.agent.pojos.req.SubmitJobReq;
import com.isxcode.meta.api.agent.pojos.res.GetJobInfoRes;
import com.isxcode.meta.api.agent.pojos.res.GetJobLogRes;
import com.isxcode.meta.api.agent.pojos.res.StopJobRes;
import com.isxcode.meta.api.agent.pojos.res.SubmitJobRes;

public interface AcornRun {

    SubmitJobRes submitJob(SubmitJobReq submitJobReq);

    GetJobInfoRes getJobInfo(GetJobInfoReq getJobInfoReq);

    GetJobLogRes getJobLog(GetJobLogReq getJobLogReq);

    StopJobRes stopJobReq(StopJobReq stopJobReq);
}
