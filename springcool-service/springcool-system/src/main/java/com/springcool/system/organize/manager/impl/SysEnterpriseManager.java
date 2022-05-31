package com.springcool.system.organize.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.system.organize.mapper.SysEnterpriseMapper;
import com.springcool.common.core.constant.basic.BaseConstants;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.system.api.organize.domain.dto.SysEnterpriseDto;
import com.springcool.system.api.organize.domain.model.SysEnterpriseConverter;
import com.springcool.system.api.organize.domain.po.SysEnterprisePo;
import com.springcool.system.api.organize.domain.query.SysEnterpriseQuery;
import com.springcool.system.organize.manager.ISysEnterpriseManager;
import org.springframework.stereotype.Component;

/**
 * 企业管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysEnterpriseManager extends BaseManager<SysEnterpriseQuery, SysEnterpriseDto, SysEnterprisePo, SysEnterpriseMapper, SysEnterpriseConverter> implements ISysEnterpriseManager {

    /**
     * 根据名称查询状态正常企业对象
     *
     * @param name 名称
     * @return 企业对象
     */
    @Override
    public SysEnterpriseDto selectByName(String name) {
        SysEnterprisePo enterprise = baseMapper.selectOne(
                Wrappers.<SysEnterprisePo>query().lambda()
                        .eq(SysEnterprisePo::getName, name)
                        .eq(SysEnterprisePo::getStatus, BaseConstants.Status.NORMAL.getCode()));
        return baseConverter.mapperDto(enterprise);
    }
}
