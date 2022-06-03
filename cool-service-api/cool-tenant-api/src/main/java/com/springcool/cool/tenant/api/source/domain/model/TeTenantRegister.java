package com.springcool.cool.tenant.api.source.domain.model;
import com.springcool.cool.common.core.web.entity.base.BasisEntity;
import com.springcool.cool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.dto.SysUserDto;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeTenantDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 租户初始化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeTenantRegister extends BasisEntity {

    private static final long serialVersionUID = 1L;

    /** 租户信息 */
    private TeTenantDto tenant;

    /** 部门信息 */
    private SysDeptDto dept;

    /** 岗位信息 */
    private SysPostDto post;

    /** 用户信息 */
    private SysUserDto user;

    /** 权限Ids */
    private Long[] authIds;
}
