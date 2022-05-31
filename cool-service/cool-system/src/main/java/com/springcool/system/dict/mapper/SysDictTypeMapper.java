package com.springcool.system.dict.mapper;

import com.springcool.common.datasource.annotation.Master;
import com.springcool.common.web.entity.mapper.SubBaseMapper;
import com.springcool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.system.api.dict.domain.dto.SysDictTypeDto;
import com.springcool.system.api.dict.domain.po.SysDictDataPo;
import com.springcool.system.api.dict.domain.po.SysDictTypePo;
import com.springcool.system.api.dict.domain.query.SysDictDataQuery;
import com.springcool.system.api.dict.domain.query.SysDictTypeQuery;

/**
 * 字典类型管理 数据层
 *
 * @author springcool
 */
@Master
public interface SysDictTypeMapper extends SubBaseMapper<SysDictTypeQuery, SysDictTypeDto, SysDictTypePo, SysDictDataQuery, SysDictDataDto, SysDictDataPo> {
}
