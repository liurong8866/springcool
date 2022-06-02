package com.springcool.cool.system.monitor.service.impl;


import com.springcool.cool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.cool.system.monitor.manager.ISysLoginLogManager;
import com.springcool.cool.system.monitor.service.ISysLoginLogService;
import com.springcool.cool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.cool.system.api.log.domain.query.SysLoginLogQuery;
import org.springframework.stereotype.Service;

/**
 * 访问日志管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLogQuery, SysLoginLogDto, ISysLoginLogManager> implements ISysLoginLogService {

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLoginLog() {
        baseManager.cleanLoginLog();
    }
}
