package com.springcool.system.authority.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.TreeMapper;
import com.springcool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.system.api.authority.domain.po.SysMenuPo;
import com.springcool.system.api.authority.domain.query.SysMenuQuery;

/**
 * 菜单管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysMenuMapper extends TreeMapper<SysMenuQuery, SysMenuDto, SysMenuPo> {
}
