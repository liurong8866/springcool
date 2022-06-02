package com.springcool.cool.system.authority.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色-模块关联 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_module_merge")
public class SysRoleModuleMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 角色Id */
    @TableField("role_id")
    private Long roleId;

    /** 模块Id */
    @TableField("module_id")
    private Long moduleId;

    public SysRoleModuleMerge() {
    }

    public SysRoleModuleMerge(Long roleId, Long moduleId) {
        setRoleId(roleId);
        setModuleId(moduleId);
    }
}
