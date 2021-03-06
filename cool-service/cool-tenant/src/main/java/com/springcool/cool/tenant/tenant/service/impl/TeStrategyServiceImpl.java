package com.springcool.cool.tenant.tenant.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.springcool.cool.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.springcool.cool.tenant.tenant.manager.ITeStrategyManager;
import com.springcool.cool.tenant.tenant.service.ITeStrategyService;
import com.springcool.cool.common.core.constant.basic.DictConstants;
import com.springcool.cool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.cool.tenant.api.tenant.domain.query.TeStrategyQuery;
import org.springframework.stereotype.Service;

/**
 * 数据源策略管理 服务层处理
 *
 * @author springcool
 */
@Service
public class TeStrategyServiceImpl extends BaseServiceImpl<TeStrategyQuery, TeStrategyDto, ITeStrategyManager> implements ITeStrategyService {

    /**
     * 校验数据源是否被使用
     *
     * @param sourceId 数据源id
     * @return 结果 | true/false 存在/不存在
     */
    @Override
    public boolean checkSourceExist(Long sourceId) {
        return ObjectUtil.isNotNull(baseManager.checkSourceExist(sourceId));
    }

    /**
     * 校验源策略是否为默认源策略
     *
     * @param id 源策略id
     * @return 结果 | true/false 是/不是
     */
    @Override
    public boolean checkIsDefault(Long id) {
        TeStrategyDto strategy = baseManager.selectById(id);
        return ObjectUtil.isNotNull(strategy) && StrUtil.equals(strategy.getIsDefault(), DictConstants.DicYesNo.YES.getCode());
    }

}