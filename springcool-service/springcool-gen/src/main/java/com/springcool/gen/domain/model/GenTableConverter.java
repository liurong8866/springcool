package com.springcool.gen.domain.model;

import com.springcool.gen.domain.dto.GenTableDto;
import com.springcool.gen.domain.po.GenTablePo;
import com.springcool.gen.domain.query.GenTableQuery;
import com.springcool.common.core.web.entity.model.SubBaseConverter;
import org.mapstruct.Mapper;

/**
 * 业务 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface GenTableConverter extends SubBaseConverter<GenTableQuery, GenTableDto, GenTablePo> {
}