package com.springcool.tenant.api.tenant.domain.model;

import com.springcool.tenant.api.tenant.domain.dto.TeTenantDto;
import com.springcool.tenant.api.tenant.domain.po.TeTenantPo;
import com.springcool.tenant.api.tenant.domain.query.TeTenantQuery;
import com.springcool.common.core.web.entity.model.BaseConverter;
import org.mapstruct.Mapper;

/**
 * 租户 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface TeTenantConverter extends BaseConverter<TeTenantQuery, TeTenantDto, TeTenantPo> {
}