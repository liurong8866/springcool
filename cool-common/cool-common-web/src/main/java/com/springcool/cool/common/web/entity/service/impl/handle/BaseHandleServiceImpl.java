package com.springcool.cool.common.web.entity.service.impl.handle;

import com.springcool.cool.common.core.web.entity.base.BaseEntity;
import com.springcool.cool.common.web.entity.manager.IBaseManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务层 操作方法 基类实现通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Dto
 * @param <IDG> DtoIManager
 * @author springcool
 */
public class BaseHandleServiceImpl<Q extends BaseEntity, D extends BaseEntity, IDG extends IBaseManager<Q, D>> {

    @Autowired
    protected IDG baseManager;
}
