package com.springcool.tenant.source.manager;

import com.springcool.common.web.entity.manager.IBaseManager;
import com.springcool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.tenant.api.source.domain.query.TeSourceQuery;

/**
 * 数据源管理 数据封装层
 *
 * @author springcool
 */
public interface ITeSourceManager extends IBaseManager<TeSourceQuery, TeSourceDto> {
}