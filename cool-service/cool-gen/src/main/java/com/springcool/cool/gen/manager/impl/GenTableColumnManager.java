package com.springcool.cool.gen.manager.impl;

import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.gen.domain.dto.GenTableColumnDto;
import com.springcool.cool.gen.domain.model.GenTableColumnConverter;
import com.springcool.cool.gen.domain.po.GenTableColumnPo;
import com.springcool.cool.gen.manager.IGenTableColumnManager;
import com.springcool.cool.gen.domain.query.GenTableColumnQuery;
import com.springcool.cool.gen.mapper.GenTableColumnMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 业务字段管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class GenTableColumnManager extends BaseManager<GenTableColumnQuery, GenTableColumnDto, GenTableColumnPo, GenTableColumnMapper, GenTableColumnConverter> implements IGenTableColumnManager {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    @Override
    public List<GenTableColumnDto> selectDbTableColumnsByName(String tableName) {
        return baseMapper.selectDbTableColumnsByName(tableName);
    }
}
