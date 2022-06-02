package com.springcool.cool.common.core.web.tenant.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.common.CBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Base 租户混合基类
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TCBaseEntity extends CBaseEntity {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
