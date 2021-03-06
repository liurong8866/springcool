package com.springcool.cool.gen.service;

import com.alibaba.fastjson.JSONObject;
import com.springcool.cool.common.web.entity.service.ISubBaseService;
import com.springcool.cool.gen.domain.dto.GenTableColumnDto;
import com.springcool.cool.gen.domain.dto.GenTableDto;
import com.springcool.cool.gen.domain.query.GenTableColumnQuery;
import com.springcool.cool.gen.domain.query.GenTableQuery;

import java.util.List;

/**
 * 业务管理 服务层
 *
 * @author springcool
 */
public interface IGenTableService extends ISubBaseService<GenTableQuery, GenTableDto, GenTableColumnQuery, GenTableColumnDto> {

    /**
     * 查询据库列表
     *
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    List<GenTableDto> selectDbTableList(GenTableDto genTable);

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    List<GenTableDto> selectDbTableListByNames(String[] tableNames);

    /**
     * 导入表结构
     *
     * @param tableList 导入表列表
     */
    void importGenTable(List<GenTableDto> tableList);

    /**
     * 预览代码
     *
     * @param id Id
     * @return 预览数据列表
     */
    List<JSONObject> previewCode(Long id);

    /**
     * 生成代码（下载方式）
     *
     * @param id Id
     * @return 数据
     */
    byte[] downloadCode(Long id);

    /**
     * 生成代码（自定义路径）
     *
     * @param id Id
     */
    void generatorCode(Long id);

    /**
     * 同步数据库
     *
     * @param tableName 表名称
     */
    void syncDb(String tableName);

    /**
     * 批量生成代码（下载方式）
     *
     * @param ids Ids数组
     * @return 数据
     */
    byte[] downloadCode(Long[] ids);

    /**
     * 修改保存参数校验
     *
     * @param genTable 业务信息
     */
    void validateEdit(GenTableDto genTable);

}