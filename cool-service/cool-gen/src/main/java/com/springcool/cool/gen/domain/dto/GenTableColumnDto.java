package com.springcool.cool.gen.domain.dto;

import cn.hutool.core.util.StrUtil;
import com.springcool.cool.common.core.utils.StringUtils;
import com.springcool.cool.gen.domain.po.GenTableColumnPo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 业务字段 数据传输对象
 *
 * @author springcool
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GenTableColumnDto extends GenTableColumnPo {

    private static final long serialVersionUID = 1L;

    /** 字典名称 */
    private String dictName;

    public String readConverterExp() {
        String remarks = StrUtil.subBetween(this.getComment(), "（", "）");
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotEmpty(remarks)) {
            for (String value : remarks.split(" ")) {
                if (StringUtils.isNotEmpty(value)) {
                    Object startStr = value.subSequence(0, 1);
                    String endStr = value.substring(1);
                    sb.append("").append(startStr).append("=").append(endStr).append(",");
                }
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return this.getComment();
        }
    }

    public String readNameNoSuffix() {
        return StrUtil.isNotEmpty(this.getComment()) ? this.getComment().replaceAll("(?:\\（)[^\\(\\)]*(?:\\）)", StrUtil.EMPTY) : this.getComment();
    }

}