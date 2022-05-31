package com.springcool.tenant.tenant.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.tenant.tenant.manager.ITeTenantManager;
import com.springcool.common.core.constant.basic.SqlConstants;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.tenant.api.tenant.domain.dto.TeTenantDto;
import com.springcool.tenant.api.tenant.domain.model.TeTenantConverter;
import com.springcool.tenant.api.tenant.domain.po.TeTenantPo;
import com.springcool.tenant.api.tenant.domain.query.TeTenantQuery;
import com.springcool.tenant.tenant.mapper.TeTenantMapper;
import org.springframework.stereotype.Component;

/**
 * 租户管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class TeTenantManager extends BaseManager<TeTenantQuery, TeTenantDto, TeTenantPo, TeTenantMapper, TeTenantConverter> implements ITeTenantManager {

    /**
     * 校验数据源策略是否被使用
     *
     * @param strategyId 数据源策略id
     * @return 结果
     */
    @Override
    public TeTenantDto checkStrategyExist(Long strategyId) {
        TeTenantPo tenant = baseMapper.selectOne(
                Wrappers.<TeTenantPo>query().lambda()
                        .eq(TeTenantPo::getStrategyId, strategyId)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(tenant);
    }
}