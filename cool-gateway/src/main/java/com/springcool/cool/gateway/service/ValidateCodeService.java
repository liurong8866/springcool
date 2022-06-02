package com.springcool.cool.gateway.service;

import com.springcool.cool.common.core.exception.CaptchaException;
import com.springcool.cool.common.core.web.result.AjaxResult;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author springcool
 */
public interface ValidateCodeService {

    /**
     * 生成验证码
     */
    AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    void checkCaptcha(String key, String value) throws CaptchaException;
}
