package com.springcool.cool.common.web.entity.controller;

import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import com.springcool.cool.common.core.web.entity.base.SubBaseEntity;
import com.springcool.cool.common.core.web.result.AjaxResult;
import com.springcool.cool.common.core.web.validate.V_E;
import com.springcool.cool.common.web.entity.controller.handle.SubBaseHandleController;
import com.springcool.cool.common.web.entity.service.IBaseService;
import com.springcool.cool.common.web.entity.service.ISubBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 操作层 主子基类通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Dto
 * @param <IDS> DtoService
 * @param <SQ>  SubQuery
 * @param <SD>  SubDto
 * @param <ISS> SubService
 * @author springcool
 */
public abstract class SubBaseController<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, IDS extends ISubBaseService<Q, D, SQ, SD>, SQ extends BaseEntity, SD extends BaseEntity, ISS extends IBaseService<SQ, SD>> extends SubBaseHandleController<Q, D, IDS, SQ, SD, ISS> {

    /**
     * 主子型 修改
     * 考虑归属数据状态
     *
     * @see #EHandleSubStatusValidated(SubBaseEntity) 主子树型 归属数据状态逻辑校验
     */
    @Override
    public AjaxResult edit(@Validated({V_E.class}) @RequestBody D d) {
        EHandleSubStatusValidated(d);
        return super.edit(d);
    }

    /**
     * 主子型 修改
     * 考虑归属数据状态
     *
     * @see #ESHandleSubStatusValidated(SubBaseEntity)  主子树型 归属数据状态逻辑校验
     */
    public AjaxResult editStatus(@RequestBody D d) {
        ESHandleSubStatusValidated(d);
        return super.editStatus(d);
    }

    /**
     * 主子型 批量删除
     * 考虑归属数据存在与否&&子节点存在与否
     *
     * @see #RHandleEmptyValidated(List)   基类 空校验
     * @see #RHandleSubValidated(List)  主子型 归属数据存在与否校验
     */
    @Override
    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
        RHandleEmptyValidated(idList);
        RHandleValidated(BaseConstants.Operate.DELETE, idList);
        RHandleEmptyValidated(idList);
        RHandleSubValidated(idList);
        return toAjax(baseService.deleteByIds(idList));
    }
}
