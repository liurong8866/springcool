package com.springcool.cool.system.api.source.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 源策略 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "te_strategy", excludeProperty = {"name", "sort", "remark", "createBy", "createTime", "updateBy", "updateTime"})
public class Source extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主写源 */
    @TableField("source_slave")
    String master;
}