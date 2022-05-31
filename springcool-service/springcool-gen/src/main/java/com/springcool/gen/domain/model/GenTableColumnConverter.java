package com.springcool.gen.domain.model;

import com.springcool.gen.domain.dto.GenTableColumnDto;
import com.springcool.gen.domain.po.GenTableColumnPo;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.gen.domain.query.GenTableColumnQuery;
import org.mapstruct.Mapper;

/**
 * 业务字段 对象映射器
 *
 * @author xueyi
 */
@Mapper(componentModel = "spring")
public interface GenTableColumnConverter extends BaseConverter<GenTableColumnQuery, GenTableColumnDto, GenTableColumnPo> {
}