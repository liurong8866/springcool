package com.springcool.tenant.tenant.manager;

import com.springcool.common.web.entity.manager.IBaseManager;
import com.springcool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.tenant.api.tenant.domain.query.TeStrategyQuery;


/**
 * 数据源策略管理 数据封装层
 *
 * @author xueyi
 */
public interface ITeStrategyManager extends IBaseManager<TeStrategyQuery, TeStrategyDto> {

    /**
     * 校验数据源是否被使用
     *
     * @param sourceId 数据源id
     * @return 结果
     */
    TeStrategyDto checkSourceExist(Long sourceId);
}