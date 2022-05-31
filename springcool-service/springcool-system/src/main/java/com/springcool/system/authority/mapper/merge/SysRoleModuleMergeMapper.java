package com.springcool.system.authority.mapper.merge;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BasicMapper;
import com.springcool.system.authority.domain.merge.SysRoleModuleMerge;

/**
 * 角色-模块关联 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysRoleModuleMergeMapper extends BasicMapper<SysRoleModuleMerge> {
}
