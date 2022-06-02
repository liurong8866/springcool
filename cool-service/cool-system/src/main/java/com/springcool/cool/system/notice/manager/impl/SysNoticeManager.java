package com.springcool.cool.system.notice.manager.impl;

import com.springcool.cool.system.notice.domain.dto.SysNoticeDto;
import com.springcool.cool.system.notice.domain.model.SysNoticeConverter;
import com.springcool.cool.system.notice.domain.po.SysNoticePo;
import com.springcool.cool.system.notice.domain.query.SysNoticeQuery;
import com.springcool.cool.system.notice.mapper.SysNoticeMapper;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.system.notice.manager.ISysNoticeManager;
import org.springframework.stereotype.Component;

/**
 * 通知公告管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysNoticeManager extends BaseManager<SysNoticeQuery, SysNoticeDto, SysNoticePo, SysNoticeMapper, SysNoticeConverter> implements ISysNoticeManager {
}
