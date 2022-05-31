package com.springcool.system.notice.service;

import com.springcool.system.notice.domain.dto.SysNoticeDto;
import com.springcool.system.notice.domain.query.SysNoticeQuery;
import com.springcool.common.web.entity.service.IBaseService;

/**
 * 通知公告管理 服务层
 *
 * @author springcool
 */
public interface ISysNoticeService extends IBaseService<SysNoticeQuery, SysNoticeDto> {
}