package com.springcool.cool.common.core.web.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * SubTree 基类
 *
 * @param <D>  Dto
 * @param <SD> SubDto
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SubTreeEntity<D, SD> extends TreeEntity<D> {

    /** 子数据集合 */
    @TableField(exist = false)
    private List<SD> subList;
}
