package com.springcool.cool.system.domain.dto;

import com.springcool.cool.system.domain.po.SysJobPo;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 定时任务调度 数据传输对象
 *
 * @author springcool
 */
public class SysJobDto extends SysJobPo {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .toString();
    }
}