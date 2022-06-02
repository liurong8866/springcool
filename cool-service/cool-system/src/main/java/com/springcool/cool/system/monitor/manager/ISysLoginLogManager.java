package com.springcool.cool.system.monitor.manager;

import com.springcool.cool.common.web.entity.manager.IBaseManager;
import com.springcool.cool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.cool.system.api.log.domain.query.SysLoginLogQuery;

/**
 * 访问日志管理 数据封装层
 *
 * @author springcool
 */
public interface ISysLoginLogManager extends IBaseManager<SysLoginLogQuery, SysLoginLogDto> {

    /**
     * 清空系统登录日志
     */
    void cleanLoginLog();
}
