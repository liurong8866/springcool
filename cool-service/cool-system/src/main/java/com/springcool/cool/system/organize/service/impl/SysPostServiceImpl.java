package com.springcool.cool.system.organize.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.common.datascope.annotation.DataScope;
import com.springcool.cool.common.datasource.annotation.Isolate;
import com.springcool.cool.common.web.entity.service.impl.BaseServiceImpl;
import com.springcool.cool.system.organize.service.ISysPostService;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.query.SysPostQuery;
import com.springcool.cool.system.organize.manager.impl.SysPostManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * 岗位管理 服务层处理
 *
 * @author springcool
 */
@Service
@Isolate
public class SysPostServiceImpl extends BaseServiceImpl<SysPostQuery, SysPostDto, SysPostManager> implements ISysPostService {

    /**
     * 用户登录校验 | 根据部门Ids获取归属岗位对象集合
     *
     * @param deptIds 部门Ids
     * @return 岗位对象集合
     */
    @Override
    public List<SysPostDto> selectListByDeptIds(Collection<Long> deptIds) {
        return baseManager.selectListByDeptIds(deptIds);
    }

    /**
     * 新增岗位 | 内部调用
     *
     * @param post 岗位对象
     * @return 结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addInner(SysPostDto post) {
        return baseManager.insert(post);
    }

    /**
     * 查询岗位对象列表 | 数据权限 | 附加数据
     *
     * @param post 岗位对象
     * @return 岗位对象集合
     */
    @Override
    @DataScope(postAlias = "id", mapperScope = {"SysPostMapper"})
    public List<SysPostDto> selectListScope(SysPostQuery post) {
        return baseManager.selectListExtra(post);
    }

    /**
     * 校验岗位编码是否唯一
     *
     * @param Id   岗位Id
     * @param code 岗位编码
     * @return 结果 | true/false 唯一/不唯一
     */
    @Override
    public boolean checkPostCodeUnique(Long Id, String code) {
        return ObjectUtil.isNotNull(baseManager.checkPostCodeUnique(ObjectUtil.isNull(Id) ? BaseConstants.NONE_ID : Id, code));
    }
}
