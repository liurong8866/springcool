package com.springcool.common.core.web.entity.model;

import com.springcool.common.core.web.entity.base.TreeEntity;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

/**
 * Tree 基类 对象映射器
 *
 * @param <Q> Query
 * @param <D> Dto
 * @param <P> Po
 * @author springcool
 */
public interface TreeConverter<Q extends P, D extends P, P extends TreeEntity<D>> extends BaseConverter<Q, D, P> {

    @Mapping(target = "children", ignore = true)
    D mapperDto(P po);

    @Mapping(target = "children", ignore = true)
    List<D> mapperDto(Collection<P> poList);

    @Mapping(target = "children", ignore = true)
    P mapperPo(D po);

    @Mapping(target = "children", ignore = true)
    List<P> mapperPo(Collection<D> poList);
}
