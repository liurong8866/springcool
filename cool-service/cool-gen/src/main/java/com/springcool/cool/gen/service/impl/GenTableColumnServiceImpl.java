package com.springcool.cool.gen.service.impl;

import com.springcool.cool.gen.service.IGenTableColumnService;
import com.springcool.cool.gen.domain.dto.GenTableColumnDto;
import com.springcool.cool.gen.manager.impl.GenTableColumnManager;
import com.springcool.cool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.cool.gen.domain.query.GenTableColumnQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务字段管理 服务层实现
 *
 * @author springcool
 */
@Service
public class GenTableColumnServiceImpl extends BaseServiceImpl<GenTableColumnQuery, GenTableColumnDto, GenTableColumnManager> implements IGenTableColumnService {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    @Override
    public List<GenTableColumnDto> selectDbTableColumnsByName(String tableName) {
        return baseManager.selectDbTableColumnsByName(tableName);
    }
}