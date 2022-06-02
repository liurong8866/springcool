package com.springcool.cool.system.monitor.controller;

import cn.hutool.core.util.ArrayUtil;
import com.springcool.cool.common.core.constant.basic.CacheConstants;
import com.springcool.cool.common.core.utils.StringUtils;
import com.springcool.cool.common.core.web.result.AjaxResult;
import com.springcool.cool.common.log.annotation.Log;
import com.springcool.cool.common.log.enums.BusinessType;
import com.springcool.cool.common.redis.service.RedisService;
import com.springcool.cool.common.security.annotation.RequiresPermissions;
import com.springcool.cool.common.security.auth.Auth;
import com.springcool.cool.common.security.service.TokenService;
import com.springcool.cool.common.web.entity.controller.BasisController;
import com.springcool.cool.system.api.model.LoginUser;
import com.springcool.cool.system.monitor.domain.SysUserOnline;
import com.springcool.cool.system.monitor.service.ISysUserOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 在线用户监控
 *
 * @author springcool
 */
@RestController
@RequestMapping("/online")
public class SysUserOnlineController extends BasisController {

    @Autowired
    private ISysUserOnlineService userOnlineService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/list")
    @RequiresPermissions(Auth.SYS_ONLINE_LIST)
    public AjaxResult list(String ipaddr, String userName) {
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
        List<SysUserOnline> userOnlineList = new ArrayList<>();
        LoginUser mine = tokenService.getLoginUser();
        for (String key : keys) {
            LoginUser user = redisService.getCacheObject(key);
            if (mine.getEnterpriseId().equals(user.getEnterpriseId())) {
                if (StringUtils.isNotEmpty(ipaddr) && StringUtils.isNotEmpty(userName)) {
                    if (StringUtils.equals(ipaddr, user.getIpaddr()) && StringUtils.equals(userName, user.getUserName())) {
                        userOnlineList.add(userOnlineService.selectOnlineByInfo(ipaddr, userName, user));
                    }
                } else if (StringUtils.isNotEmpty(ipaddr)) {
                    if (StringUtils.equals(ipaddr, user.getIpaddr())) {
                        userOnlineList.add(userOnlineService.selectOnlineByIpaddr(ipaddr, user));
                    }
                } else if (StringUtils.isNotEmpty(userName)) {
                    if (StringUtils.equals(userName, user.getUserName())) {
                        userOnlineList.add(userOnlineService.selectOnlineByUserName(userName, user));
                    }
                } else {
                    userOnlineList.add(userOnlineService.loginUserToUserOnline(user));
                }
            }
        }
        Collections.reverse(userOnlineList);
        userOnlineList.removeAll(Collections.singleton(null));
        return getDataTable(userOnlineList);
    }

    /**
     * 强退用户
     */
    @DeleteMapping("/batch/{idList}")
    @RequiresPermissions(Auth.SYS_ONLINE_FORCE_LOGOUT)
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    public AjaxResult forceLogout(@PathVariable List<String> idList) {
        if (ArrayUtil.isNotEmpty(idList))
            idList.forEach(id -> redisService.deleteObject(CacheConstants.LOGIN_TOKEN_KEY + id));
        return AjaxResult.success();
    }
}
