package com.springcool.cool.system.api.notice.dto;

import com.springcool.cool.system.api.notice.po.SysNoticePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
