package com.springcool.cool.system.api.organize.feign.factory;

import com.springcool.cool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.cool.system.api.organize.feign.RemoteDeptService;
import com.springcool.cool.common.core.domain.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 部门服务 降级处理
 *
 * @author springcool
 */
@Component
public class RemoteDeptFallbackFactory implements FallbackFactory<RemoteDeptService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteDeptFallbackFactory.class);

    @Override
    public RemoteDeptService create(Throwable throwable) {
        log.error("部门服务调用失败:{}", throwable.getMessage());
        return new RemoteDeptService() {
            @Override
            public R<SysDeptDto> addInner(SysDeptDto dept, Long enterpriseId, String sourceName, String source) {
                return R.fail("新增部门失败:" + throwable.getMessage());
            }
        };
    }
}