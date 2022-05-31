package com.springcool.system.organize.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.organize.domain.dto.SysUserDto;
import com.springcool.system.api.organize.domain.po.SysUserPo;
import com.springcool.system.api.organize.domain.query.SysUserQuery;

/**
 * 用户管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysUserMapper extends BaseMapper<SysUserQuery, SysUserDto, SysUserPo> {
}
