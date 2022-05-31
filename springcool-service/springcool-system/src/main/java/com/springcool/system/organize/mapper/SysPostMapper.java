package com.springcool.system.organize.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.system.api.organize.domain.po.SysPostPo;
import com.springcool.system.api.organize.domain.query.SysPostQuery;

/**
 * 岗位管理 数据层
 *
 * @author xueyi
 */
@Isolate
public interface SysPostMapper extends BaseMapper<SysPostQuery, SysPostDto, SysPostPo> {
}
