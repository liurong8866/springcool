package com.springcool.system.authority.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.SubBaseMapper;
import com.springcool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.system.api.authority.domain.po.SysMenuPo;
import com.springcool.system.api.authority.domain.po.SysModulePo;
import com.springcool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.system.api.authority.domain.query.SysModuleQuery;

/**
 * 角色管理 数据层
 *
 * @author xueyi
 */
@Master
public interface SysModuleMapper extends SubBaseMapper<SysModuleQuery, SysModuleDto, SysModulePo, SysMenuQuery, SysMenuDto, SysMenuPo> {
}
