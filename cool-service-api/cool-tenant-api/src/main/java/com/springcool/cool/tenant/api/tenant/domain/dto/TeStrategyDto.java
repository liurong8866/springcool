package com.springcool.cool.tenant.api.tenant.domain.dto;

import com.springcool.cool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.cool.tenant.api.tenant.domain.po.TeStrategyPo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 数据源策略 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeStrategyDto extends TeStrategyPo {

    private static final long serialVersionUID = 1L;

    /** 数据源信息 */
    private TeSourceDto source;
}