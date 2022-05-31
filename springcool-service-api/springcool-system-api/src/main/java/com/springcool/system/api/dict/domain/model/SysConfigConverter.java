package com.springcool.system.api.dict.domain.model;

import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.dict.domain.dto.SysConfigDto;
import com.springcool.system.api.dict.domain.po.SysConfigPo;
import com.springcool.system.api.dict.domain.query.SysConfigQuery;
import org.mapstruct.Mapper;

/**
 * 参数配置 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysConfigConverter extends BaseConverter<SysConfigQuery, SysConfigDto, SysConfigPo> {
}
