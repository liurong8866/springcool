package com.springcool.cool.common.core.web.tenant.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.base.TreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Tree 租户基类
 *
 * @param <D> Dto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TTreeEntity<D> extends TreeEntity<D> {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;
}
