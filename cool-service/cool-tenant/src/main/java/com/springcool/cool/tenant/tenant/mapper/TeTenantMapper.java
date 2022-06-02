package com.springcool.cool.tenant.tenant.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeTenantDto;
import com.springcool.cool.tenant.api.tenant.domain.po.TeTenantPo;
import com.springcool.cool.tenant.api.tenant.domain.query.TeTenantQuery;

/**
 * 租户管理 数据层
 *
 * @author springcool
 */
@Master
public interface TeTenantMapper extends BaseMapper<TeTenantQuery, TeTenantDto, TeTenantPo> {
}