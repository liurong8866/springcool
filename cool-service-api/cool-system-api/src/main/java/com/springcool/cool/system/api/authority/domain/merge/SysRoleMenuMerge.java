package com.springcool.cool.system.api.authority.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 角色-菜单关联 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu_merge")
public class SysRoleMenuMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 角色Id */
    @TableField("role_id")
    private Long roleId;

    /** 菜单Id */
    @TableField("menu_id")
    private Long menuId;

    public SysRoleMenuMerge() {
    }

    public SysRoleMenuMerge(Long roleId, Long menuId) {
        setRoleId(roleId);
        setMenuId(menuId);
    }
}
