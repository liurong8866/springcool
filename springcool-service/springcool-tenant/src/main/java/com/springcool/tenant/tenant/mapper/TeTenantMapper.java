package com.springcool.tenant.tenant.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.tenant.api.tenant.domain.dto.TeTenantDto;
import com.springcool.tenant.api.tenant.domain.po.TeTenantPo;
import com.springcool.tenant.api.tenant.domain.query.TeTenantQuery;

/**
 * 租户管理 数据层
 *
 * @author xueyi
 */
@Master
public interface TeTenantMapper extends BaseMapper<TeTenantQuery, TeTenantDto, TeTenantPo> {
}