package com.springcool.system.api.organize.feign;

import com.springcool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.system.api.organize.feign.factory.RemoteDeptFallbackFactory;
import com.springcool.common.core.constant.basic.SecurityConstants;
import com.springcool.common.core.constant.basic.ServiceConstants;
import com.springcool.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 部门服务
 *
 * @author springcool
 */
@FeignClient(contextId = "remoteDeptService", value = ServiceConstants.SYSTEM_SERVICE, fallbackFactory = RemoteDeptFallbackFactory.class)
public interface RemoteDeptService {

    /**
     * 新增部门
     *
     * @param dept         部门对象
     * @param enterpriseId 企业Id
     * @param sourceName   策略源
     * @param source       请求来源
     * @return 结果
     */
    @PostMapping("/dept/inner/add")
    R<SysDeptDto> addInner(@RequestBody SysDeptDto dept, @RequestHeader(SecurityConstants.ENTERPRISE_ID) Long enterpriseId, @RequestHeader(SecurityConstants.SOURCE_NAME) String sourceName, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}