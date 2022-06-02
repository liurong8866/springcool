package com.springcool.cool.gen.domain.model;

import com.springcool.cool.gen.domain.dto.GenTableDto;
import com.springcool.cool.gen.domain.po.GenTablePo;
import com.springcool.cool.gen.domain.query.GenTableQuery;
import com.springcool.cool.common.core.web.entity.model.SubBaseConverter;
import org.mapstruct.Mapper;

/**
 * 业务 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface GenTableConverter extends SubBaseConverter<GenTableQuery, GenTableDto, GenTablePo> {
}