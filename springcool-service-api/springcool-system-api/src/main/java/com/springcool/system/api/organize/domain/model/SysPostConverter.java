package com.springcool.system.api.organize.domain.model;

import com.springcool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.system.api.organize.domain.po.SysPostPo;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.organize.domain.query.SysPostQuery;
import org.mapstruct.Mapper;

/**
 * 岗位 对象映射器
 *
 * @author xueyi
 */
@Mapper(componentModel = "spring")
public interface SysPostConverter extends BaseConverter<SysPostQuery, SysPostDto, SysPostPo> {
}
