package com.springcool.cool.system.monitor.mapper;

import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.cool.system.api.log.domain.po.SysOperateLogPo;
import com.springcool.cool.system.api.log.domain.query.SysOperateLogQuery;

/**
 * 操作日志管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysOperateLogMapper extends BaseMapper<SysOperateLogQuery, SysOperateLogDto, SysOperateLogPo> {
}
