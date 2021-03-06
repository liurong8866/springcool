package com.springcool.cool.system.notice.mapper;

import com.springcool.cool.system.api.notice.dto.SysNoticeDto;
import com.springcool.cool.system.api.notice.po.SysNoticePo;
import com.springcool.cool.system.api.notice.query.SysNoticeQuery;
import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;

/**
 * 通知公告管理 数据层
 *
 * @author springcool
 */
@Isolate
public interface SysNoticeMapper extends BaseMapper<SysNoticeQuery, SysNoticeDto, SysNoticePo> {
}
