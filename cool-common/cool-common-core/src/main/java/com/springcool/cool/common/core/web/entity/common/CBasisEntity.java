package com.springcool.cool.common.core.web.entity.common;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.web.entity.base.BasisEntity;
import com.springcool.cool.common.core.constant.basic.DictConstants;
import com.springcool.cool.common.core.utils.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Base 混合基类
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CBasisEntity extends BasisEntity {

    private static final long serialVersionUID = 1L;

    /** 公共数据（0是 1否） */
    @TableField(value = "is_common", updateStrategy = FieldStrategy.NEVER)
    private String isCommon;

    /** 校验是否为公共数据 */
    public boolean isCommon(){
        return StringUtils.equals(DictConstants.DicCommonPrivate.COMMON.getCode(), getIsCommon());
    }

    /** 校验是否非公共数据 */
    public boolean isNotCommon(){
        return !isCommon();
    }
}
