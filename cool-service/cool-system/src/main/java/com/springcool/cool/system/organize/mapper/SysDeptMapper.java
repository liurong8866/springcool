package com.springcool.cool.system.organize.mapper;

import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.SubTreeMapper;
import com.springcool.cool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.po.SysDeptPo;
import com.springcool.cool.system.api.organize.domain.po.SysPostPo;
import com.springcool.cool.system.api.organize.domain.query.SysDeptQuery;
import com.springcool.cool.system.api.organize.domain.query.SysPostQuery;


/**
 * 部门管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysDeptMapper extends SubTreeMapper<SysDeptQuery, SysDeptDto, SysDeptPo, SysPostQuery, SysPostDto, SysPostPo> {
}
