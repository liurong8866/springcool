package com.springcool.cool.system.organize.mapper;

import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.organize.domain.dto.SysUserDto;
import com.springcool.cool.system.api.organize.domain.po.SysUserPo;
import com.springcool.cool.system.api.organize.domain.query.SysUserQuery;

/**
 * 用户管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysUserMapper extends BaseMapper<SysUserQuery, SysUserDto, SysUserPo> {
}
