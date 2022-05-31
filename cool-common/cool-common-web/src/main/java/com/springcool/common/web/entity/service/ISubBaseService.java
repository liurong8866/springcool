package com.springcool.common.web.entity.service;

import com.springcool.common.core.web.entity.base.BaseEntity;
import com.springcool.common.core.web.entity.base.SubBaseEntity;

/**
 * 服务层 主子基类通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Dto
 * @param <SQ> SubQuery
 * @param <SD> SubDto
 * @author springcool
 */
public interface ISubBaseService<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, SQ extends BaseEntity, SD extends BaseEntity> extends IBaseService<Q, D>, ISubService<Q, D, SQ, SD> {
}
