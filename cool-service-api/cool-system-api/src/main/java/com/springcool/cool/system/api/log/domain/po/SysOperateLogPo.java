package com.springcool.cool.system.api.log.domain.po;

import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.tenant.base.TBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 操作日志 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_operate_log",excludeProperty = {"name","sort","createBy","createTime","updateBy","updateTime","remark"})
public class SysOperateLogPo extends TBaseEntity {

    private static final long serialVersionUID = 1L;

    /** 操作模块 */
    @Excel(name = "操作模块")
    @TableField("title")
    private String title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    @TableField("business_type")
    private String businessType;

    /** 请求方法 */
    @Excel(name = "请求方法")
    @TableField("method")
    private String method;

    /** 请求方式 */
    @Excel(name = "请求方式")
    @TableField("request_method")
    private String requestMethod;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    @TableField("operate_type")
    private String operateType;

    /** 操作Id */
    @TableField("user_id")
    private Long userId;

    /** 操作人员账号 */
    @Excel(name = "操作人员账号")
    @TableField("user_name")
    private String userName;

    /** 操作人员名称 */
    @Excel(name = "操作人员名称")
    @TableField("user_nick")
    private String userNick;

    /** 请求url */
    @Excel(name = "请求地址")
    @TableField("url")
    private String url;

    /** 操作地址 */
    @Excel(name = "操作地址")
    @TableField("ip")
    private String ip;

    /** 请求参数 */
    @Excel(name = "请求参数")
    @TableField("param")
    private String param;

    /** 请求参数 */
    @Excel(name = "操作地点")
    @TableField("location")
    private String location;
    
    /** 返回参数 */
    @Excel(name = "返回参数")
    @TableField("json_result")
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    @TableField("status")
    private String status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    @TableField("error_msg")
    private String errorMsg;

    /** 操作时间 */
    @OrderBy(sort = 10)
    @TableField("operate_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operateTime;
}
