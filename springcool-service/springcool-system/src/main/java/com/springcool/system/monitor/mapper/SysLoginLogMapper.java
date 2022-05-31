package com.springcool.system.monitor.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.system.api.log.domain.po.SysLoginLogPo;
import com.springcool.system.api.log.domain.query.SysLoginLogQuery;

/**
 * 访问日志管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysLoginLogMapper extends BaseMapper<SysLoginLogQuery, SysLoginLogDto, SysLoginLogPo> {
}
