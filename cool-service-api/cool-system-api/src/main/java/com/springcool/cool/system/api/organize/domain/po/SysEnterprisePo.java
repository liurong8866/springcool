package com.springcool.cool.system.api.organize.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import com.springcool.cool.common.core.xss.Xss;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 企业 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("te_tenant")
public class SysEnterprisePo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 策略Id */
    @TableField("strategy_id")
    private Long strategyId;

    /** 系统名称 */
    @Xss(message = "系统名称不能包含脚本字符")
    @NotBlank(message = "系统名称不能为空")
    @Size(max = 30, message = "系统名称长度不能超过30个字符")
    @TableField("system_name")
    private String systemName;

    /** 企业名称 */
    @Xss(message = "企业名称不能包含脚本字符")
    @NotBlank(message = "企业名称不能为空")
    @Size(max = 30, message = "企业名称长度不能超过30个字符")
    @TableField("nick")
    private String nick;

    /** 企业logo */
    @TableField("logo")
    private String logo;

    /** 超管租户（Y是 N否） */
    @TableField("is_lessor")
    private String isLessor;

    /** 企业账号修改次数 */
    @TableField("name_frequency")
    private Long nameFrequency;

    /** 默认企业（Y是 N否） */
    @TableField("is_default")
    private String isDefault;

    @Override
    @Xss(message = "企业账号不能包含脚本字符")
    @NotBlank(message = "企业账号不能为空")
    @Size(max = 30, message = "企业账号长度不能超过30个字符")
    public String getName() {
        return super.getName();
    }

}
