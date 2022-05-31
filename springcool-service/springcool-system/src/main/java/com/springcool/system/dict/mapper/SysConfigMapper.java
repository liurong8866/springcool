package com.springcool.system.dict.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.dict.domain.dto.SysConfigDto;
import com.springcool.system.api.dict.domain.po.SysConfigPo;
import com.springcool.system.api.dict.domain.query.SysConfigQuery;

/**
 * 参数配置管理 数据层
 *
 * @author xueyi
 */
@Master
public interface SysConfigMapper extends BaseMapper<SysConfigQuery, SysConfigDto, SysConfigPo> {
}