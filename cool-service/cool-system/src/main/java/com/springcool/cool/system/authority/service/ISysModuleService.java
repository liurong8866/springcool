package com.springcool.cool.system.authority.service;

import com.springcool.cool.common.web.entity.service.ISubBaseService;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.cool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.cool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.cool.system.api.authority.domain.query.SysModuleQuery;

import java.util.List;
import java.util.Set;

/**
 * 模块管理 服务层
 *
 * @author springcool
 */
public interface ISysModuleService extends ISubBaseService<SysModuleQuery, SysModuleDto, SysMenuQuery, SysMenuDto> {

    /**
     * 当前用户首页可展示的模块路由
     *
     * @param roleIds 角色Ids
     * @return 模块集合
     */
    List<SysModuleDto> getRoutes(Set<Long> roleIds);
}
