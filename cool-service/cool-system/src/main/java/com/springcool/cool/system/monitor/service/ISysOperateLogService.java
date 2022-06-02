package com.springcool.cool.system.monitor.service;

import com.springcool.cool.common.web.entity.service.IBaseService;
import com.springcool.cool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.cool.system.api.log.domain.query.SysOperateLogQuery;

/**
 * 操作日志管理 服务层
 *
 * @author springcool
 */
public interface ISysOperateLogService extends IBaseService<SysOperateLogQuery, SysOperateLogDto> {

    /**
     * 清空操作日志
     */
    void cleanOperateLog();
}
