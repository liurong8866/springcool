package com.springcool.system.organize.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.system.api.organize.domain.po.SysEnterprisePo;
import com.springcool.system.api.organize.domain.query.SysEnterpriseQuery;


/**
 * 企业管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysEnterpriseMapper extends BaseMapper<SysEnterpriseQuery, SysEnterpriseDto, SysEnterprisePo> {
}
