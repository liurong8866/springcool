package com.springcool.cool.system.dict.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.system.dict.manager.ISysConfigManager;
import com.springcool.cool.system.dict.mapper.SysConfigMapper;
import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.common.core.constant.basic.SqlConstants;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.system.api.dict.domain.dto.SysConfigDto;
import com.springcool.cool.system.api.dict.domain.model.SysConfigConverter;
import com.springcool.cool.system.api.dict.domain.po.SysConfigPo;
import com.springcool.cool.system.api.dict.domain.query.SysConfigQuery;
import org.springframework.stereotype.Component;

/**
 * 参数配置管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysConfigManager extends BaseManager<SysConfigQuery, SysConfigDto, SysConfigPo, SysConfigMapper, SysConfigConverter> implements ISysConfigManager {

    /**
     * 根据参数编码查询参数对象
     *
     * @param code 参数编码
     * @return 参数对象
     */
    @Override
    public SysConfigDto selectConfigByCode(String code) {
        SysConfigPo config = baseMapper.selectOne(
                Wrappers.<SysConfigPo>query().lambda()
                        .eq(SysConfigPo::getCode, code)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(config);
    }

    /**
     * 校验参数编码是否唯一
     *
     * @param Id   参数Id
     * @param code 参数编码
     * @return 参数对象
     */
    @Override
    public SysConfigDto checkConfigCodeUnique(Long Id, String code) {
        SysConfigPo config = baseMapper.selectOne(
                Wrappers.<SysConfigPo>query().lambda()
                        .ne(SysConfigPo::getId, Id)
                        .eq(SysConfigPo::getCode, code)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(config);
    }

    /**
     * 校验是否为内置参数
     *
     * @param Id 参数Id
     * @return 参数对象
     */
    @Override
    public SysConfigDto checkIsBuiltIn(Long Id) {
        SysConfigPo config = baseMapper.selectOne(
                Wrappers.<SysConfigPo>query().lambda()
                        .eq(SysConfigPo::getId, Id)
                        .eq(SysConfigPo::getType, BaseConstants.Whether.YES.getCode())
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(config);
    }
}
