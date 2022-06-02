package com.springcool.cool.system.dict.manager;

import com.springcool.cool.common.web.entity.manager.IBaseManager;
import com.springcool.cool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.cool.system.api.dict.domain.query.SysDictDataQuery;

import java.util.List;

/**
 * 字典数据管理 数据封装层
 *
 * @author springcool
 */
public interface ISysDictDataManager extends IBaseManager<SysDictDataQuery, SysDictDataDto> {

    /**
     * 查询字典数据对象列表
     *
     * @param code 字典编码
     * @return 字典数据对象集合
     */
    List<SysDictDataDto> selectListByCode(String code);
}
