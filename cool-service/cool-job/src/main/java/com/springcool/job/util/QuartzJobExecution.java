package com.springcool.job.util;

import com.springcool.job.api.domain.dto.SysJobDto;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author springcool
 */
public class QuartzJobExecution extends AbstractQuartzJob {

    @Override
    protected void doExecute(JobExecutionContext context, SysJobDto sysJob) throws Exception {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
