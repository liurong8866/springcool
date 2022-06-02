package com.springcool.cool.system.api.log.domain.model;

import com.springcool.cool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.cool.system.api.log.domain.po.SysOperateLogPo;
import com.springcool.cool.system.api.log.domain.query.SysOperateLogQuery;
import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import org.mapstruct.Mapper;

/**
 * 操作日志 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysOperateLogConverter extends BaseConverter<SysOperateLogQuery, SysOperateLogDto, SysOperateLogPo> {
}
