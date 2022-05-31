package com.springcool.system.authority.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.springcool.system.authority.manager.ISysModuleManager;
import com.springcool.system.authority.service.ISysMenuService;
import com.springcool.system.authority.service.ISysModuleService;
import com.springcool.common.datascope.annotation.DataScope;
import com.springcool.common.web.entity.service.impl.SubBaseServiceImpl;
import com.springcool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.system.api.authority.domain.query.SysModuleQuery;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.springcool.common.core.constant.basic.SecurityConstants.CREATE_BY;

/**
 * 模块管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysModuleServiceImpl extends SubBaseServiceImpl<SysModuleQuery, SysModuleDto, ISysModuleManager, SysMenuQuery, SysMenuDto, ISysMenuService> implements ISysModuleService {

    /**
     * 当前用户首页可展示的模块路由
     *
     * @param roleIds 角色Ids
     * @return 模块集合
     */
    @Override
    public List<SysModuleDto> getRoutes(Set<Long> roleIds) {
        return baseManager.getRoutes(roleIds);
    }

    /**
     * 查询模块对象列表 | 数据权限 | 附加数据
     *
     * @param module 模块对象
     * @return 模块对象集合
     */
    @Override
    @DataScope(userAlias = CREATE_BY, mapperScope = {"SysModuleMapper"})
    public List<SysModuleDto> selectListScope(SysModuleQuery module) {
        return baseManager.selectListExtra(module);
    }

    /**
     * 设置子数据的外键值
     */
    @Override
    protected void setForeignKey(Collection<SysMenuDto> menuList, SysMenuDto menu, SysModuleDto module, Serializable key) {
        Long moduleId = ObjectUtil.isNotNull(module) ? module.getId() : (Long) key;
        if (ObjectUtil.isNotNull(menu))
            menu.setModuleId(moduleId);
        else
            menuList.forEach(sub -> sub.setModuleId(moduleId));
    }

}
