package com.springcool.cool.system.api.dict.domain.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 参数配置 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_config", excludeProperty = {"status", "delFlag"})
public class SysConfigPo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 参数键名 */
    @Excel(name = "参数键名")
    @TableField(value = "code", updateStrategy = FieldStrategy.NEVER)
    private String code;

    /** 参数键值 */
    @Excel(name = "参数键值")
    @TableField("value")
    private String value;

    /** 系统内置（Y是 N否） */
    @Excel(name = "系统内置", readConverterExp = "Y=是,N=否")
    @TableField(value = "type", updateStrategy = FieldStrategy.NEVER)
    private String type;
}
