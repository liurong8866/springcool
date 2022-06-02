package com.springcool.cool.system.api.authority.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.tenant.common.TCSubBaseEntity;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 模块 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_module")
public class SysModulePo extends TCSubBaseEntity<SysMenuDto> {

    private static final long serialVersionUID = 1L;

    /** 模块logo */
    @Excel(name = "模块logo")
    @TableField("logo")
    private String logo;

    /** 路由地址 */
    @Excel(name = "路由地址")
    @TableField("path")
    private String path;

    /** 路由参数 */
    @Excel(name = "路由参数")
    @TableField("param_path")
    private String paramPath;

    /** 模块类型（0常规 1内嵌 2外链） */
    @Excel(name = "模块类型", readConverterExp = "0=常规,1=内嵌,2=外链")
    @TableField("type")
    private String type;

    /** 模块显隐状态（Y隐藏 N显示） */
    @Excel(name = "模块显隐状态", readConverterExp = "Y=隐藏,N=显示")
    @TableField("hide_module")
    private String hideModule;

    /** 默认模块（Y是 N否） */
    @TableField("is_default")
    private String isDefault;
}
