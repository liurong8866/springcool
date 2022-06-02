package com.springcool.cool.job.service.impl;

import com.springcool.cool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.cool.job.manager.impl.SysJobLogManager;
import com.springcool.cool.job.service.ISysJobLogService;
import com.springcool.cool.job.api.domain.dto.SysJobLogDto;
import com.springcool.cool.job.api.domain.query.SysJobLogQuery;
import org.springframework.stereotype.Service;

/**
 * 调度日志管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysJobLogServiceImpl extends BaseServiceImpl<SysJobLogQuery, SysJobLogDto, SysJobLogManager> implements ISysJobLogService {

    /**
     * 清空任务日志
     */
    @Override
    public void cleanLog() {
        baseManager.cleanLog();
    }
}
