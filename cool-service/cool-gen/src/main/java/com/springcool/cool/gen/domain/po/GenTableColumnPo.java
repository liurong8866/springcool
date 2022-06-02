package com.springcool.cool.gen.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 业务字段 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "gen_table_column", excludeProperty = {"status", "remark", "delFlag"})
public class GenTableColumnPo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 归属表Id */
    @TableField("table_id")
    private Long tableId;

    /** 列描述 */
    @TableField("comment")
    private String comment;

    /** 列类型 */
    @TableField("type")
    private String type;

    /** JAVA类型 */
    @TableField("java_type")
    private String javaType;

    /** JAVA字段名 */
    @NotBlank(message = "Java属性不能为空")
    @TableField("java_field")
    private String javaField;

    /** 主键字段（Y是 N否） */
    @TableField("is_pk")
    private Boolean isPk;

    /** 自增字段（Y是 N否） */
    @TableField("is_increment")
    private Boolean isIncrement;

    /** 必填字段（Y是 N否） */
    @TableField("is_required")
    private Boolean isRequired;

    /** 查看字段（Y是 N否） */
    @TableField("is_view")
    private Boolean isView;

    /** 新增字段（Y是 N否） */
    @TableField("is_insert")
    private Boolean isInsert;

    /** 编辑字段（Y是 N否） */
    @TableField("is_edit")
    private Boolean isEdit;

    /** 列表字段（Y是 N否） */
    @TableField("is_list")
    private Boolean isList;

    /** 查询字段（Y是 N否） */
    @TableField("is_query")
    private Boolean isQuery;

    /** 唯一字段（Y是 N否） */
    @TableField("is_unique")
    private Boolean isUnique;

    /** 导入字段（1是 0否） */
    @TableField("is_import")
    private Boolean isImport;

    /** 导出字段（1是 0否） */
    @TableField("is_export")
    private Boolean isExport;

    /** 隐藏字段（1是 0否） */
    @TableField("is_hide")
    private Boolean isHide;

    /** 覆盖字段（1是 0否） */
    @TableField("is_cover")
    private Boolean isCover;

    /** 查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围） */
    @TableField("query_type")
    private String queryType;

    /** 显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件） */
    @TableField("html_type")
    private String htmlType;

    /** 字典类型 */
    @TableField("dict_type")
    private String dictType;
}