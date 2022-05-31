package com.springcool.common.core.web.entity.common;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.common.core.web.entity.base.SubBaseEntity;
import com.springcool.common.core.constant.basic.DictConstants;
import com.springcool.common.core.utils.StringUtils;

/**
 * SubBase 混合基类
 *
 * @param <S> SubDto
 * @author springcool
 */
public class CSubBaseEntity<S> extends SubBaseEntity<S> {

    private static final long serialVersionUID = 1L;

    /** 公共数据（Y是 N否） */
    @TableField(value = "is_common", updateStrategy = FieldStrategy.NEVER)
    private String isCommon;

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon;
    }

    /** 校验是否为公共数据 */
    public boolean isCommon(){
        return StringUtils.equals(DictConstants.DicCommonPrivate.COMMON.getCode(), getIsCommon());
    }

    /** 校验是否非公共数据 */
    public boolean isNotCommon(){
        return !isCommon();
    }
}
