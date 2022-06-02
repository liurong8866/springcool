package com.springcool.cool.system.domain.po;

import com.springcool.common.core.web.entity.base.BaseEntity;
import com.springcool.cool.system.domain.dto.SysJobDto;
import com.baomidou.mybatisplus.annotation.TableField;
import Excel;

/**
 * 定时任务调度 持久化对象
 *
 * @author springcool
 */
@TableName(value = "sys_job", excludeProperty = {"createBy","createTime","updateBy","name","remark","updateTime","id","sort","delFlag","status"})
public class SysJobPo extends BaseEntity {

    private static final long serialVersionUID = 1L;

}