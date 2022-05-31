package com.springcool.tenant.source.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.tenant.api.source.domain.po.TeSourcePo;
import com.springcool.tenant.api.source.domain.query.TeSourceQuery;

/**
 * 数据源管理 数据层
 *
 * @author xueyi
 */
@Master
public interface TeSourceMapper extends BaseMapper<TeSourceQuery, TeSourceDto, TeSourcePo> {
}