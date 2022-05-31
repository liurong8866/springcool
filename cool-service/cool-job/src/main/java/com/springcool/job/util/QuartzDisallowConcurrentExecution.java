package com.springcool.job.util;

import com.springcool.job.api.domain.dto.SysJobDto;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（禁止并发执行）
 *
 * @author springcool
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {

    @Override
    protected void doExecute(JobExecutionContext context, SysJobDto sysJob) throws Exception {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}