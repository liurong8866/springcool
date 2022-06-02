package com.springcool.cool.system.api.log.domain.dto;

import com.springcool.cool.system.api.log.domain.po.SysOperateLogPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 操作日志 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogDto extends SysOperateLogPo {

    private static final long serialVersionUID = 1L;

    /** 业务类型数组 */
    private Integer[] businessTypes;
}
