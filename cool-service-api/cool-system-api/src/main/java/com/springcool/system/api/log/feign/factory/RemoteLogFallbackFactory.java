package com.springcool.system.api.log.feign.factory;

import com.springcool.system.api.log.feign.RemoteLogService;
import com.springcool.common.core.domain.R;
import com.springcool.system.api.log.domain.dto.SysLoginLogDto;
import com.springcool.system.api.log.domain.dto.SysOperateLogDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务 降级处理
 *
 * @author springcool
 */
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public R<Boolean> saveOperateLog(SysOperateLogDto operateLog, Long enterpriseId, String sourceName, String source) {
                return null;
            }

            @Override
            public R<Boolean> saveLoginInfo(SysLoginLogDto loginInfo, Long enterpriseId, String sourceName, String source) {
                return null;
            }
        };
    }
}