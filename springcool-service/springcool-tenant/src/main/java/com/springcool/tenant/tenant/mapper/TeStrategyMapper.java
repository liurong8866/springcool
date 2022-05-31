package com.springcool.tenant.tenant.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.tenant.api.tenant.domain.po.TeStrategyPo;
import com.springcool.tenant.api.tenant.domain.query.TeStrategyQuery;

/**
 * 数据源策略管理 数据层
 *
 * @author springcool
 */
@Master
public interface TeStrategyMapper extends BaseMapper<TeStrategyQuery, TeStrategyDto, TeStrategyPo> {
}