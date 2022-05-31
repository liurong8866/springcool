package com.springcool.system.api.authority.domain.model;

import com.springcool.system.api.authority.domain.dto.SysRoleDto;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.authority.domain.po.SysRolePo;
import com.springcool.system.api.authority.domain.query.SysRoleQuery;
import org.mapstruct.Mapper;

/**
 * 角色 对象映射器
 *
 * @author xueyi
 */
@Mapper(componentModel = "spring")
public interface SysRoleConverter extends BaseConverter<SysRoleQuery, SysRoleDto, SysRolePo> {
}
