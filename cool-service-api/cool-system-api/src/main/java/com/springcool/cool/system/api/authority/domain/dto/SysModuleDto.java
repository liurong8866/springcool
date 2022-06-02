package com.springcool.cool.system.api.authority.domain.dto;

import com.springcool.cool.system.api.authority.domain.po.SysModulePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 模块 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysModuleDto extends SysModulePo {

    private static final long serialVersionUID = 1L;
}
