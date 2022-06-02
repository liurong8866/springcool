package com.springcool.cool.system.api.dict.domain.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.entity.base.SubBaseEntity;
import com.springcool.cool.common.core.xss.Xss;
import com.springcool.cool.system.api.dict.domain.dto.SysDictDataDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 字典类型 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_dict_type", excludeProperty = {"delFlag"})
public class SysDictTypePo extends SubBaseEntity<SysDictDataDto> {

    private static final long serialVersionUID = 1L;

    /** 字典类型 */
    @NotBlank(message = "字典类型不能为空")
    @Size(min = 0, max = 100, message = "字典类型类型长度不能超过100个字符")
    @Pattern(regexp = "^[a-z][a-z0-9_]*$", message = "字典类型必须以字母开头，且只能为（小写字母，数字，下滑线）")
    @Excel(name = "字典类型")
    @TableField(value = "code", updateStrategy = FieldStrategy.NEVER)
    private String code;

    @Override
    @NotBlank(message = "字典名称不能为空")
    @Size(min = 0, max = 100, message = "字典名称长度不能超过100个字符")
    public String getName() {
        return super.getName();
    }
}
