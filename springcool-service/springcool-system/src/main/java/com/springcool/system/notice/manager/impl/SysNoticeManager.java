package com.springcool.system.notice.manager.impl;

import com.springcool.system.notice.domain.dto.SysNoticeDto;
import com.springcool.system.notice.domain.model.SysNoticeConverter;
import com.springcool.system.notice.domain.po.SysNoticePo;
import com.springcool.system.notice.domain.query.SysNoticeQuery;
import com.springcool.system.notice.mapper.SysNoticeMapper;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.system.notice.manager.ISysNoticeManager;
import org.springframework.stereotype.Component;

/**
 * 通知公告管理 数据封装层处理
 *
 * @author xueyi
 */
@Component
public class SysNoticeManager extends BaseManager<SysNoticeQuery, SysNoticeDto, SysNoticePo, SysNoticeMapper, SysNoticeConverter> implements ISysNoticeManager {
}
