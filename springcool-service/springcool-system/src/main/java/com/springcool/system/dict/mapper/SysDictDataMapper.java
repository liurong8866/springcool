package com.springcool.system.dict.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.system.api.dict.domain.po.SysDictDataPo;
import com.springcool.system.api.dict.domain.query.SysDictDataQuery;

/**
 * 字典数据管理 数据层
 *
 * @author xueyi
 */
@Master
public interface SysDictDataMapper extends BaseMapper<SysDictDataQuery, SysDictDataDto, SysDictDataPo> {
}
