package com.springcool.cool.gen.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.springcool.cool.gen.domain.dto.GenTableColumnDto;
import com.springcool.cool.gen.domain.po.GenTableColumnPo;
import com.springcool.cool.gen.domain.query.GenTableColumnQuery;
import com.springcool.cool.common.web.entity.mapper.BaseMapper;

import java.util.List;

/**
 * 业务字段管理 数据层
 *
 * @author springcool
 */
public interface GenTableColumnMapper extends BaseMapper<GenTableColumnQuery, GenTableColumnDto, GenTableColumnPo> {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    @InterceptorIgnore(tenantLine = "1")
    List<GenTableColumnDto> selectDbTableColumnsByName(String tableName);

}