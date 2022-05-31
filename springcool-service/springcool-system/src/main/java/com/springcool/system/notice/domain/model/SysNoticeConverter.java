package com.springcool.system.notice.domain.model;

import com.springcool.system.notice.domain.po.SysNoticePo;
import com.springcool.system.notice.domain.query.SysNoticeQuery;
import com.springcool.common.core.web.entity.model.BaseConverter;
import com.springcool.system.notice.domain.dto.SysNoticeDto;
import org.mapstruct.Mapper;

/**
 * 通知公告 对象映射器
 *
 * @author springcool
 */
@Mapper(componentModel = "spring")
public interface SysNoticeConverter extends BaseConverter<SysNoticeQuery, SysNoticeDto, SysNoticePo> {
}
