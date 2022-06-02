package com.springcool.cool.job.api.domain.dto;

import com.springcool.cool.job.api.domain.po.SysJobPo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 调度任务 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysJobDto extends SysJobPo {

    private static final long serialVersionUID = 1L;
}
