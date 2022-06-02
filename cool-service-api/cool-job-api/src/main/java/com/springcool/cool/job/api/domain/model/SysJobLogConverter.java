package com.springcool.cool.job.api.domain.model;

import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import com.springcool.cool.job.api.domain.dto.SysJobLogDto;
import com.springcool.cool.job.api.domain.po.SysJobLogPo;
import com.springcool.cool.job.api.domain.query.SysJobLogQuery;
import org.mapstruct.Mapper;

/**
 * 调度日志 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysJobLogConverter extends BaseConverter<SysJobLogQuery, SysJobLogDto, SysJobLogPo> {
}
