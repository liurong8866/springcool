package com.springcool.gen.service.impl;

import com.springcool.gen.domain.dto.GenTableColumnDto;
import com.springcool.gen.manager.impl.GenTableColumnManager;
import com.springcool.gen.service.IGenTableColumnService;
import com.springcool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.gen.domain.query.GenTableColumnQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务字段管理 服务层实现
 *
 * @author xueyi
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