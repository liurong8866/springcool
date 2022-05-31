package com.springcool.system.api.log.domain.model;

import com.springcool.system.api.log.domain.po.SysLoginLogPo;
import com.springcool.system.api.log.domain.query.SysLoginLogQuery;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.log.domain.dto.SysLoginLogDto;
import org.mapstruct.Mapper;

/**
 * 访问日志 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysLoginLogConverter extends BaseConverter<SysLoginLogQuery, SysLoginLogDto, SysLoginLogPo> {
}
