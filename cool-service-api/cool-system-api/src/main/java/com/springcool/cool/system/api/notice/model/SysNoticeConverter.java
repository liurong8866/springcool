package com.springcool.cool.system.api.notice.model;

import com.springcool.cool.system.api.notice.dto.SysNoticeDto;
import com.springcool.cool.system.api.notice.po.SysNoticePo;
import com.springcool.cool.system.api.notice.query.SysNoticeQuery;
import com.springcool.cool.common.core.web.entity.model.BaseConverter;
import org.mapstruct.Mapper;

/**
 * 通知公告 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysNoticeConverter extends BaseConverter<SysNoticeQuery, SysNoticeDto, SysNoticePo> {
}
