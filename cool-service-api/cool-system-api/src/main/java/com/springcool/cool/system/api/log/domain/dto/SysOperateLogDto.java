package com.springcool.cool.system.api.log.domain.dto;

import com.springcool.cool.system.api.log.domain.po.SysOperateLogPo;

/**
 * 操作日志 数据传输对象
 *
 * @author springcool
 */
public class SysOperateLogDto extends SysOperateLogPo {

    private static final long serialVersionUID = 1L;

    /** 业务类型数组 */
    private Integer[] businessTypes;

    public Integer[] getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(Integer[] businessTypes) {
        this.businessTypes = businessTypes;
    }


}
