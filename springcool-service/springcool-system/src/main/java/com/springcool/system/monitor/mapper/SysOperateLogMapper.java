package com.springcool.system.monitor.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.system.api.log.domain.po.SysOperateLogPo;
import com.springcool.system.api.log.domain.query.SysOperateLogQuery;

/**
 * 操作日志管理 数据层
 *
 * @author xueyi
 */
@Isolate
public interface SysOperateLogMapper extends BaseMapper<SysOperateLogQuery, SysOperateLogDto, SysOperateLogPo> {
}
