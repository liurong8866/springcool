package com.springcool.system.monitor.service.impl;

import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.system.api.log.domain.query.SysOperateLogQuery;
import com.springcool.system.monitor.manager.ISysOperateLogManager;
import com.springcool.system.monitor.service.ISysOperateLogService;
import org.springframework.stereotype.Service;

/**
 * 操作日志管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysOperateLogServiceImpl extends BaseServiceImpl<SysOperateLogQuery, SysOperateLogDto, ISysOperateLogManager> implements ISysOperateLogService {

    /**
     * 清空操作日志
     */
    @Override
    public void cleanOperateLog() {
        baseManager.cleanOperateLog();
    }
}
