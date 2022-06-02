package com.springcool.cool.file.api.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 文件信息
 *
 * @author springcool
 */
@Data
public class SysFile implements Serializable {

    /** 文件Id */
    private Long id;

    /** 文件夹Id */
    private Long fid;

    /** 文件别称 */
    private String nick;

    /** 文件名称 */
    private String name;

    /** 文件地址 */
    private String url;

    /** 文件地址 */
    private float size;
}
