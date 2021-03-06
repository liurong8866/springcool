package com.springcool.cool.tenant.api.tenant.domain.model;

import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.cool.tenant.api.tenant.domain.po.TeStrategyPo;
import com.springcool.cool.tenant.api.tenant.domain.query.TeStrategyQuery;
import org.mapstruct.Mapper;

/**
 * 数据源策略 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface TeStrategyConverter extends BaseConverter<TeStrategyQuery, TeStrategyDto, TeStrategyPo> {
}