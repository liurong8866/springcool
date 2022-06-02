package com.springcool.cool.system.organize.mapper.merge;

import com.springcool.cool.system.organize.domain.merge.SysRoleDeptMerge;
import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BasicMapper;

/**
 * 角色-部门关联（权限范围） 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysRoleDeptMergeMapper extends BasicMapper<SysRoleDeptMerge> {
}