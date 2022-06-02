package com.springcool.cool.system.api.authority.domain.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.tenant.common.TCTreeEntity;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 菜单 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenuPo extends TCTreeEntity<SysMenuDto> {

    private static final long serialVersionUID = 1L;

    /** 模块Id */
    @TableField("module_id")
    @NotNull(message = "模块Id不能为空")
    private Long moduleId;

    /** 菜单标题 | 多语言 */
    @Excel(name = "菜单标题")
    @TableField("title")
    private String title;

    /** 路由地址 */
    @Excel(name = "路由地址")
    @TableField(value = "path", updateStrategy = FieldStrategy.IGNORED)
    private String path;

    /** 外链地址 | 仅页面类型为外链时生效 */
    @Excel(name = "外链地址")
    @TableField(value = "frame_src", updateStrategy = FieldStrategy.IGNORED)
    private String frameSrc;

    /** 组件路径 */
    @Excel(name = "组件路径")
    @TableField(value = "component", updateStrategy = FieldStrategy.IGNORED)
    private String component;

    /** 路由参数 */
    @Excel(name = "路由参数")
    @TableField(value = "param_path", updateStrategy = FieldStrategy.IGNORED)
    private String paramPath;

    /** 路由切换动画 */
    @Excel(name = "路由切换动画")
    @TableField("transition_name")
    private String transitionName;

    /** 是否忽略路由（Y是 N否） */
    @Excel(name = "是否忽略路由", readConverterExp = "Y=是,N=否")
    @TableField("ignore_route")
    private String ignoreRoute;

    /** 是否缓存（Y是 N否） */
    @Excel(name = "是否缓存", readConverterExp = "Y=是,N=否")
    @TableField("is_cache")
    private String isCache;

    /** 是否固定标签（Y是 N否） */
    @Excel(name = "是否固定标签", readConverterExp = "Y=是,N=否")
    @TableField("is_affix")
    private String isAffix;

    /** 是否禁用（Y是 N否） */
    @Excel(name = "是否禁用", readConverterExp = "Y=是,N=否")
    @TableField("is_disabled")
    private String isDisabled;

    /** 页面类型（0常规 1内嵌 2外链） */
    @Excel(name = "页面类型", readConverterExp = "0=常规,1=内嵌,2=外链")
    @TableField("frame_type")
    private String frameType;

    /** 菜单类型（M目录 C菜单 X详情 F按钮） */
    @Excel(name = "菜单类型", readConverterExp = "M=目录,C=菜单,X=详情,F=按钮")
    @TableField("menu_type")
    private String menuType;

    /** 标签显隐状态（Y隐藏 N显示） */
    @Excel(name = "标签显隐状态", readConverterExp = "Y=隐藏,N=显示")
    @TableField("hide_tab")
    private String hideTab;

    /** 菜单显隐状态（Y隐藏 N显示） */
    @Excel(name = "菜单显隐状态", readConverterExp = "Y=隐藏,N=显示")
    @TableField("hide_menu")
    private String hideMenu;

    /** 面包屑路由显隐状态（Y隐藏 N显示） */
    @Excel(name = "面包屑路由显隐状态", readConverterExp = "Y=隐藏,N=显示")
    @TableField("hide_breadcrumb")
    private String hideBreadcrumb;

    /** 子菜单显隐状态（Y隐藏 N显示） */
    @Excel(name = "子菜单显隐状态", readConverterExp = "Y=隐藏,N=显示")
    @TableField("hide_children")
    private String hideChildren;

    /** 是否在子级菜单的完整path中忽略本级path（Y隐藏 N显示） */
    @Excel(name = "是否在子级菜单的完整path中忽略本级path", readConverterExp = "Y=隐藏,N=显示")
    @TableField("hide_path_for_children")
    private String hidePathForChildren;

    /** 详情页可打开Tab页数 */
    @Excel(name = "详情页可打开Tab页数")
    @TableField("dynamic_level")
    private Integer dynamicLevel;

    /** 详情页的实际Path */
    @Excel(name = "详情页的实际Path")
    @TableField(value = "real_path", updateStrategy = FieldStrategy.IGNORED)
    private String realPath;

    /** 权限标识 */
    @Excel(name = "权限标识")
    @TableField(value = "perms", updateStrategy = FieldStrategy.IGNORED)
    private String perms;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    @TableField(value = "icon", updateStrategy = FieldStrategy.IGNORED)
    private String icon;

    /** 默认菜单（Y是 N否） */
    @Excel(name = "默认菜单", readConverterExp = "Y=是,N=否")
    @TableField("is_default")
    private String isDefault;
}
