package com.springcool.system.notice.domain.dto;

import com.springcool.system.notice.domain.po.SysNoticePo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 通知公告 数据传输对象
 *
 * @author springcool
 */
public class SysNoticeDto extends SysNoticePo {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("type", getType())
                .append("content", getContent())
                .append("status", getStatus())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createName", getCreateName())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateName", getUpdateName())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
