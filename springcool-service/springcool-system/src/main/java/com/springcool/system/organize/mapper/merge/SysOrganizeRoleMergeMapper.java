package com.springcool.system.organize.mapper.merge;

import com.springcool.system.organize.domain.merge.SysOrganizeRoleMerge;
import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BasicMapper;

/**
 * 组织-角色关联（角色绑定） 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysOrganizeRoleMergeMapper extends BasicMapper<SysOrganizeRoleMerge> {
}
