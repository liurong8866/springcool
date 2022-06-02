package com.springcool.cool.job.manager;

import com.springcool.cool.common.web.entity.manager.IBaseManager;
import com.springcool.cool.job.api.domain.dto.SysJobLogDto;
import com.springcool.cool.job.api.domain.query.SysJobLogQuery;

/**
 * 调度任务日志管理 数据封装层
 *
 * @author springcool
 */
public interface ISysJobLogManager extends IBaseManager<SysJobLogQuery, SysJobLogDto> {

    /**
     * 清空任务日志
     */
    void cleanLog();
}
