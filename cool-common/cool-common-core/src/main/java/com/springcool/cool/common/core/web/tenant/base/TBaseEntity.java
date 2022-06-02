package com.springcool.cool.common.core.web.tenant.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Base 租户基类
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TBaseEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
