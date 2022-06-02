package com.springcool.cool.system.organize.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.cool.system.api.organize.domain.po.SysEnterprisePo;
import com.springcool.cool.system.api.organize.domain.query.SysEnterpriseQuery;


/**
 * 企业管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysEnterpriseMapper extends BaseMapper<SysEnterpriseQuery, SysEnterpriseDto, SysEnterprisePo> {
}
