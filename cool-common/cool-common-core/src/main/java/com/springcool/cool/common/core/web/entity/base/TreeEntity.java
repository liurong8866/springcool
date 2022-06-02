package com.springcool.cool.common.core.web.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Tree 基类
 *
 * @param <D> Dto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TreeEntity<D> extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 父级Id */
    @TableField("parent_id")
    private Long parentId;

    /** 父级名称 */
    @TableField(exist = false)
    private String parentName;

    /** 祖籍列表 */
    @TableField("ancestors")
    private String ancestors;

    /** 子节点集合 */
    @TableField(exist = false)
    private List<D> children;

}
