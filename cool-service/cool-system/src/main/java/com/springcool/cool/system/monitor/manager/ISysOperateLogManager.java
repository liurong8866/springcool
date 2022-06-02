package com.springcool.cool.system.monitor.manager;

import com.springcool.cool.common.web.entity.manager.IBaseManager;
import com.springcool.cool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.cool.system.api.log.domain.query.SysOperateLogQuery;

/**
 * 操作日志管理 数据封装层
 *
 * @author springcool
 */
public interface ISysOperateLogManager extends IBaseManager<SysOperateLogQuery, SysOperateLogDto> {

    /**
     * 清空系统操作日志
     */
    void cleanOperateLog();
}
