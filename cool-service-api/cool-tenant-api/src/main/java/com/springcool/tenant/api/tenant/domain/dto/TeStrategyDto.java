package com.springcool.tenant.api.tenant.domain.dto;

import com.springcool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.tenant.api.tenant.domain.po.TeStrategyPo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 数据源策略 数据传输对象
 *
 * @author springcool
 */
public class TeStrategyDto extends TeStrategyPo {

    private static final long serialVersionUID = 1L;

    /** 数据源信息 */
    private TeSourceDto source;

    public TeSourceDto getSource() {
        return source;
    }

    public void setSource(TeSourceDto source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sourceId", getSourceId())
            .append("source", getSource())
            .append("sourceSlave", getSourceSlave())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createName", getCreateName())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateName", getUpdateName())
            .append("updateTime", getUpdateTime())
            .append("isDefault", getIsDefault())
            .toString();
    }
}