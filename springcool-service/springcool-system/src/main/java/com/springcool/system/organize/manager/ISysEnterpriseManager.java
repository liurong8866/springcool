package com.springcool.system.organize.manager;

import com.springcool.common.web.entity.manager.IBaseManager;
import com.springcool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.system.api.organize.domain.query.SysEnterpriseQuery;

/**
 * 企业管理 数据封装层
 *
 * @author springcool
 */
public interface ISysEnterpriseManager extends IBaseManager<SysEnterpriseQuery, SysEnterpriseDto> {

    /**
     * 根据名称查询状态正常企业对象
     *
     * @param name 名称
     * @return 企业对象
     */
    SysEnterpriseDto selectByName(String name);
}
