package com.springcool.cool.system.dict.mapper;

import com.springcool.cool.common.datasource.annotation.Master;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;
import com.springcool.cool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.cool.system.api.dict.domain.po.SysDictDataPo;
import com.springcool.cool.system.api.dict.domain.query.SysDictDataQuery;

/**
 * 字典数据管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysDictDataMapper extends BaseMapper<SysDictDataQuery, SysDictDataDto, SysDictDataPo> {
}
