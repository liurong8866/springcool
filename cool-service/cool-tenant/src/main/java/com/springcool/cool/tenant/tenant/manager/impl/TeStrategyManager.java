package com.springcool.cool.tenant.tenant.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.cool.tenant.api.tenant.domain.model.TeStrategyConverter;
import com.springcool.cool.tenant.api.tenant.domain.po.TeStrategyPo;
import com.springcool.cool.tenant.tenant.manager.ITeStrategyManager;
import com.springcool.cool.tenant.tenant.mapper.TeStrategyMapper;
import com.springcool.cool.common.core.constant.basic.SqlConstants;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.tenant.api.tenant.domain.query.TeStrategyQuery;
import org.springframework.stereotype.Component;


/**
 * 数据源策略管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class TeStrategyManager extends BaseManager<TeStrategyQuery, TeStrategyDto, TeStrategyPo, TeStrategyMapper, TeStrategyConverter> implements ITeStrategyManager {

    /**
     * 校验数据源是否被使用
     *
     * @param sourceId 数据源id
     * @return 结果
     */
    @Override
    public TeStrategyDto checkSourceExist(Long sourceId) {
        TeStrategyPo strategy = baseMapper.selectOne(
                Wrappers.<TeStrategyPo>query().lambda()
                        .eq(TeStrategyPo::getSourceId, sourceId)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(strategy);
    }
}