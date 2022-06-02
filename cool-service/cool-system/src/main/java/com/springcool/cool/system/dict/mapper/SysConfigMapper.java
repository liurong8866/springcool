package com.springcool.cool.system.dict.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.dict.domain.dto.SysConfigDto;
import com.springcool.cool.system.api.dict.domain.po.SysConfigPo;
import com.springcool.cool.system.api.dict.domain.query.SysConfigQuery;

/**
 * 参数配置管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysConfigMapper extends BaseMapper<SysConfigQuery, SysConfigDto, SysConfigPo> {
}