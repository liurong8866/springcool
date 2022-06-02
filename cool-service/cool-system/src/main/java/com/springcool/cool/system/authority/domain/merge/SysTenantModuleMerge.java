package com.springcool.cool.system.authority.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.web.tenant.base.TBasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户-模块关联 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_tenant_module_merge")
public class SysTenantModuleMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 模块Id */
    @TableField("module_id")
    private Long moduleId;

    public SysTenantModuleMerge() {
    }

    public SysTenantModuleMerge(Long moduleId) {
        setModuleId(moduleId);
    }
}
