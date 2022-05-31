package com.springcool.system.api.authority.domain.model;

import com.springcool.system.api.authority.domain.po.SysMenuPo;
import com.springcool.common.core.web.entity.model.TreeConverter;
import com.springcool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.system.api.authority.domain.query.SysMenuQuery;
import org.mapstruct.Mapper;

/**
 * 菜单 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysMenuConverter extends TreeConverter<SysMenuQuery, SysMenuDto, SysMenuPo> {
}
