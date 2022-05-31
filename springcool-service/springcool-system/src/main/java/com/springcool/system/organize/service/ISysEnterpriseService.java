package com.springcool.system.organize.service;

import com.springcool.common.web.entity.service.IBaseService;
import com.springcool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.system.api.organize.domain.query.SysEnterpriseQuery;

/**
 * 企业管理 服务层
 *
 * @author springcool
 */
public interface ISysEnterpriseService extends IBaseService<SysEnterpriseQuery, SysEnterpriseDto> {

    /**
     * 根据名称查询状态正常企业对象
     *
     * @param name 名称
     * @return 企业对象
     */
    SysEnterpriseDto selectByName(String name);
}
