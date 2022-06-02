package com.springcool.cool.system.api.authority.domain.model;

import com.springcool.cool.system.api.authority.domain.query.SysModuleQuery;
import com.springcool.cool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.cool.system.api.authority.domain.po.SysModulePo;
import com.springcool.cool.common.core.web.entity.model.SubBaseConverter;
import org.mapstruct.Mapper;

/**
 * 模块 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysModuleConverter extends SubBaseConverter<SysModuleQuery, SysModuleDto, SysModulePo> {
}
