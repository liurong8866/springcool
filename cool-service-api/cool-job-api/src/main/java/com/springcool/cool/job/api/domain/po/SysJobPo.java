package com.springcool.cool.job.api.domain.po;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.tenant.base.TSubBaseEntity;
import com.springcool.cool.job.api.domain.dto.SysJobLogDto;
import com.springcool.cool.job.api.utils.CronUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 调度任务 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_job", excludeProperty = {"sort"})
public class SysJobPo extends TSubBaseEntity<SysJobLogDto> {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "任务名称不能为空")
    @Size(min = 0, max = 64, message = "任务名称不能超过64个字符")
    public String name;

    /** 任务组名 */
    @Excel(name = "任务组名")
    @TableField("job_group")
    private String jobGroup;

    /** 调用目标字符串 */
    @Excel(name = "调用目标字符串")
    @TableField("invoke_target")
    private String invokeTarget;

    /** 调用租户字符串 */
    @TableField(value = "invoke_tenant", updateStrategy = FieldStrategy.NEVER)
    private String invokeTenant;

    /** cron执行表达式 */
    @Excel(name = "cron执行表达式")
    @TableField("cron_expression")
    private String cronExpression;

    /** 计划执行错误策略（0默认 1立即执行 2执行一次 3放弃执行） */
    @Excel(name = "计划执行错误策略", readConverterExp = "0=默认,1=立即执行,2=执行一次,3=放弃执行")
    @TableField("misfire_policy")
    private String misfirePolicy;

    /** 是否并发执行（0允许 1禁止） */
    @Excel(name = "是否并发执行", readConverterExp = "0=允许,1=禁止")
    @TableField("concurrent")
    private String concurrent;

    /** 状态（0正常 1暂停） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=暂停")
    @TableField("status")
    private String status;

    @NotBlank(message = "调用目标字符串不能为空")
    @Size(min = 0, max = 500, message = "调用目标字符串长度不能超过500个字符")
    public String getInvokeTarget() {
        return invokeTarget;
    }

    @NotBlank(message = "Cron执行表达式不能为空")
    @Size(min = 0, max = 255, message = "Cron执行表达式不能超过255个字符")
    public String getCronExpression() {
        return cronExpression;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getNextValidTime() {
        return StrUtil.isNotEmpty(cronExpression) ? CronUtils.getNextExecution(cronExpression) : null;
    }

}
