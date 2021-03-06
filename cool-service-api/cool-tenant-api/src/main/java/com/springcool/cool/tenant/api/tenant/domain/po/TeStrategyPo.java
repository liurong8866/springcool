package com.springcool.cool.tenant.api.tenant.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据源策略 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("te_strategy")
public class TeStrategyPo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 数据源Id */
    @Excel(name = "数据源Id")
    @TableField("source_id")
    private Long sourceId;

    /** 数据源编码 */
    @Excel(name = "数据源编码")
    @TableField("source_slave")
    private String sourceSlave;

    /** 默认策略（Y是 N否） */
    @Excel(name = "默认策略", readConverterExp = "Y=是,N=否")
    @TableField("is_default")
    private String isDefault;
}