package com.springcool.system.notice.service.impl;

import com.springcool.system.notice.domain.dto.SysNoticeDto;
import com.springcool.system.notice.domain.query.SysNoticeQuery;
import com.springcool.system.notice.manager.ISysNoticeManager;
import com.springcool.common.datascope.annotation.DataScope;
import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.system.notice.service.ISysNoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.springcool.common.core.constant.basic.SecurityConstants.CREATE_BY;

/**
 * 通知公告管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysNoticeServiceImpl extends BaseServiceImpl<SysNoticeQuery, SysNoticeDto, ISysNoticeManager> implements ISysNoticeService {

    /**
     * 查询通知公告对象列表 | 数据权限 | 附加数据
     *
     * @param notice 通知公告对象
     * @return 通知公告对象集合
     */
    @Override
    @DataScope(userAlias = CREATE_BY, mapperScope = {"SysNoticeMapper"})
    public List<SysNoticeDto> selectListScope(SysNoticeQuery notice) {
        return baseManager.selectListExtra(notice);
    }
}