package com.springcool.cool.tenant.tenant.service;

import com.springcool.cool.common.web.entity.service.IBaseService;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.cool.tenant.api.tenant.domain.query.TeStrategyQuery;

/**
 * 数据源策略管理 服务层
 *
 * @author springcool
 */
public interface ITeStrategyService extends IBaseService<TeStrategyQuery, TeStrategyDto> {

    /**
     * 校验数据源是否被使用
     *
     * @param sourceId 数据源id
     * @return 结果 | true/false 存在/不存在
     */
    boolean checkSourceExist(Long sourceId);

    /**
     * 校验源策略是否为默认源策略
     *
     * @param id 源策略id
     * @return 结果 | true/false 是/不是
     */
    boolean checkIsDefault(Long id);
}