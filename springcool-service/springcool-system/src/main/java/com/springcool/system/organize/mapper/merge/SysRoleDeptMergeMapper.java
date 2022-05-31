package com.springcool.system.organize.mapper.merge;

import com.springcool.system.organize.domain.merge.SysRoleDeptMerge;
import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BasicMapper;

/**
 * 角色-部门关联（权限范围） 数据层
 *
 * @author xueyi
 */
@Isolate
public interface SysRoleDeptMergeMapper extends BasicMapper<SysRoleDeptMerge> {
}