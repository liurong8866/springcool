package com.springcool.cool.system.organize.mapper.merge;

import com.springcool.cool.system.api.organize.domain.merge.SysRolePostMerge;
import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BasicMapper;

/**
 * 角色-岗位关联（权限范围） 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysRolePostMergeMapper extends BasicMapper<SysRolePostMerge> {
}