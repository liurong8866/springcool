package com.springcool.cool.common.core.web.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.springcool.cool.common.core.web.validate.V_E;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Basis 基类
 *
 * @author springcool
 */
@Data
public class BasisEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Id */
    @TableId("id")
    @NotNull(message = "id不能为空", groups = {V_E.class})
    private Long id;

    /** 数据源名称 */
    @TableField(exist = false)
    private String sourceName;

    /** 请求参数 */
    @TableField(exist = false)
    private Map<String, Object> params;
}
