package com.springcool.job.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.job.api.domain.dto.SysJobLogDto;
import com.springcool.job.api.domain.po.SysJobLogPo;
import com.springcool.job.api.domain.query.SysJobLogQuery;


/**
 * 调度日志管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysJobLogMapper extends BaseMapper<SysJobLogQuery, SysJobLogDto, SysJobLogPo> {
}
