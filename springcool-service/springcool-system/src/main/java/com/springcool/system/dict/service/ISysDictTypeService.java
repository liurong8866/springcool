package com.springcool.system.dict.service;

import com.springcool.common.web.entity.service.ISubBaseService;
import com.springcool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.system.api.dict.domain.dto.SysDictTypeDto;
import com.springcool.system.api.dict.domain.query.SysDictDataQuery;
import com.springcool.system.api.dict.domain.query.SysDictTypeQuery;

/**
 * 字典类型管理 服务层
 *
 * @author xueyi
 */
public interface ISysDictTypeService extends ISubBaseService<SysDictTypeQuery, SysDictTypeDto, SysDictDataQuery, SysDictDataDto> {

    /**
     * 加载字典缓存数据
     */
    void loadingDictCache();

    /**
     * 清空字典缓存数据
     */
    void clearDictCache();

    /**
     * 重置字典缓存数据
     */
    void resetDictCache();

    /**
     * 校验字典编码是否唯一
     *
     * @param Id       字典类型Id
     * @param dictCode 字典类型编码
     * @return 结果 | true/false 唯一/不唯一
     */
    boolean checkDictCodeUnique(Long Id, String dictCode);
}
