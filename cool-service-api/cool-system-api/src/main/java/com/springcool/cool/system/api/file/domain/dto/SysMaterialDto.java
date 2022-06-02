package com.springcool.cool.system.api.file.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.system.api.file.domain.po.SysMaterialPo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 素材 数据传输对象
 *
 * @author springcool
 */
@TableName(value = "cool_material", excludeProperty = {"remark"})
public class SysMaterialDto extends SysMaterialPo {

    private static final long serialVersionUID = 1L;

}
