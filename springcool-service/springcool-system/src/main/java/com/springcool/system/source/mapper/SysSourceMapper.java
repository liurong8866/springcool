package com.springcool.system.source.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BasicMapper;
import com.springcool.system.api.source.domain.Source;

/**
 * 策略组管理 数据层
 *
 * @author xueyi
 */
@Master
public interface SysSourceMapper extends BasicMapper<Source> {
}
