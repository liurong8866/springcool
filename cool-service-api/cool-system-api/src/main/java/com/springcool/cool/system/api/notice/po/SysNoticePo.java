package com.springcool.cool.system.api.notice.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通知公告 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_notice",excludeProperty = {"sort"})
public class SysNoticePo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 公告类型（0通知 1公告） */
    @Excel(name = "公告类型", readConverterExp = "0=通知,1=公告")
    @TableField("type")
    private String type;

    /** 公告内容 */
    @Excel(name = "公告内容")
    @TableField("content")
    private String content;

    /** 公告状态（0未发送 1已发送） */
    @Excel(name = "公告状态", readConverterExp = "0=未发送,1=已发送")
    @TableField("status")
    private String status;
}
