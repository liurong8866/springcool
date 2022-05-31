package com.springcool.common.datasource.processor;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.springcool.common.datasource.utils.DSUtils;
import com.springcool.common.security.utils.SecurityUtils;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import static com.springcool.common.core.constant.basic.TenantConstants.ISOLATE;

/**
 * 租户库源策略
 *
 * @author springcool
 */
@Component
public class DsIsolateExpressionProcessor extends DsProcessor {

    @Override
    public boolean matches(String key) {
        return key.startsWith(ISOLATE);
    }

    @Override
    public String doDetermineDatasource(MethodInvocation invocation, String key) {
        String sourceName = SecurityUtils.getSourceName();
        return StrUtil.isNotEmpty(sourceName) ? sourceName : DSUtils.getNowDsName();
    }
}