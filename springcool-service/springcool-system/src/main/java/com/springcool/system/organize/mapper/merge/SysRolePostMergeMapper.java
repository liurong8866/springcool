package com.springcool.system.organize.mapper.merge;

import com.springcool.system.organize.domain.merge.SysRolePostMerge;
import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BasicMapper;

/**
 * 角色-岗位关联（权限范围） 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysRolePostMergeMapper extends BasicMapper<SysRolePostMerge> {
}