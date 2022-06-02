package com.springcool.cool.system.service;

import com.springcool.cool.system.domain.query.SysJobQuery;
import com.springcool.cool.system.domain.dto.SysJobDto;
import com.springcool.common.web.entity.service.IBaseService;

/**
 * 定时任务调度管理 服务层
 *
 * @author springcool
 */
public interface ISysJobService extends IBaseService<SysJobQuery, SysJobDto> {
}