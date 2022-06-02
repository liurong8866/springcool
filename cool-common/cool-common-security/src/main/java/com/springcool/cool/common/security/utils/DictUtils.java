package com.springcool.cool.common.security.utils;

import com.springcool.cool.common.core.constant.basic.CacheConstants;
import com.springcool.cool.common.core.utils.SpringUtils;
import com.springcool.cool.common.redis.service.RedisService;
import com.springcool.cool.system.api.dict.domain.dto.SysDictDataDto;

import java.util.Collection;
import java.util.List;

/**
 * 字典缓存管理工具类
 *
 * @author springcool
 */
public class DictUtils {

    /**
     * 获取字典缓存
     *
     * @param code 字典编码
     * @return 字典数据列表
     */
    public static List<SysDictDataDto> getDictCache(String code) {
        return SpringUtils.getBean(RedisService.class).getCacheMapValue(CacheConstants.SYS_DICT_KEY, code);
    }

    /**
     * 获取多个字典缓存
     *
     * @param codeList 字典编码集合
     * @return 字典数据列表
     */
    public static List<List<SysDictDataDto>> getDictListCache(Collection<Object> codeList) {
        return SpringUtils.getBean(RedisService.class).getMultiCacheMapValue(CacheConstants.SYS_DICT_KEY, codeList);
    }
}
