package com.springcool.cool.system.organize.manager;

import com.springcool.cool.common.web.entity.manager.IBaseManager;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.query.SysPostQuery;

import java.util.Collection;
import java.util.List;

/**
 * 岗位管理 数据封装层
 *
 * @author springcool
 */
public interface ISysPostManager extends IBaseManager<SysPostQuery, SysPostDto> {

    /**
     * 用户登录校验 | 根据部门Ids获取归属岗位对象集合
     *
     * @param deptIds 部门Ids
     * @return 岗位对象集合
     */
    List<SysPostDto> selectListByDeptIds(Collection<Long> deptIds);

    /**
     * 校验岗位编码是否唯一
     *
     * @param Id   岗位Id
     * @param code 岗位编码
     * @return 岗位对象
     */
    SysPostDto checkPostCodeUnique(Long Id, String code);
}
