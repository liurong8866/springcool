package com.springcool.cool.system.authority.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.SubBaseMapper;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.cool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.cool.system.api.authority.domain.po.SysMenuPo;
import com.springcool.cool.system.api.authority.domain.po.SysModulePo;
import com.springcool.cool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.cool.system.api.authority.domain.query.SysModuleQuery;

/**
 * 角色管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysModuleMapper extends SubBaseMapper<SysModuleQuery, SysModuleDto, SysModulePo, SysMenuQuery, SysMenuDto, SysMenuPo> {
}
