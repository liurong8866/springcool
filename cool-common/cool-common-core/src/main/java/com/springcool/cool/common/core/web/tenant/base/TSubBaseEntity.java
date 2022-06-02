package com.springcool.cool.common.core.web.tenant.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.base.SubBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SubBase 租户基类
 *
 * @param <S> SubDto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TSubBaseEntity<S> extends SubBaseEntity<S> {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
