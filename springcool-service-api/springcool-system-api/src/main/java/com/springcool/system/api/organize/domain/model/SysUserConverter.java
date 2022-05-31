package com.springcool.system.api.organize.domain.model;

import com.springcool.system.api.organize.domain.dto.SysUserDto;
import com.springcool.system.api.organize.domain.po.SysUserPo;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.organize.domain.query.SysUserQuery;
import org.mapstruct.Mapper;

/**
 * 用户 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysUserConverter extends BaseConverter<SysUserQuery, SysUserDto, SysUserPo> {
}
