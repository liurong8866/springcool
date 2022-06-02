package com.springcool.cool.system.mapper;

import com.springcool.cool.system.domain.query.SysJobQuery;
import com.springcool.cool.system.domain.dto.SysJobDto;
import com.springcool.cool.system.domain.po.SysJobPo;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.common.datasource.annotation.Master;

/**
 * 定时任务调度管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysJobMapper extends BaseMapper<SysJobQuery, SysJobDto, SysJobPo> {
}