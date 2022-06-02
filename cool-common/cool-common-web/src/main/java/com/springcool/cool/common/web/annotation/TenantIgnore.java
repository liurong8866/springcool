package com.springcool.cool.common.web.annotation;

import java.lang.annotation.*;

/**
 * 租户控制过滤注解
 *
 * @author springcool
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TenantIgnore {

    /** 租户控制 */
    boolean tenantLine() default false;
}