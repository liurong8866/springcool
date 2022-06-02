package com.springcool.cool.gen.domain.model;

import com.springcool.cool.gen.domain.dto.GenTableColumnDto;
import com.springcool.cool.gen.domain.po.GenTableColumnPo;
import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import com.springcool.cool.gen.domain.query.GenTableColumnQuery;
import org.mapstruct.Mapper;

/**
 * 业务字段 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface GenTableColumnConverter extends BaseConverter<GenTableColumnQuery, GenTableColumnDto, GenTableColumnPo> {
}