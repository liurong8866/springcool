package com.springcool.cool.system.utils.route;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单标签配置信息
 *
 * @author springcool
 */
@Data
public class TagVo {

    /** 为true则显示小圆点 */
    private Boolean dot;

    /** 内容 */
    private String content;

    /** 类型 'error' | 'primary' | 'warn' | 'success' */
    private String type;
}