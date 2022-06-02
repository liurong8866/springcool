package com.springcool.cool.common.core.web.tenant.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.common.CSubTreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SubTree 租户混合基类
 *
 * @param <D> Dto
 * @param <S> SubDto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TCSubTreeEntity<D, S> extends CSubTreeEntity<D, S> {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
