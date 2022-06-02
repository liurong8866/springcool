package com.springcool.cool.system.api.authority.domain.model;

import com.springcool.cool.system.api.authority.domain.dto.SysRoleDto;
import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import com.springcool.cool.system.api.authority.domain.po.SysRolePo;
import com.springcool.cool.system.api.authority.domain.query.SysRoleQuery;
import org.mapstruct.Mapper;

/**
 * 角色 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysRoleConverter extends BaseConverter<SysRoleQuery, SysRoleDto, SysRolePo> {
}
