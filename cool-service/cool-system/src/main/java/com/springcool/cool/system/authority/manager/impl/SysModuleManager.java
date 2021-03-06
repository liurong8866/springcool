package com.springcool.cool.system.authority.manager.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.cool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.cool.system.api.authority.domain.model.SysMenuConverter;
import com.springcool.cool.system.api.authority.domain.model.SysModuleConverter;
import com.springcool.cool.system.api.authority.domain.po.SysMenuPo;
import com.springcool.cool.system.api.authority.domain.po.SysModulePo;
import com.springcool.cool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.cool.system.api.authority.domain.query.SysModuleQuery;
import com.springcool.cool.system.api.authority.domain.merge.SysRoleModuleMerge;
import com.springcool.cool.system.api.authority.domain.merge.SysTenantModuleMerge;
import com.springcool.cool.system.authority.mapper.SysMenuMapper;
import com.springcool.cool.system.authority.mapper.SysModuleMapper;
import com.springcool.cool.system.authority.mapper.merge.SysTenantModuleMergeMapper;
import com.springcool.cool.system.authority.manager.ISysModuleManager;
import com.springcool.cool.system.authority.mapper.merge.SysRoleModuleMergeMapper;
import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.common.core.constant.basic.DictConstants;
import com.springcool.cool.common.security.utils.SecurityUtils;
import com.springcool.cool.common.web.entity.manager.impl.SubBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ???????????? ?????????????????????
 *
 * @author springcool
 */
@Component
public class SysModuleManager extends SubBaseManager<SysModuleQuery, SysModuleDto, SysModulePo, SysModuleMapper, SysModuleConverter, SysMenuQuery, SysMenuDto, SysMenuPo, SysMenuMapper, SysMenuConverter> implements ISysModuleManager {

    @Autowired
    private SysTenantModuleMergeMapper tenantModuleMergeMapper;

    @Autowired
    private SysRoleModuleMergeMapper roleModuleMergeMapper;

    /**
     * ??????????????????????????????????????????
     *
     * @param roleIds ??????Ids
     * @return ????????????
     */
    @Override
    public List<SysModuleDto> getRoutes(Set<Long> roleIds) {
        // ???????????? ? ???????????? ? ??????????????? + ?????????????????? : ????????????????????? + ???????????? : ?????????????????????????????????
        if (SecurityUtils.isAdminUser()) {
            if (SecurityUtils.isAdminTenant()) {
                List<SysModulePo> moduleList = baseMapper.selectList(
                        Wrappers.<SysModulePo>query().lambda()
                                .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode())
                                .eq(SysModulePo::getHideModule, DictConstants.DicShowHide.SHOW.getCode()));
                return baseConverter.mapperDto(moduleList);
            } else {
                List<SysTenantModuleMerge> tenantModuleMerges = tenantModuleMergeMapper.selectList(Wrappers.query());
                List<SysModulePo> moduleList = baseMapper.selectList(
                        Wrappers.<SysModulePo>query().lambda()
                                .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode())
                                .eq(SysModulePo::getHideModule, DictConstants.DicShowHide.SHOW.getCode())
                                .and(i -> i.
                                        eq(SysModulePo::getIsCommon, DictConstants.DicCommonPrivate.PRIVATE.getCode())
                                        .func(j -> {
                                            if (CollUtil.isNotEmpty(tenantModuleMerges)) {
                                                j.or(k -> k.
                                                        eq(SysModulePo::getIsCommon, DictConstants.DicCommonPrivate.COMMON.getCode())
                                                        .in(SysModulePo::getId, tenantModuleMerges.stream().map(SysTenantModuleMerge::getModuleId).collect(Collectors.toList())));
                                            }
                                        })
                                ));
                return baseConverter.mapperDto(moduleList);
            }
        } else {
            if (CollUtil.isEmpty(roleIds))
                return new ArrayList<>();
            List<SysRoleModuleMerge> roleModuleMerges = roleModuleMergeMapper.selectList(
                    Wrappers.<SysRoleModuleMerge>query().lambda()
                            .in(SysRoleModuleMerge::getRoleId, roleIds));
            return CollUtil.isNotEmpty(roleModuleMerges)
                    ? baseConverter.mapperDto(baseMapper.selectList(
                    Wrappers.<SysModulePo>query().lambda()
                            .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode())
                            .eq(SysModulePo::getHideModule, DictConstants.DicShowHide.SHOW.getCode())
                            .in(SysModulePo::getId, roleModuleMerges.stream().map(SysRoleModuleMerge::getModuleId).collect(Collectors.toList()))))
                    : new ArrayList<>();
        }
    }

    /**
     * ????????????????????????????????????????????????
     *
     * @return ??????????????????
     */
    @Override
    public List<SysModuleDto> selectCommonList() {
        // ?????????????????? ? ???????????? : ????????????-???????????????,????????????????????? ? ????????????????????????????????? : ???????????????
        if (SecurityUtils.isAdminTenant()) {
            List<SysModulePo> moduleList = baseMapper.selectList(Wrappers.<SysModulePo>query().lambda()
                    .eq(SysModulePo::getIsCommon, DictConstants.DicCommonPrivate.COMMON.getCode())
                    .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode()));
            return baseConverter.mapperDto(moduleList);
        } else {
            List<SysTenantModuleMerge> tenantModuleMerges = tenantModuleMergeMapper.selectList(Wrappers.query());
            return CollUtil.isNotEmpty(tenantModuleMerges)
                    ? baseConverter.mapperDto(baseMapper.selectList(Wrappers.<SysModulePo>query().lambda()
                    .eq(SysModulePo::getIsCommon, DictConstants.DicCommonPrivate.COMMON.getCode())
                    .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode())
                    .in(SysModulePo::getId, tenantModuleMerges.stream().map(SysTenantModuleMerge::getModuleId).collect(Collectors.toList()))))
                    : new ArrayList<>();
        }
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @return ??????????????????
     */
    @Override
    public List<SysModuleDto> selectTenantList() {
        // ?????????????????? ? ???????????? : ????????????-???????????????,????????????????????? ? ?????????????????????????????????????????????????????? : ????????????????????????
        if (SecurityUtils.isAdminTenant()) {
            List<SysModulePo> moduleList = baseMapper.selectList(Wrappers.<SysModulePo>query().lambda()
                    .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode()));
            return baseConverter.mapperDto(moduleList);
        } else {
            List<SysTenantModuleMerge> tenantModuleMerges = tenantModuleMergeMapper.selectList(Wrappers.query());
            List<SysModulePo> moduleList = baseMapper.selectList(Wrappers.<SysModulePo>query().lambda()
                    .eq(SysModulePo::getStatus, BaseConstants.Status.NORMAL.getCode())
                    .func(i -> {
                        if (CollUtil.isNotEmpty(tenantModuleMerges))
                            i.and(j -> j.
                                    eq(SysModulePo::getIsCommon, DictConstants.DicCommonPrivate.PRIVATE.getCode())
                                    .or().in(SysModulePo::getId, tenantModuleMerges.stream().map(SysTenantModuleMerge::getModuleId).collect(Collectors.toList()))
                            );
                        else
                            i.eq(SysModulePo::getIsCommon, DictConstants.DicCommonPrivate.PRIVATE.getCode());
                    }));
            return baseConverter.mapperDto(moduleList);
        }
    }

    /**
     * ??????Id?????????????????? | ???????????????????????????
     *
     * @param id Id
     * @return ??????
     */
    @Override
    @DSTransactional
    public int deleteById(Serializable id) {
        roleModuleMergeMapper.delete(
                Wrappers.<SysRoleModuleMerge>update().lambda()
                        .eq(SysRoleModuleMerge::getModuleId, id));
        return super.deleteById(id);
    }

    /**
     * ??????Id?????????????????????????????? | ???????????????????????????
     *
     * @param idList Id??????
     * @return ??????
     */
    @Override
    @DSTransactional
    public int deleteByIds(Collection<? extends Serializable> idList) {
        roleModuleMergeMapper.delete(
                Wrappers.<SysRoleModuleMerge>update().lambda()
                        .in(SysRoleModuleMerge::getModuleId, idList));
        return super.deleteByIds(idList);
    }

    /**
     * ?????????????????????????????????
     */
    @Override
    protected void setForeignKey(LambdaQueryWrapper<SysMenuPo> queryWrapper, LambdaUpdateWrapper<SysMenuPo> updateWrapper, SysModuleDto module, Serializable key) {
        Serializable moduleId = ObjectUtil.isNotNull(module) ? module.getId() : key;
        if (ObjectUtil.isNotNull(queryWrapper))
            queryWrapper.eq(SysMenuPo::getModuleId, moduleId);
        else
            updateWrapper.eq(SysMenuPo::getModuleId, moduleId);
    }
}
