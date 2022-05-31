package com.springcool.system.api.dict.domain.model;

import com.springcool.system.api.dict.domain.query.SysDictDataQuery;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.system.api.dict.domain.po.SysDictDataPo;
import org.mapstruct.Mapper;

/**
 * 字典数据 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysDictDataConverter extends BaseConverter<SysDictDataQuery, SysDictDataDto, SysDictDataPo> {
}