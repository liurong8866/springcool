package com.springcool.common.web.entity.controller.handle;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.springcool.common.web.entity.controller.BaseController;
import com.springcool.common.web.entity.controller.SubBaseController;
import com.springcool.common.core.constant.basic.BaseConstants;
import com.springcool.common.core.exception.ServiceException;
import com.springcool.common.core.utils.StringUtils;
import com.springcool.common.core.web.entity.base.BaseEntity;
import com.springcool.common.core.web.entity.base.SubBaseEntity;
import com.springcool.common.web.entity.service.IBaseService;
import com.springcool.common.web.entity.service.ISubBaseService;

import java.util.List;

/**
 * 操作层 操作方法 主子基类通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Dto
 * @param <IDS> DtoService
 * @param <SQ>  SubQuery
 * @param <SD>  SubDto
 * @param <ISS> SubService
 * @author springcool
 */
public abstract class SubBaseHandleController<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, IDS extends ISubBaseService<Q, D, SQ, SD>, SQ extends BaseEntity, SD extends BaseEntity, ISS extends IBaseService<SQ, SD>> extends BaseController<Q, D, IDS> {

    /** 定义子数据名称 */
    protected abstract String getSubName();

    /**
     * 主子型 修改 归属数据状态逻辑校验
     *
     * @param d 待修改数据对象
     * @see SubBaseController#edit(D)
     */
    protected void EHandleSubStatusValidated(D d) {
        if (StringUtils.equals(BaseConstants.Status.DISABLE.getCode(), d.getStatus())
                && baseService.checkExistNormalSub(d.getId()))
            throw new ServiceException(StrUtil.format("修改{}{}失败，该{}包含未停用的归属{}，禁止停用！", getNodeName(), d.getName(), getNodeName(), getSubName()));
    }

    /**
     * 主子型 修改状态 归属数据状态逻辑校验
     *
     * @param d 待修改数据对象
     * @see SubBaseController#editStatus(D)
     */
    protected void ESHandleSubStatusValidated(D d) {
        if (StringUtils.equals(BaseConstants.Status.DISABLE.getCode(), d.getStatus())
                && baseService.checkExistNormalSub(d.getId()))
            throw new ServiceException(StrUtil.format("停用失败，该{}包含未停用的归属{}！", getNodeName(), getSubName()));
    }

    /**
     * 主子型 删除 归属数据存在与否校验
     *
     * @param idList 待删除Id集合
     * @see SubBaseController#batchRemove(List)
     */
    protected void RHandleSubValidated(List<Long> idList) {
        int size = idList.size();
        // remove node where sub exist
        for (int i = idList.size() - 1; i >= 0; i--) {
            if (baseService.checkExistSub(idList.get(i)))
                idList.remove(i);
        }
        if (CollUtil.isEmpty(idList)) {
            throw new ServiceException(StrUtil.format("删除失败，所有待删除{}皆存在归属{}！", getNodeName(), getSubName()));
        } else if (idList.size() != size) {
            baseService.deleteByIds(idList);
            throw new ServiceException(StrUtil.format("成功删除所有无归属{}的{}！", getSubName(), getNodeName()));
        }
    }
}
