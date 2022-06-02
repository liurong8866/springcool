package com.springcool.cool.system.api.file.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springcool.cool.common.core.annotation.Excel;
import com.springcool.cool.common.core.web.tenant.base.TBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 素材 持久化对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMaterialPo extends TBaseEntity {

    private static final long serialVersionUID = 1L;

    /** 分类Id */
    @Excel(name = "分类Id")
    @TableField("folder_id")
    private Long folderId;

    /** 素材昵称 */
    @Excel(name = "素材昵称")
    @TableField("nick")
    private String nick;

    /** 素材名称 */
    @Excel(name = "原图名称")
    @TableField("original_name")
    private String originalName;

    /** 素材地址 */
    @Excel(name = "素材地址")
    @TableField("url")
    private String url;

    /** 原图地址 */
    @Excel(name = "原图地址")
    @TableField("original_url")
    private String originalUrl;

    /** 素材大小 */
    @Excel(name = "素材大小")
    @TableField("size")
    private BigDecimal size;

    /** 素材类型 0默认素材 1系统素材 */
    @Excel(name = "素材类型", readConverterExp = "0=默认素材,1=系统素材")
    @TableField("type")
    private String type;
}
