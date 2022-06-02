package com.springcool.cool.common.core.web.vo;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springcool.cool.common.core.web.entity.base.TreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TreeSelect树结构实体类
 *
 * @author springcool
 */
@Data
public class TreeSelect<T extends TreeEntity<T>> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 节点Id */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect<T>> children;

    public TreeSelect() {}

    public TreeSelect(T t) {
        this.id = t.getId();
        this.label = t.getName();
        this.children = CollUtil.isNotEmpty(t.getChildren()) ? t.getChildren().stream().map(TreeSelect<T>::new).collect(Collectors.toList()) : null;
    }
}
