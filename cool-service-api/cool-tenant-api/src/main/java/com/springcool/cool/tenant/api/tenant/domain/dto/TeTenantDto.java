package com.springcool.cool.tenant.api.tenant.domain.dto;

import cn.hutool.core.util.StrUtil;
import com.springcool.cool.tenant.api.tenant.domain.po.TeTenantPo;
import com.springcool.cool.common.core.constant.system.AuthorityConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 租户 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeTenantDto extends TeTenantPo {

    private static final long serialVersionUID = 1L;

    /** 策略信息 */
    private TeStrategyDto strategy;

    /** 权限Ids */
    private Long[] authIds;

    /** 校验是否非租管租户 */
    public boolean isNotAdmin() {
        return !isAdmin(this.getIsLessor());
    }

    /** 校验是否为租管租户 */
    public boolean isAdmin() {
        return isAdmin(this.getIsLessor());
    }

    /** 校验是否为租管租户 */
    public static boolean isAdmin(String isLessor) {
        return StrUtil.equals(AuthorityConstants.TenantType.ADMIN.getCode(), isLessor);
    }
}