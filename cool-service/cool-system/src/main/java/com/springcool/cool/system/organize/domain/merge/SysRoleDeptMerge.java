package com.springcool.cool.system.organize.domain.merge;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色-部门关联（权限范围） 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_dept_merge")
public class SysRoleDeptMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 角色Id */
    @TableField("role_id")
    private Long roleId;

    /** 部门Id */
    @TableField("dept_id")
    private Long deptId;

    public SysRoleDeptMerge() {
    }

    public SysRoleDeptMerge(Long roleId, Long deptId) {
        setRoleId(roleId);
        setDeptId(deptId);
    }
}