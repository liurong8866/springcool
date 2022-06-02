package com.springcool.cool.job.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.job.manager.ISysJobLogManager;
import com.springcool.cool.job.mapper.SysJobLogMapper;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.job.api.domain.dto.SysJobLogDto;
import com.springcool.cool.job.api.domain.model.SysJobLogConverter;
import com.springcool.cool.job.api.domain.po.SysJobLogPo;
import com.springcool.cool.job.api.domain.query.SysJobLogQuery;
import org.springframework.stereotype.Component;

/**
 * 调度任务日志管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysJobLogManager extends BaseManager<SysJobLogQuery, SysJobLogDto, SysJobLogPo, SysJobLogMapper, SysJobLogConverter> implements ISysJobLogManager {

    /**
     * 清空任务日志
     */
    @Override
    public void cleanLog() {
        baseMapper.delete(Wrappers.update());
    }
}
