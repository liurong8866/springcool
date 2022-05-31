package com.springcool.system.authority.mapper.merge;

import com.springcool.system.authority.domain.merge.SysTenantMenuMerge;
import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BasicMapper;

/**
 * 租户-菜单关联 数据层
 *
 * @author xueyi
 */
@Isolate
public interface SysTenantMenuMergeMapper extends BasicMapper<SysTenantMenuMerge> {
}
