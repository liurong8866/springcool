package com.springcool.cool.common.web.entity.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.springcool.cool.common.web.entity.manager.ISubBaseManager;
import com.springcool.cool.common.web.entity.service.ISubBaseService;
import com.springcool.cool.common.web.entity.service.impl.handle.SubBaseHandleServiceImpl;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import com.springcool.cool.common.core.web.entity.base.SubBaseEntity;
import com.springcool.cool.common.web.entity.service.IBaseService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 服务层 主子基类实现通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Dto
 * @param <IDG> DtoIManager
 * @param <SQ>  SubQuery
 * @param <SD>  SubDto
 * @param <ISS> SubIService
 * @author springcool
 */
public abstract class SubBaseServiceImpl<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, IDG extends ISubBaseManager<Q, D, SQ, SD>, SQ extends BaseEntity, SD extends BaseEntity, ISS extends IBaseService<SQ, SD>> extends SubBaseHandleServiceImpl<Q, D, IDG, SQ, SD, ISS> implements ISubBaseService<Q, D, SQ, SD> {

    /**
     * 根据外键查询子数据对象集合 | 子数据
     *
     * @param foreignKey 外键
     * @return 子数据对象集合
     */
    @Override
    public List<SD> selectSubByForeignKey(Serializable foreignKey) {
        return baseManager.selectSubByForeignKey(foreignKey);
    }

    /**
     * 新增数据对象
     *
     * @param d 数据对象
     * @return 结果
     */
    @Override
    @DSTransactional
    public int insert(D d) {
        int i = baseManager.insert(d);
        if (CollUtil.isNotEmpty(d.getSubList())) {
            setForeignKey(d.getSubList(), d);
            subService.insertBatch(d.getSubList());
        }
        return i;
    }

    /**
     * 修改数据对象
     * 同步停用 子数据状态
     *
     * @param d 数据对象
     * @return 结果
     * @see #UUSHandleSubStatusCheck(Serializable, String) 主子树型 检查归属数据状态
     */
    @Override
    @DSTransactional
    public int update(D d) {
        UUSHandleSubStatusCheck(d.getId(), d.getStatus());
        return super.update(d);
    }

    /**
     * 修改数据对象状态
     * 同步停用 子数据状态
     *
     * @param id     Id
     * @param status 状态
     * @return 结果
     * @see #UUSHandleSubStatusCheck(Serializable, String) 主子树型 检查归属数据状态
     */
    @Override
    @DSTransactional
    public int updateStatus(Serializable id, String status) {
        UUSHandleSubStatusCheck(id, status);
        return super.updateStatus(id, status);
    }

    /**
     * 根据Id删除数据对象
     * 同步删除 子数据
     *
     * @param id Id
     * @return 结果
     */
    @Override
    @DSTransactional
    public int deleteById(Serializable id) {
        baseManager.deleteSub(id);
        return super.deleteById(id);
    }

    /**
     * 根据Id集合删除数据对象
     * 同步删除 子数据
     *
     * @param idList Id集合
     * @return 结果
     */
    @Override
    @DSTransactional
    public int deleteByIds(Collection<? extends Serializable> idList) {
        for (Serializable Id : idList)
            baseManager.deleteSub(Id);
        return super.deleteByIds(idList);
    }

    /**
     * 根据Id修改其归属数据的状态
     *
     * @param id     Id
     * @param status 状态
     * @return 结果
     */
    @Override
    public int updateSubStatus(Serializable id, String status) {
        return baseManager.updateSubStatus(id, status);
    }

    /**
     * 根据Id删除其归属数据
     *
     * @param id Id
     * @return 结果
     */
    @Override
    public int deleteSub(Serializable id) {
        return baseManager.deleteSub(id);
    }

    /**
     * 校验是否存在子数据
     *
     * @param id Id
     * @return 结果 | true/false 存在/不存在
     */
    @Override
    public boolean checkExistSub(Serializable id) {
        return ObjectUtil.isNotNull(baseManager.checkExistSub(id));
    }

    /**
     * 校验是否存在启用（正常状态）的子数据
     *
     * @param id Id
     * @return 结果 | true/false 存在/不存在
     */
    @Override
    public boolean checkExistNormalSub(Serializable id) {
        return ObjectUtil.isNotNull(baseManager.checkExistNormalSub(id));
    }
}
