package com.springcool.cool.system.authority.mapper.merge;

import com.springcool.cool.system.api.authority.domain.merge.SysTenantModuleMerge;
import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BasicMapper;

/**
 * 租户-模块关联 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysTenantModuleMergeMapper extends BasicMapper<SysTenantModuleMerge> {
}
