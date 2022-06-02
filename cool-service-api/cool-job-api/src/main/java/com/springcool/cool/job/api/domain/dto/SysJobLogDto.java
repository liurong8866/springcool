package com.springcool.cool.job.api.domain.dto;

import com.springcool.cool.job.api.domain.po.SysJobLogPo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

/**
 * 调度日志 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysJobLogDto extends SysJobLogPo {

    private static final long serialVersionUID = 1L;

    /** 开始时间 */
    private LocalDateTime startTime;

    /** 停止时间 */
    private LocalDateTime stopTime;
}
