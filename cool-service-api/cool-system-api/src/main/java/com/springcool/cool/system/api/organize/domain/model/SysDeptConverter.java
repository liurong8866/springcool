package com.springcool.cool.system.api.organize.domain.model;

import com.springcool.cool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.cool.system.api.organize.domain.query.SysDeptQuery;
import com.springcool.cool.system.api.organize.domain.po.SysDeptPo;
import com.springcool.cool.common.core.web.entity.model.SubTreeConverter;
import org.mapstruct.Mapper;

/**
 * 部门 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysDeptConverter extends SubTreeConverter<SysDeptQuery, SysDeptDto, SysDeptPo> {
}
