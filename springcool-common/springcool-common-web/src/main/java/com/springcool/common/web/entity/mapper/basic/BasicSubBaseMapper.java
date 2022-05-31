package com.springcool.common.web.entity.mapper.basic;

import com.springcool.common.core.web.entity.base.SubBaseEntity;

/**
 * 数据层 主子基类数据处理
 * 仅用于基类调用 禁止被继承使用
 *
 * @author springcool
 */
public interface BasicSubBaseMapper<S> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<SubBaseEntity<S>> {
}
