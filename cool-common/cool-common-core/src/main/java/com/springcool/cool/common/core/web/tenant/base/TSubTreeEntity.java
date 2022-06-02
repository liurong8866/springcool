package com.springcool.cool.common.core.web.tenant.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.base.SubTreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SubTree 租户基类
 *
 * @param <D> Dto
 * @param <S> SubDto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TSubTreeEntity<D, S> extends SubTreeEntity<D, S> {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
