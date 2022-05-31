package com.springcool.system.api.organize.domain.model;

import com.springcool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.system.api.organize.domain.po.SysEnterprisePo;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.organize.domain.query.SysEnterpriseQuery;
import org.mapstruct.Mapper;

/**
 * 企业 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysEnterpriseConverter extends BaseConverter<SysEnterpriseQuery, SysEnterpriseDto, SysEnterprisePo> {
}
