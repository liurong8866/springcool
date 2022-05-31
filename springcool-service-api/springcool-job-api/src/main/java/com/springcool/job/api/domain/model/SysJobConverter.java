package com.springcool.job.api.domain.model;

import com.springcool.job.api.domain.dto.SysJobDto;
import com.springcool.job.api.domain.po.SysJobPo;
import com.springcool.job.api.domain.query.SysJobQuery;
import com.springcool.common.core.web.entity.model.SubBaseConverter;
import org.mapstruct.Mapper;

/**
 * 调度任务 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysJobConverter extends SubBaseConverter<SysJobQuery, SysJobDto, SysJobPo> {
}
