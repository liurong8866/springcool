package com.springcool.common.web.entity.mapper.basic;

import com.springcool.common.core.web.entity.base.TreeEntity;

/**
 * 数据层 树型基类数据处理
 * 仅用于基类调用 禁止被继承使用
 *
 * @author xueyi
 */
public interface BasicTreeMapper<D> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<TreeEntity<D>> {
}
