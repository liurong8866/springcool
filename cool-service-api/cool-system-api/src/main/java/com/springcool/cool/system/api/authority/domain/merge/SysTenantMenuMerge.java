package com.springcool.cool.system.api.authority.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户-菜单关联 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_tenant_menu_merge")
public class SysTenantMenuMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 菜单Id */
    @TableField("menu_id")
    private Long menuId;

    public SysTenantMenuMerge() {
    }

    public SysTenantMenuMerge(Long menuId) {
        setMenuId(menuId);
    }
}
