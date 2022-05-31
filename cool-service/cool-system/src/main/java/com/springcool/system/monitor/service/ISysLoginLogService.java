package com.springcool.system.monitor.service;

import com.springcool.common.web.entity.service.IBaseService;
import com.springcool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.system.api.log.domain.query.SysLoginLogQuery;

/**
 * 访问日志管理 服务层
 *
 * @author springcool
 */
public interface ISysLoginLogService extends IBaseService<SysLoginLogQuery, SysLoginLogDto> {

    /**
     * 清空系统登录日志
     */
    void cleanLoginLog();
}