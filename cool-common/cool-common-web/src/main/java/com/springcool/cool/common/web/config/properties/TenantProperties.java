package com.springcool.cool.common.web.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.springcool.cool.common.core.constant.basic.BaseConstants.INIT_COMMON_TABLE;
import static com.springcool.cool.common.core.constant.basic.BaseConstants.INIT_EXCLUDE_TABLE;

/**
 * 租户表控制配置
 *
 * @author springcool
 */
@Configuration
@ConfigurationProperties(prefix = "springcool.tenant")
public class TenantProperties {

    /** 公共表 */
    private static String[] commonTable = INIT_COMMON_TABLE;

    /** 非租户表 */
    private static String[] excludeTable = INIT_EXCLUDE_TABLE;

    public static String[] getCommonTable() {
        return commonTable;
    }

    public void setCommonTable(String[] commonTable) {
        TenantProperties.commonTable = commonTable;
    }

    public static String[] getExcludeTable() {
        return excludeTable;
    }

    public void setExcludeTable(String[] excludeTable) {
        TenantProperties.excludeTable = excludeTable;
    }

}