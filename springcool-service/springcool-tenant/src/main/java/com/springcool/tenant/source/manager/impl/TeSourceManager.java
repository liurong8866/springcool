package com.springcool.tenant.source.manager.impl;

import cn.hutool.core.util.IdUtil;
import com.springcool.tenant.source.mapper.TeSourceMapper;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.tenant.api.source.domain.model.TeSourceConverter;
import com.springcool.tenant.api.source.domain.po.TeSourcePo;
import com.springcool.tenant.api.source.domain.query.TeSourceQuery;
import com.springcool.tenant.source.manager.ITeSourceManager;
import org.springframework.stereotype.Component;

/**
 * 数据源管理 数据封装层处理
 *
 * @author xueyi
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