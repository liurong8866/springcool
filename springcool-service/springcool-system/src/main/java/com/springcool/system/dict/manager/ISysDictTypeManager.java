package com.springcool.system.dict.manager;

import com.springcool.common.web.entity.manager.ISubBaseManager;
import com.springcool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.system.api.dict.domain.dto.SysDictTypeDto;
import com.springcool.system.api.dict.domain.query.SysDictDataQuery;
import com.springcool.system.api.dict.domain.query.SysDictTypeQuery;

/**
 * 字典类型管理 数据封装层
 *
 * @author springcool
 */
public interface ISysDictTypeManager extends ISubBaseManager<SysDictTypeQuery, SysDictTypeDto, SysDictDataQuery, SysDictDataDto> {

    /**
     * 校验字典编码是否唯一
     *
     * @param Id   字典类型Id
     * @param code 字典类型编码
     * @return 字典类型对象
     */
    SysDictTypeDto checkDictCodeUnique(Long Id, String code);
}
