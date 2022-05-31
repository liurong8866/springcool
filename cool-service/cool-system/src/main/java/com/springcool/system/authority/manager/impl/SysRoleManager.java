package com.springcool.system.authority.manager.impl;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.system.authority.mapper.merge.SysRoleModuleMergeMapper;
import com.springcool.system.organize.domain.merge.SysOrganizeRoleMerge;
import com.springcool.system.organize.domain.merge.SysRoleDeptMerge;
import com.springcool.system.organize.domain.merge.SysRolePostMerge;
import com.springcool.system.organize.mapper.merge.SysOrganizeRoleMergeMapper;
import com.springcool.system.organize.mapper.merge.SysRoleDeptMergeMapper;
import com.springcool.system.organize.mapper.merge.SysRolePostMergeMapper;
import com.springcool.common.core.constant.basic.SqlConstants;
import com.springcool.common.web.entity.manager.impl.BaseManager;
import com.springcool.system.api.authority.domain.dto.SysRoleDto;
import com.springcool.system.api.authority.domain.model.SysRoleConverter;
import com.springcool.system.api.authority.domain.po.SysRolePo;
import com.springcool.system.api.authority.domain.query.SysRoleQuery;
import com.springcool.system.authority.domain.merge.SysRoleMenuMerge;
import com.springcool.system.authority.domain.merge.SysRoleModuleMerge;
import com.springcool.system.authority.manager.ISysRoleManager;
import com.springcool.system.authority.mapper.SysRoleMapper;
import com.springcool.system.authority.mapper.merge.SysRoleMenuMergeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * 角色管理 数据封装层处理
 *
 * @author springcool
 */
@Component
public class SysRoleManager extends BaseManager<SysRoleQuery, SysRoleDto, SysRolePo, SysRoleMapper, SysRoleConverter> implements ISysRoleManager {

    @Autowired
    private SysRoleModuleMergeMapper roleModuleMergeMapper;

    @Autowired
    private SysRoleMenuMergeMapper roleMenuMergeMapper;

    @Autowired
    private SysRoleDeptMergeMapper roleDeptMergeMapper;

    @Autowired
    private SysRolePostMergeMapper rolePostMergeMapper;

    @Autowired
    private SysOrganizeRoleMergeMapper organizeRoleMergeMapper;

    /**
     * 修改角色组织权限
     *
     * @param id        id
     * @param roleKey   权限字符串
     * @param dataScope 数据范围
     * @return 结果
     */
    @Override
    public int updateDataScope(Long id, String roleKey, String dataScope) {
        return baseMapper.update(new SysRoleDto(),
                Wrappers.<SysRolePo>update().lambda()
                        .set(SysRolePo::getDataScope, dataScope)
                        .set(SysRolePo::getRoleKey, roleKey)
                        .eq(SysRolePo::getId, id));
    }

    /**
     * 校验角色编码是否唯一
     *
     * @param Id   角色Id
     * @param code 角色编码
     * @return 角色对象
     */
    @Override
    public SysRoleDto checkRoleCodeUnique(Long Id, String code) {
        SysRolePo role = baseMapper.selectOne(
                Wrappers.<SysRolePo>query().lambda()
                        .ne(SysRolePo::getId, Id)
                        .eq(SysRolePo::getCode, code)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(role);
    }

    /**
     * 校验角色权限是否唯一
     *
     * @param Id      角色Id
     * @param roleKey 角色权限
     * @return 角色对象
     */
    @Override
    public SysRoleDto checkRoleKeyUnique(Long Id, String roleKey) {
        SysRolePo role = baseMapper.selectOne(
                Wrappers.<SysRolePo>query().lambda()
                        .ne(SysRolePo::getId, Id)
                        .eq(SysRolePo::getRoleKey, roleKey)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperDto(role);
    }

    /**
     * 根据Id删除角色对象
     *
     * @param id Id
     * @return 结果
     */
    @Override
    @DSTransactional
    public int deleteById(Serializable id) {
        int row = baseMapper.deleteById(id);
        if (row > 0) {
            roleModuleMergeMapper.delete(
                    Wrappers.<SysRoleModuleMerge>update().lambda()
                            .eq(SysRoleModuleMerge::getRoleId, id));
            roleMenuMergeMapper.delete(
                    Wrappers.<SysRoleMenuMerge>update().lambda()
                            .eq(SysRoleMenuMerge::getRoleId, id));
            roleDeptMergeMapper.delete(
                    Wrappers.<SysRoleDeptMerge>update().lambda()
                            .eq(SysRoleDeptMerge::getRoleId, id));
            rolePostMergeMapper.delete(
                    Wrappers.<SysRolePostMerge>update().lambda()
                            .eq(SysRolePostMerge::getRoleId, id));
            organizeRoleMergeMapper.delete(
                    Wrappers.<SysOrganizeRoleMerge>update().lambda()
                            .eq(SysOrganizeRoleMerge::getRoleId, id));
        }
        return row;
    }

    /**
     * 根据Id集合批量删除角色对象
     *
     * @param idList Id集合
     * @return 结果
     */
    @Override
    @DSTransactional
    public int deleteByIds(Collection<? extends Serializable> idList) {
        int rows = baseMapper.deleteBatchIds(idList);
        if (rows > 0) {
            roleModuleMergeMapper.delete(
                    Wrappers.<SysRoleModuleMerge>update().lambda()
                            .in(SysRoleModuleMerge::getRoleId, idList));
            roleMenuMergeMapper.delete(
                    Wrappers.<SysRoleMenuMerge>update().lambda()
                            .in(SysRoleMenuMerge::getRoleId, idList));
            roleDeptMergeMapper.delete(
                    Wrappers.<SysRoleDeptMerge>update().lambda()
                            .in(SysRoleDeptMerge::getRoleId, idList));
            rolePostMergeMapper.delete(
                    Wrappers.<SysRolePostMerge>update().lambda()
                            .in(SysRolePostMerge::getRoleId, idList));
            organizeRoleMergeMapper.delete(
                    Wrappers.<SysOrganizeRoleMerge>update().lambda()
                            .in(SysOrganizeRoleMerge::getRoleId, idList));
        }
        return rows;
    }
}
