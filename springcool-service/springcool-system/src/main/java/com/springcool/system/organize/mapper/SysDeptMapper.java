package com.springcool.system.organize.mapper;

import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.SubTreeMapper;
import com.springcool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.system.api.organize.domain.po.SysDeptPo;
import com.springcool.system.api.organize.domain.po.SysPostPo;
import com.springcool.system.api.organize.domain.query.SysDeptQuery;
import com.springcool.system.api.organize.domain.query.SysPostQuery;


/**
 * 部门管理 数据层
 *
 * @author xueyi
 */
@Isolate
public interface SysDeptMapper extends SubTreeMapper<SysDeptQuery, SysDeptDto, SysDeptPo, SysPostQuery, SysPostDto, SysPostPo> {
}
