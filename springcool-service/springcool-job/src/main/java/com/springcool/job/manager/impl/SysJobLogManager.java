package com.springcool.job.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.job.manager.ISysJobLogManager;
import com.springcool.job.mapper.SysJobLogMapper;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.job.api.domain.dto.SysJobLogDto;
import com.springcool.job.api.domain.model.SysJobLogConverter;
import com.springcool.job.api.domain.po.SysJobLogPo;
import com.springcool.job.api.domain.query.SysJobLogQuery;
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
