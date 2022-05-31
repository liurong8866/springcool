package com.springcool.job.manager;

import com.springcool.common.web.entity.manager.ISubBaseManager;
import com.springcool.job.api.domain.dto.SysJobDto;
import com.springcool.job.api.domain.dto.SysJobLogDto;
import com.springcool.job.api.domain.query.SysJobLogQuery;
import com.springcool.job.api.domain.query.SysJobQuery;

import java.util.List;

/**
 * 调度任务管理 数据封装层
 *
 * @author xueyi
 */
public interface ISysJobManager extends ISubBaseManager<SysJobQuery, SysJobDto, SysJobLogQuery, SysJobLogDto> {

    /**
     * 项目启动时
     */
    List<SysJobDto> initScheduler();
}
