package com.springcool.cool.system.organize.manager;

import com.springcool.cool.common.web.entity.manager.ISubTreeManager;
import com.springcool.cool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.query.SysDeptQuery;
import com.springcool.cool.system.api.organize.domain.query.SysPostQuery;

/**
 * 部门管理 数据封装层
 *
 * @author springcool
 */
public interface ISysDeptManager extends ISubTreeManager<SysDeptQuery, SysDeptDto, SysPostQuery, SysPostDto> {

    /**
     * 校验部门编码是否唯一
     *
     * @param Id   部门Id
     * @param code 部门编码
     * @return 部门对象
     */
    SysDeptDto checkDeptCodeUnique(Long Id, String code);
}
