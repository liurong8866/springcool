package com.springcool.cool.system.organize.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.constant.system.OrganizeConstants;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织-角色关联（角色绑定） 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_organize_role_merge")
public class SysOrganizeRoleMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 部门Id */
    @TableField("dept_id")
    private Long deptId;

    /** 岗位Id */
    @TableField("post_id")
    private Long postId;

    /** 用户Id */
    @TableField("user_id")
    private Long userId;

    /** 角色Id */
    @TableField("role_id")
    private Long roleId;

    public SysOrganizeRoleMerge() {
    }

    public SysOrganizeRoleMerge(Long organizeId, Long roleId, OrganizeConstants.OrganizeType organizeType) {
        switch (organizeType) {
            case DEPT:
                setDeptId(organizeId);
                break;
            case POST:
                setPostId(organizeId);
                break;
            case USER:
                setUserId(organizeId);
                break;
        }
        setRoleId(roleId);
    }
}
