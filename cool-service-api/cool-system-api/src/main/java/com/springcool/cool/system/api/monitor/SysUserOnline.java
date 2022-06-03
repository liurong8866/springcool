package com.springcool.cool.system.api.monitor;

import lombok.Data;

import java.io.Serializable;

/**
 * 当前在线会话
 *
 * @author springcool
 */
@Data
public class SysUserOnline implements Serializable {

    /** 会话编号 */
    private String tokenId;

    /** 用户账号 */
    private String userName;

    /** 用户名称 */
    private String userNick;

    /** 登录IP地址 */
    private String ipaddr;

    /** 登录地址 */
    private String loginLocation;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 登录时间 */
    private Long loginTime;
}
