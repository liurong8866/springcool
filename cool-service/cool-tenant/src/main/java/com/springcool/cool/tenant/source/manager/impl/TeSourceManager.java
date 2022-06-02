package com.springcool.cool.tenant.source.manager.impl;

import cn.hutool.core.util.IdUtil;
import com.springcool.cool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.cool.tenant.api.source.domain.model.TeSourceConverter;
import com.springcool.cool.tenant.api.source.domain.po.TeSourcePo;
import com.springcool.cool.tenant.api.source.domain.query.TeSourceQuery;
import com.springcool.cool.tenant.source.manager.ITeSourceManager;
import com.springcool.cool.tenant.source.mapper.TeSourceMapper;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import org.springframework.stereotype.Component;

/**
 * 数据源管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class TeSourceManager extends BaseManager<TeSourceQuery, TeSourceDto, TeSourcePo, TeSourceMapper, TeSourceConverter> implements ITeSourceManager {

    /**
     * 新增数据源对象
     *
     * @param source 数据源对象
     * @return 结果
     */
    @Override
    public int insert(TeSourceDto source) {
        source.setSlave(IdUtil.simpleUUID());
        return baseMapper.insert(source);
    }
}