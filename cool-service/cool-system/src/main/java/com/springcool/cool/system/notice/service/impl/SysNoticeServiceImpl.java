package com.springcool.cool.system.notice.service.impl;

import com.springcool.cool.system.api.notice.dto.SysNoticeDto;
import com.springcool.cool.system.api.notice.query.SysNoticeQuery;
import com.springcool.cool.system.notice.manager.ISysNoticeManager;
import com.springcool.cool.common.datascope.annotation.DataScope;
import com.springcool.cool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.cool.system.notice.service.ISysNoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.springcool.cool.common.core.constant.basic.SecurityConstants.CREATE_BY;

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