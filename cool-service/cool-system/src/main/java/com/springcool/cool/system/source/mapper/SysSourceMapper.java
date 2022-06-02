package com.springcool.cool.system.source.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BasicMapper;
import com.springcool.cool.system.api.source.domain.Source;

/**
 * 策略组管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysSourceMapper extends BasicMapper<Source> {
}
