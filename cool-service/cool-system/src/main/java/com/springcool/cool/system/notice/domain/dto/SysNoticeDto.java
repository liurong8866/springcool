package com.springcool.cool.system.notice.domain.dto;

import com.springcool.cool.system.notice.domain.po.SysNoticePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 通知公告 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysNoticeDto extends SysNoticePo {

    private static final long serialVersionUID = 1L;
}
