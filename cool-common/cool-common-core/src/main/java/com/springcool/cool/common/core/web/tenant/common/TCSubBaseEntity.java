package com.springcool.cool.common.core.web.tenant.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.common.CSubBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SubBase 租户混合基类
 *
 * @param <S> SubDto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TCSubBaseEntity<S> extends CSubBaseEntity<S> {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
