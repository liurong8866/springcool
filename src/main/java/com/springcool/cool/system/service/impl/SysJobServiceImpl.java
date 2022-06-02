package com.springcool.cool.system.service.impl;

import com.springcool.cool.system.domain.query.SysJobQuery;
import com.springcool.cool.system.domain.dto.SysJobDto;
import com.springcool.cool.system.service.ISysJobService;
import com.springcool.cool.system.manager.SysJobManager;
import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 定时任务调度管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysJobServiceImpl extends BaseServiceImpl<SysJobQuery, SysJobDto, SysJobManager> implements ISysJobService {

    /**
     * 查询定时任务调度对象列表 | 数据权限 | 附加数据
     *
     * @param job 定时任务调度对象
     * @return 定时任务调度对象集合
     */
    @Override
    //@DataScope(userAlias = "createBy", mapperScope = {"SysJobMapper"})
    public List<SysJobDto> selectListScope(SysJobQuery job) {
        return baseManager.selectListExtra(job);
    }

}