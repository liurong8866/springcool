package com.springcool.system.api.dict.domain.model;

import com.springcool.common.core.web.entity.model.SubBaseConverter;
import com.springcool.system.api.dict.domain.dto.SysDictTypeDto;
import com.springcool.system.api.dict.domain.po.SysDictTypePo;
import com.springcool.system.api.dict.domain.query.SysDictTypeQuery;
import org.mapstruct.Mapper;

/**
 * 字典类型 对象映射器
 *
 * @author xueyi
 */
@Mapper(componentModel = "spring")
public interface SysDictTypeConverter extends SubBaseConverter<SysDictTypeQuery, SysDictTypeDto, SysDictTypePo> {
}
