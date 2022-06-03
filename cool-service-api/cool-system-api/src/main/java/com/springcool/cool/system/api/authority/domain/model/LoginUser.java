package com.springcool.cool.system.api.authority.domain.model;

import com.springcool.cool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.cool.system.api.organize.domain.dto.SysUserDto;
import com.springcool.cool.system.api.source.domain.Source;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 用户信息
 *
 * @author springcool
 */
@Data
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户唯一标识 */
    private String token;

    /** 企业账号Id */
    private Long enterpriseId;

    /** 企业账号 */
    private String enterpriseName;

    /** 租户标识 */
    private String isLessor;

    /** 用户名Id */
    private Long userId;

    /** 用户名 */
    private String userName;

    /** 用户标识 */
    private String userType;

    /** 主数据源 */
    private String sourceName;

    /** 登录时间 */
    private Long loginTime;

    /** 过期时间 */
    private Long expireTime;

    /** 登录IP地址 */
    private String ipaddr;

    /** 权限列表 */
    private Set<String> permissions;

    /** 角色权限列表 */
    private Set<String> roles;

    /** 角色Id列表 */
    private Set<Long> roleIds;

    /** 源策略组 */
    private Source source;

    /** 企业信息 */
    private SysEnterpriseDto enterprise;

    /** 用户信息 */
    private SysUserDto user;

    /** 数据权限 */
    private DataScope scope;

    /** 模块路由列表 */
    private Object moduleRoute;

    /** 菜单路由列表 */
    private Map<String, Object> menuRoute;

    /** 路由路径映射列表 */
    private Map<String, String> routeURL;

    public Map<String, Object> getMenuRoute() {
        return menuRoute == null ? new HashMap<>() : menuRoute;
    }
}
