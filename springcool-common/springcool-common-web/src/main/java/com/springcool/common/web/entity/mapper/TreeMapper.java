package com.springcool.common.web.entity.mapper;

import com.springcool.common.core.web.entity.base.TreeEntity;

/**
 * 数据层 树型通用数据处理
 *
 * @param <Q> Query
 * @param <D> Dto
 * @param <P> Po
 * @author springcool
 */
public interface TreeMapper<Q extends P, D extends P, P extends TreeEntity<D>> extends BaseMapper<Q, D, P> {
}
