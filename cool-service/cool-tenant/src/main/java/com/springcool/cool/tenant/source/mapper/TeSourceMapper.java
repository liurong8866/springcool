package com.springcool.cool.tenant.source.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.cool.tenant.api.source.domain.po.TeSourcePo;
import com.springcool.cool.tenant.api.source.domain.query.TeSourceQuery;

/**
 * 数据源管理 数据层
 *
 * @author springcool
 */
@Master
public interface TeSourceMapper extends BaseMapper<TeSourceQuery, TeSourceDto, TeSourcePo> {
}