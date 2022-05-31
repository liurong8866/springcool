package com.springcool.common.security.utils;

import com.springcool.common.core.constant.basic.CacheConstants;
import com.springcool.common.core.utils.SpringUtils;
import com.springcool.common.redis.service.RedisService;
import com.springcool.system.api.source.domain.Source;

import java.io.Serializable;

/**
 * 源策略组缓存管理工具类
 *
 * @author xueyi
 */
public class SourceUtils {

    /**
     * 源策略组查询
     *
     * @param Id 源策略组Id
     */
    public static Source getSourceCache(Serializable Id) {
        return SpringUtils.getBean(RedisService.class).getCacheMapValue(CacheConstants.DATA_SOURCE_KEY, Id.toString());
    }
}