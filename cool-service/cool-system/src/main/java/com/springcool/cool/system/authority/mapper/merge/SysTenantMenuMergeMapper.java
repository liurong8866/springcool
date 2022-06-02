package com.springcool.cool.system.authority.mapper.merge;

import com.springcool.cool.system.authority.domain.merge.SysTenantMenuMerge;
import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BasicMapper;

/**
 * 租户-菜单关联 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysTenantMenuMergeMapper extends BasicMapper<SysTenantMenuMerge> {
}
