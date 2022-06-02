package com.springcool.cool.tenant.tenant.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.cool.tenant.api.tenant.domain.po.TeStrategyPo;
import com.springcool.cool.tenant.api.tenant.domain.query.TeStrategyQuery;

/**
 * 数据源策略管理 数据层
 *
 * @author springcool
 */
@Master
public interface TeStrategyMapper extends BaseMapper<TeStrategyQuery, TeStrategyDto, TeStrategyPo> {
}