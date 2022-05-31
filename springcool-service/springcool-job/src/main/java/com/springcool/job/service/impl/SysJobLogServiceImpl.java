package com.springcool.job.service.impl;

import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.job.api.domain.dto.SysJobLogDto;
import com.springcool.job.api.domain.query.SysJobLogQuery;
import com.springcool.job.manager.impl.SysJobLogManager;
import com.springcool.job.service.ISysJobLogService;
import org.springframework.stereotype.Service;

/**
 * 调度日志管理 服务层处理
 *
 * @author xueyi
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
