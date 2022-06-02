package com.springcool.cool.system.organize.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色-岗位关联（权限范围） 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_post_merge")
public class SysRolePostMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 角色Id */
    @TableField("role_id")
    private Long roleId;

    /** 岗位Id */
    @TableField("post_id")
    private Long postId;

    public SysRolePostMerge() {
    }

    public SysRolePostMerge(Long roleId, Long postId) {
        setRoleId(roleId);
        setPostId(postId);
    }
}