package com.springcool.cool.common.core.web.tenant.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.base.BasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Basis 租户基类
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TBasisEntity extends BasisEntity {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
