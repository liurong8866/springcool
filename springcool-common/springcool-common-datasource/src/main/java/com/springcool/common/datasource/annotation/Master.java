package com.springcool.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

import static com.springcool.common.core.constant.basic.TenantConstants.MASTER;

/**
 * 主数据源
 *
 * @author xueyi
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS(MASTER)
public @interface Master {
}