package com.springcool.system.notice.manager;

import com.springcool.system.notice.domain.dto.SysNoticeDto;
import com.springcool.system.notice.domain.query.SysNoticeQuery;
import com.springcool.common.web.entity.manager.IBaseManager;

/**
 * 通知公告管理 数据封装层
 *
 * @author springcool
 */
public interface ISysNoticeManager extends IBaseManager<SysNoticeQuery, SysNoticeDto> {
}
