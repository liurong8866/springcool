package com.springcool.cool.job.manager.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.job.manager.ISysJobManager;
import com.springcool.cool.job.mapper.SysJobLogMapper;
import com.springcool.cool.job.mapper.SysJobMapper;
import com.springcool.cool.common.web.annotation.TenantIgnore;
import com.springcool.cool.common.web.entity.manager.impl.SubBaseManager;
import com.springcool.cool.job.api.domain.dto.SysJobDto;
import com.springcool.cool.job.api.domain.dto.SysJobLogDto;
import com.springcool.cool.job.api.domain.model.SysJobConverter;
import com.springcool.cool.job.api.domain.model.SysJobLogConverter;
import com.springcool.cool.job.api.domain.po.SysJobLogPo;
import com.springcool.cool.job.api.domain.po.SysJobPo;
import com.springcool.cool.job.api.domain.query.SysJobLogQuery;
import com.springcool.cool.job.api.domain.query.SysJobQuery;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 调度任务管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysJobManager extends SubBaseManager<SysJobQuery, SysJobDto, SysJobPo, SysJobMapper, SysJobConverter, SysJobLogQuery, SysJobLogDto, SysJobLogPo, SysJobLogMapper, SysJobLogConverter> implements ISysJobManager {

    /**
     * 项目启动时
     */
    @Override
    @TenantIgnore(tenantLine = true)
    public List<SysJobDto> initScheduler() {
        List<SysJobPo> jobList = baseMapper.selectList(Wrappers.query());
        return baseConverter.mapperDto(jobList);
    }

    /**
     * 设置主子表中子表外键值
     */
    @Override
    protected void setForeignKey(LambdaQueryWrapper<SysJobLogPo> queryWrapper, LambdaUpdateWrapper<SysJobLogPo> updateWrapper, SysJobDto job, Serializable key) {
        Serializable jobGroup = ObjectUtil.isNotNull(job) ? job.getJobGroup() : key;
        if (ObjectUtil.isNotNull(queryWrapper))
            queryWrapper.eq(SysJobLogPo::getJobGroup, jobGroup);
        else
            updateWrapper.eq(SysJobLogPo::getJobGroup, jobGroup);
    }
}
