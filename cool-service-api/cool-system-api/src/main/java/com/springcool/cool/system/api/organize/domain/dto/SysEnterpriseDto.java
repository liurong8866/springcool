package com.springcool.cool.system.api.organize.domain.dto;

import cn.hutool.core.util.StrUtil;
import com.springcool.cool.system.api.organize.domain.po.SysEnterprisePo;
import com.springcool.cool.common.core.constant.system.AuthorityConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 企业 数据传输对象
 *
 * @author springcool
 */
public class SysEnterpriseDto extends SysEnterprisePo {

    private static final long serialVersionUID = 1L;

    public boolean isAdmin() {
        return isAdmin(getIsLessor());
    }

    public static boolean isAdmin(String isLessor) {
        return StrUtil.equals(AuthorityConstants.TenantType.ADMIN.getCode(), isLessor);
    }
}
