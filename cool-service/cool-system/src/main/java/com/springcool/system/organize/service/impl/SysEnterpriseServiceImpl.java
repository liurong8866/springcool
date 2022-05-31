package com.springcool.system.organize.service.impl;

import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.system.api.organize.domain.query.SysEnterpriseQuery;
import com.springcool.system.organize.manager.ISysEnterpriseManager;
import com.springcool.system.organize.service.ISysEnterpriseService;
import org.springframework.stereotype.Service;

/**
 * 企业管理 服务层处理
 *
 * @author springcool
 */
@Service
public class SysEnterpriseServiceImpl extends BaseServiceImpl<SysEnterpriseQuery, SysEnterpriseDto, ISysEnterpriseManager> implements ISysEnterpriseService {

    /**
     * 根据名称查询状态正常企业对象
     *
     * @param name 名称
     * @return 企业对象
     */
    @Override
    public SysEnterpriseDto selectByName(String name) {
        return baseManager.selectByName(name);
    }
}
