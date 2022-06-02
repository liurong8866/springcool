package com.springcool.cool.system.api.file.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.system.api.file.domain.po.SysMaterialFolderPo;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 素材分类 数据传输对象
 *
 * @author springcool
 */
@TableName(value = "cool_material_folder", excludeProperty = {"remark"})
public class SysMaterialFolderDto extends SysMaterialFolderPo<SysMaterialFolderDto, SysMaterialDto> {

    private static final long serialVersionUID = 1L;
}
