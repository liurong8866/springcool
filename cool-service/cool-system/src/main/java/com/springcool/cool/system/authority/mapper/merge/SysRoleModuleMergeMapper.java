package com.springcool.cool.system.authority.mapper.merge;

import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BasicMapper;
import com.springcool.cool.system.api.authority.domain.merge.SysRoleModuleMerge;

/**
 * 角色-模块关联 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysRoleModuleMergeMapper extends BasicMapper<SysRoleModuleMerge> {
}
