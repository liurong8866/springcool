package com.springcool.cool.system.api.log.domain.model;

import com.springcool.cool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.cool.system.api.log.domain.po.SysLoginLogPo;
import com.springcool.cool.system.api.log.domain.query.SysLoginLogQuery;
import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import org.mapstruct.Mapper;

/**
 * 访问日志 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysLoginLogConverter extends BaseConverter<SysLoginLogQuery, SysLoginLogDto, SysLoginLogPo> {
}
