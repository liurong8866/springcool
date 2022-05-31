package com.springcool.gen.service;

import com.springcool.common.web.entity.service.IBaseService;
import com.springcool.gen.domain.dto.GenTableColumnDto;
import com.springcool.gen.domain.query.GenTableColumnQuery;

import java.util.List;

/**
 * 业务字段管理 服务层
 *
 * @author xueyi
 */
public interface IGenTableColumnService extends IBaseService<GenTableColumnQuery, GenTableColumnDto> {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    List<GenTableColumnDto> selectDbTableColumnsByName(String tableName);
}