package com.springcool.cool.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

import static com.springcool.cool.common.core.constant.basic.TenantConstants.MASTER;

/**
 * 主数据源
 *
 * @author springcool
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS(MASTER)
public @interface Master {
}