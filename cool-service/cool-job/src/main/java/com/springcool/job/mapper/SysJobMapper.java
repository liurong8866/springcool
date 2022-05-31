package com.springcool.job.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.SubBaseMapper;
import com.springcool.job.api.domain.dto.SysJobDto;
import com.springcool.job.api.domain.dto.SysJobLogDto;
import com.springcool.job.api.domain.po.SysJobLogPo;
import com.springcool.job.api.domain.po.SysJobPo;
import com.springcool.job.api.domain.query.SysJobLogQuery;
import com.springcool.job.api.domain.query.SysJobQuery;

/**
 * 调度任务管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysJobMapper extends SubBaseMapper<SysJobQuery, SysJobDto, SysJobPo, SysJobLogQuery, SysJobLogDto, SysJobLogPo> {
}
