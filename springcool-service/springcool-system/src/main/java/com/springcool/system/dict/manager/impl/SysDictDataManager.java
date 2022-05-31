package com.springcool.system.dict.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.system.dict.manager.ISysDictDataManager;
import com.springcool.system.dict.mapper.SysDictDataMapper;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.system.api.dict.domain.dto.SysDictDataDto;
import com.springcool.system.api.dict.domain.model.SysDictDataConverter;
import com.springcool.system.api.dict.domain.po.SysDictDataPo;
import com.springcool.system.api.dict.domain.query.SysDictDataQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 字典数据管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysDictDataManager extends BaseManager<SysDictDataQuery, SysDictDataDto, SysDictDataPo, SysDictDataMapper, SysDictDataConverter> implements ISysDictDataManager {

    /**
     * 查询字典数据对象列表
     *
     * @param code 字典编码
     * @return 字典数据对象集合
     */
    @Override
    public List<SysDictDataDto> selectListByCode(String code) {
        List<SysDictDataPo> dictDataList = baseMapper.selectList(
                Wrappers.<SysDictDataPo>query().lambda()
                        .eq(SysDictDataPo::getCode, code));
        return baseConverter.mapperDto(dictDataList);
    }
}
