package com.springcool.tenant.api.source.domain.model;

import com.springcool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.tenant.api.source.domain.po.TeSourcePo;
import com.springcool.tenant.api.source.domain.query.TeSourceQuery;
import com.springcool.common.core.web.entity.model.BaseConverter;
import org.mapstruct.Mapper;

/**
 * 数据源 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface TeSourceConverter extends BaseConverter<TeSourceQuery, TeSourceDto, TeSourcePo> {
}