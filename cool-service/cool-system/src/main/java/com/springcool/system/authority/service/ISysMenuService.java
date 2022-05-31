package com.springcool.system.authority.service;

import com.springcool.common.web.entity.service.ITreeService;
import com.springcool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.system.utils.route.RouterVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 菜单管理 服务层
 *
 * @author springcool
 */
public interface ISysMenuService extends ITreeService<SysMenuQuery, SysMenuDto> {

    /**
     * 登录校验 | 获取租户全部菜单权限标识集合
     *
     * @return 菜单权限集合
     */
    Set<String> loginPermission();

    /**
     * 登录校验 | 获取菜单权限标识集合
     *
     * @param roleIds 角色Id集合
     * @return 菜单权限集合
     */
    Set<String> loginPermission(Set<Long> roleIds);

    /**
     * 登录校验 | 获取全部路由路径集合
     *
     * @return 路径集合
     */
    Map<String, String> getLessorRouteMap();

    /**
     * 登录校验 | 获取租户全部路由路径集合
     *
     * @return 路径集合
     */
    Map<String, String> getRouteMap();

    /**
     * 登录校验 | 获取路由路径集合
     *
     * @param roleIds 角色Id集合
     * @return 路径集合
     */
    Map<String, String> getRouteMap(Set<Long> roleIds);

    /**
     * 根据模块Id查询菜单路由
     *
     * @param moduleId 模块Id
     * @return 菜单列表
     */
    List<SysMenuDto> getRoutes(Long moduleId);

    /**
     * 根据菜单类型及模块Id获取可配菜单集
     *
     * @param moduleId 模块Id
     * @param menuType 菜单类型
     * @return 菜单列表
     */
    List<SysMenuDto> getMenuByMenuType(Long moduleId, String menuType);

    /**
     * 校验菜单是否存在租户
     *
     * @param id 菜单Id
     * @return 结果 | true/false 有/无
     */
    boolean checkMenuExistTenant(Long id);

    /**
     * 校验菜单是否存在角色
     *
     * @param id 菜单Id
     * @return 结果 | true/false 有/无
     */
    boolean checkMenuExistRole(Long id);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    List<RouterVo> buildMenus(List<SysMenuDto> menus);
}