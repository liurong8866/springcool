package com.springcool.cool.tenant.source.service;

import com.springcool.cool.common.web.entity.service.IBaseService;
import com.springcool.cool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.cool.tenant.api.source.domain.query.TeSourceQuery;

/**
 * 数据源管理 服务层
 *
 * @author springcool
 */
public interface ITeSourceService extends IBaseService<TeSourceQuery, TeSourceDto> {

    /**
     * 校验数据源是否为默认数据源
     *
     * @param id 数据源id
     * @return 结果 | true/false 是/不是
     */
    boolean checkIsDefault(Long id);
}