package com.springcool.cool.common.web.entity.manager.impl.handle;

import com.springcool.cool.common.web.entity.mapper.TreeMapper;
import com.springcool.cool.common.core.web.entity.base.TreeEntity;
import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;

/**
 * 数据封装层处理 操作方法 树型通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Dto
 * @param <P>  Po
 * @param <PM> PoMapper
 * @author springcool
 */
public class TreeHandleManager<Q extends P, D extends P, P extends TreeEntity<D>, PM extends TreeMapper<Q, D, P>, CT extends BaseConverter<Q, D, P>> extends BaseManager<Q, D, P, PM, CT> {
}
