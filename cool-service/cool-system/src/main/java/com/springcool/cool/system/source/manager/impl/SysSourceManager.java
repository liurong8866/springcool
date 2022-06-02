package com.springcool.cool.system.source.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.system.source.manager.ISysSourceManager;
import com.springcool.cool.system.source.mapper.SysSourceMapper;
import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.system.api.source.domain.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 策略组管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysSourceManager implements ISysSourceManager {

    @Autowired
    private SysSourceMapper baseMapper;

    /**
     * 查询源策略组列表
     *
     * @return 策略组集合
     */
    @Override
    public List<Source> selectSourceList() {
        return baseMapper.selectList(
                Wrappers.<Source>query().lambda()
                        .eq(Source::getStatus, BaseConstants.Status.NORMAL.getCode()));
    }

    /**
     * 根据Id查询源策略组
     *
     * @param id 源策略Id
     * @return 源策略组
     */
    @Override
    public Source selectById(Serializable id) {
        return baseMapper.selectOne(Wrappers.<Source>query().lambda()
                .eq(Source::getId, id)
                .eq(Source::getStatus, BaseConstants.Status.NORMAL.getCode()));
    }
}
