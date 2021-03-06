package com.springcool.cool.common.web.entity.mapper.basic;

import com.springcool.cool.common.core.web.entity.base.SubTreeEntity;

/**
 * 数据层 主子树型基类数据处理
 * 仅用于基类调用 禁止被继承使用
 *
 * @author springcool
 */
public interface BasicSubTreeMapper<D, S> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<SubTreeEntity<D, S>> {
}
