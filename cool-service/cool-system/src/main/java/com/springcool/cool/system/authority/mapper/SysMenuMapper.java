package com.springcool.cool.system.authority.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.TreeMapper;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.cool.system.api.authority.domain.po.SysMenuPo;
import com.springcool.cool.system.api.authority.domain.query.SysMenuQuery;

/**
 * 菜单管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysMenuMapper extends TreeMapper<SysMenuQuery, SysMenuDto, SysMenuPo> {
}
