package com.springcool.tenant.source.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.springcool.tenant.source.manager.impl.TeSourceManager;
import com.springcool.common.core.constant.basic.DictConstants;
import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.tenant.api.source.domain.dto.TeSourceDto;
import com.springcool.tenant.api.source.domain.query.TeSourceQuery;
import com.springcool.tenant.source.service.ITeSourceService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 数据源管理 服务层处理
 *
 * @author xueyi
 */
@Service
public class TeSourceServiceImpl extends BaseServiceImpl<TeSourceQuery, TeSourceDto, TeSourceManager> implements ITeSourceService {

    /**
     * 校验数据源是否为默认数据源
     *
     * @param id 数据源id
     * @return 结果 | true/false 是/不是
     */
    @Override
    public boolean checkIsDefault(Long id) {
        TeSourceDto source = baseManager.selectById(id);
        return ObjectUtil.isNotNull(source) && StrUtil.equals(source.getIsDefault(), DictConstants.DicYesNo.YES.getCode());
    }

    /**
     * 新增数据源对象（批量）
     *
     * @param sourceList 数据源对象集合
     * @return 结果
     */
    @Override
    public int insertBatch(Collection<TeSourceDto> sourceList) {
        if (CollUtil.isNotEmpty(sourceList))
            sourceList.forEach(source -> source.setSlave(IdUtil.simpleUUID()));
        return super.insertBatch(sourceList);
    }
}