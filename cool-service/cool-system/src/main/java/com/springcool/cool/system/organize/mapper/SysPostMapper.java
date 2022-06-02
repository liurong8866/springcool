package com.springcool.cool.system.organize.mapper;

import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.po.SysPostPo;
import com.springcool.cool.system.api.organize.domain.query.SysPostQuery;

/**
 * 岗位管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysPostMapper extends BaseMapper<SysPostQuery, SysPostDto, SysPostPo> {
}
