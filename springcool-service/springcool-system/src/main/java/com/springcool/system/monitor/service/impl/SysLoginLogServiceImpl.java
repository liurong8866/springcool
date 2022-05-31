package com.springcool.system.monitor.service.impl;


import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.system.api.log.domain.query.SysLoginLogQuery;
import com.springcool.system.monitor.manager.ISysLoginLogManager;
import com.springcool.system.monitor.service.ISysLoginLogService;
import org.springframework.stereotype.Service;

/**
 * 访问日志管理 服务层处理
 *
 * @author xueyi
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
