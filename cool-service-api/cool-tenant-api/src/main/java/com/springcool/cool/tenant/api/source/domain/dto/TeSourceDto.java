package com.springcool.cool.tenant.api.source.domain.dto;

import com.springcool.cool.tenant.api.source.domain.po.TeSourcePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 数据源 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeSourceDto extends TeSourcePo {

    private static final long serialVersionUID = 1L;

    /** 源同步策略（0不变 1刷新 2启动 3删除） */
    private String syncType;
}