package com.springcool.cool.system.organize.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户-岗位关联 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_post_merge")
public class SysUserPostMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 用户Id */
    @TableField("user_id")
    private Long userId;

    /** 岗位Id */
    @TableField("post_id")
    private Long postId;

    public SysUserPostMerge() {
    }

    public SysUserPostMerge(Long userId, Long postId) {
        setUserId(userId);
        setPostId(postId);
    }
}
