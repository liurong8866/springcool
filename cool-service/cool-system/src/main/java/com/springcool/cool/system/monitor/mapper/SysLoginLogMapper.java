package com.springcool.cool.system.monitor.mapper;

import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.cool.system.api.log.domain.po.SysLoginLogPo;
import com.springcool.cool.system.api.log.domain.query.SysLoginLogQuery;

/**
 * 访问日志管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysLoginLogMapper extends BaseMapper<SysLoginLogQuery, SysLoginLogDto, SysLoginLogPo> {
}
