package com.springcool.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

import static com.springcool.common.core.constant.basic.TenantConstants.ISOLATE;

/**
 * 租户策略源
 *
 * @author xueyi
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS(ISOLATE)
public @interface Isolate {
}