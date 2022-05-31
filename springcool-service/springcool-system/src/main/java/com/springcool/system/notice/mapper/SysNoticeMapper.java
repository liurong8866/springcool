package com.springcool.system.notice.mapper;

import com.springcool.system.notice.domain.po.SysNoticePo;
import com.springcool.common.datasource.annotation.Isolate;
import com.springcool.common.web.entity.mapper.BaseMapper;
import com.springcool.system.notice.domain.dto.SysNoticeDto;
import com.springcool.system.notice.domain.query.SysNoticeQuery;

/**
 * 通知公告管理 数据层
 *
 * @author xueyi
 */
@Isolate
public interface SysNoticeMapper extends BaseMapper<SysNoticeQuery, SysNoticeDto, SysNoticePo> {
}
