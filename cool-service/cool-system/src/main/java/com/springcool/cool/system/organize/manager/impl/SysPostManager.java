package com.springcool.cool.system.organize.manager.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.system.organize.manager.ISysPostManager;
import com.springcool.cool.system.organize.mapper.merge.SysOrganizeRoleMergeMapper;
import com.springcool.cool.system.organize.mapper.merge.SysRolePostMergeMapper;
import com.springcool.cool.system.api.organize.domain.merge.SysOrganizeRoleMerge;
import com.springcool.cool.system.api.organize.domain.merge.SysRolePostMerge;
import com.springcool.cool.system.organize.mapper.SysPostMapper;
import com.springcool.cool.common.core.constant.basic.SqlConstants;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.model.SysPostConverter;
import com.springcool.cool.system.api.organize.domain.po.SysPostPo;
import com.springcool.cool.system.api.organize.domain.query.SysPostQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 岗位管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysPostManager extends BaseManager<SysPostQuery, SysPostDto, SysPostPo, SysPostMapper, SysPostConverter> implements ISysPostManager {

    @Autowired
    SysOrganizeRoleMergeMapper organizeRoleMergeMapper;

    @Autowired
    SysRolePostMergeMapper rolePostMergeMapper;

    /**
     * 根据Id删除岗位对象
     *
     * @param id Id
     * @return 结果
     */
    @Override
    @DSTransactional
    public int deleteById(Serializable id) {
        int row = baseMapper.deleteById(id);
        if (row > 0) {
            organizeRoleMergeMapper.delete(
                    Wrappers.<SysOrganizeRoleMerge>update().lambda()
                            .eq(SysOrganizeRoleMerge::getPostId, id));
            rolePostMergeMapper.delete(
                    Wrappers.<SysRolePostMerge>update().lambda()
                            .eq(SysRolePostMerge::getPostId, id));
        }
        return row;
    }

    /**
     * 根据Id集合批量删除岗位对象
     *
     * @param idList Id集合
     * @return 结果
     */
    @Override
    @DSTransactional
    public int deleteByIds(Collection<? extends Serializable> idList) {
        int rows = baseMapper.deleteBatchIds(idList);
        if (rows > 0) {
            organizeRoleMergeMapper.delete(
                    Wrappers.<SysOrganizeRoleMerge>update().lambda()
                            .in(SysOrganizeRoleMerge::getPostId, idList));
            rolePostMergeMapper.delete(
                    Wrappers.<SysRolePostMerge>update().lambda()
                            .in(SysRolePostMerge::getPostId, idList));
        }
        return rows;
    }

    /**
     * 用户登录校验 | 根据部门Ids获取归属岗位对象集合
     *
     * @param deptIds 部门Ids
     * @return 岗位对象集合
     */
    @Override
    public List<SysPostDto> selectListByDeptIds(Collection<Long> deptIds) {
        if (CollUtil.isEmpty(deptIds))
            return new ArrayList<>();
        List<SysPostPo> postList = baseMapper.selectList(
                Wrappers.<SysPostPo>query().lambda()
                        .in(SysPostPo::getDeptId, deptIds));
        return baseConverter.mapperDto(postList);
    }

    /**
     * 校验岗位编码是否唯一
     *
     * @param Id   岗位Id
     * @param code 岗位编码
     * @return 岗位对象
     */
    @Override
    public SysPostDto checkPostCodeUnique(Long Id, String code) {
        SysPostPo post = baseMapper.selectOne(
                Wrappers.<SysPostPo>query().lambda()
                        .ne(SysPostPo::getId, Id)
                        .eq(SysPostPo::getCode, code)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(post);
    }
}
