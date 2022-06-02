package com.springcool.cool.gen.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.gen.domain.dto.GenTableColumnDto;
import com.springcool.cool.common.core.web.entity.base.SubBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * 业务 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "gen_table", excludeProperty = {"status", "sort", "delFlag"})
public class GenTablePo extends SubBaseEntity<GenTableColumnDto> {

    private static final long serialVersionUID = 1L;

    /** 表描述 */
    @NotBlank(message = "表描述不能为空")
    @TableField(value = "comment", condition = LIKE)
    private String comment;

    /** 实体类名称(首字母大写) */
    @NotBlank(message = "实体类名称不能为空")
    @TableField("class_name")
    private String className;

    /** 实体类名称前缀(首字母大写) */
    @TableField("prefix")
    private String prefix;

    /** 使用的模板（base单表操作 tree树表操作 subBase主子单表操作 subTree主子树表操作） */
    @TableField("tpl_category")
    private String tplCategory;

    /** 生成包路径 */
    @NotBlank(message = "生成包路径不能为空")
    @TableField("package_name")
    private String packageName;

    /** 生成模块路径 */
    @NotBlank(message = "生成模块路径不能为空")
    @TableField("module_name")
    private String moduleName;

    /** 生成业务名 */
    @NotBlank(message = "生成业务名不能为空")
    @TableField("business_name")
    private String businessName;

    /** 生成权限名 */
    @NotBlank(message = "生成权限名不能为空")
    @TableField("authority_name")
    private String authorityName;

    /** 生成功能名 */
    @NotBlank(message = "生成功能名不能为空")
    @TableField("function_name")
    private String functionName;

    /** 生成作者 */
    @NotBlank(message = "作者不能为空")
    @TableField("function_author")
    private String functionAuthor;

    /** 生成代码方式（0zip压缩包 1自定义路径） */
    @TableField("gen_type")
    private String genType;

    /** 后端生成路径（不填默认项目路径） */
    @TableField("gen_path")
    private String genPath;

    /** 前端生成路径（不填默认项目路径） */
    @TableField("ui_path")
    private String uiPath;

    /** 其它生成选项 */
    @TableField("options")
    private String options;
}