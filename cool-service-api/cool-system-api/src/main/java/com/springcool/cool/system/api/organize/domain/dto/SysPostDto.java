package com.springcool.cool.system.api.organize.domain.dto;

import com.springcool.cool.system.api.authority.domain.dto.SysRoleDto;
import com.springcool.cool.system.api.organize.domain.po.SysPostPo;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.annotation.Excel.Type;
import com.springcool.cool.common.core.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 岗位 数据传输对象
 *
 * @author springcool
 */
public class SysPostDto extends SysPostPo {

    private static final long serialVersionUID = 1L;

    /** 部门对象 */
    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT),
            @Excel(name = "部门编码(*)", targetAttr = "deptCode", type = Type.IMPORT)
    })
    private SysDeptDto dept;

    /** 角色对象 */
    private List<SysRoleDto> roles;

    /** 角色组 */
    private Long[] roleIds;

    public SysDeptDto getDept() {
        return dept;
    }

    public void setDept(SysDeptDto dept) {
        this.dept = dept;
    }

    public List<SysRoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRoleDto> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("deptId", getDeptId())
                .append("code", getCode())
                .append("name", getName())
                .append("dept", getDept())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createName", getCreateName())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateName", getUpdateName())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}