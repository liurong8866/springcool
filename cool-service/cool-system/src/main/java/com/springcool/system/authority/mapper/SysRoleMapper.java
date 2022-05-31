package com.springcool.system.authority.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.authority.domain.dto.SysRoleDto;
import com.springcool.system.api.authority.domain.po.SysRolePo;
import com.springcool.system.api.authority.domain.query.SysRoleQuery;

/**
 * 岗位管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysRoleMapper extends BaseMapper<SysRoleQuery, SysRoleDto, SysRolePo> {
}
