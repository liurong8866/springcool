package com.springcool.cool.system.authority.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.cool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.cool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.cool.system.api.authority.domain.query.SysModuleQuery;
import com.springcool.cool.system.api.authority.domain.model.LoginUser;
import com.springcool.cool.system.authority.service.ISysMenuService;
import com.springcool.cool.system.authority.service.ISysModuleService;
import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.common.core.exception.ServiceException;
import com.springcool.cool.common.core.utils.StringUtils;
import com.springcool.cool.common.core.web.result.AjaxResult;
import com.springcool.cool.common.core.web.validate.V_A;
import com.springcool.cool.common.core.web.validate.V_E;
import com.springcool.cool.common.log.annotation.Log;
import com.springcool.cool.common.log.enums.BusinessType;
import com.springcool.cool.common.security.annotation.Logical;
import com.springcool.cool.common.security.annotation.RequiresPermissions;
import com.springcool.cool.common.security.auth.Auth;
import com.springcool.cool.common.security.service.TokenService;
import com.springcool.cool.common.security.utils.SecurityUtils;
import com.springcool.cool.common.web.entity.controller.SubBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 模块管理 业务处理
 *
 * @author springcool
 */
@RestController
@RequestMapping("/module")
public class SysModuleController extends SubBaseController<SysModuleQuery, SysModuleDto, ISysModuleService, SysMenuQuery, SysMenuDto, ISysMenuService> {

    @Autowired
    private TokenService tokenService;

    /** 定义节点名称 */
    @Override
    protected String getNodeName() {
        return "模块";
    }

    /** 定义子数据名称 */
    @Override
    protected String getSubName() {
        return "菜单";
    }

    /**
     * 查询首页可展示模块信息列表
     */
    @GetMapping("/getRouters")
    public AjaxResult getRoutes() {
        LoginUser loginUser = tokenService.getLoginUser();
        if (ObjectUtil.isNull(loginUser.getModuleRoute())) {
            loginUser.setModuleRoute(baseService.getRoutes(loginUser.getRoleIds()));
            tokenService.setLoginUser(loginUser);
        }
        return AjaxResult.success(loginUser.getModuleRoute());
    }

    /**
     * 查询模块列表
     */
    @Override
    @GetMapping("/list")
    @RequiresPermissions(Auth.SYS_MODULE_LIST)
    public AjaxResult list(SysModuleQuery module) {
        return super.list(module);
    }

    /**
     * 查询模块详细
     */
    @Override
    @GetMapping(value = "/{id}")
    @RequiresPermissions(Auth.SYS_MODULE_SINGLE)
    public AjaxResult getInfoExtra(@PathVariable Serializable id) {
        return super.getInfoExtra(id);
    }

    /**
     * 模块导出
     */
    @Override
    @PostMapping("/export")
    @RequiresPermissions(Auth.SYS_MODULE_EXPORT)
    @Log(title = "模块管理", businessType = BusinessType.EXPORT)
    public void export(HttpServletResponse response, SysModuleQuery module) {
        super.export(response, module);
    }

    /**
     * 模块新增
     */
    @Override
    @PostMapping
    @RequiresPermissions(Auth.SYS_MODULE_ADD)
    @Log(title = "模块管理", businessType = BusinessType.INSERT)
    public AjaxResult add(@Validated({V_A.class}) @RequestBody SysModuleDto module) {
        return super.add(module);
    }

    /**
     * 模块修改
     */
    @Override
    @PutMapping
    @RequiresPermissions(Auth.SYS_MODULE_EDIT)
    @Log(title = "模块管理", businessType = BusinessType.UPDATE)
    public AjaxResult edit(@Validated({V_E.class}) @RequestBody SysModuleDto module) {
        return super.edit(module);
    }

    /**
     * 模块修改状态
     */
    @Override
    @PutMapping("/status")
    @RequiresPermissions(value = {Auth.SYS_MODULE_EDIT, Auth.SYS_MODULE_ES}, logical = Logical.OR)
    @Log(title = "模块管理", businessType = BusinessType.UPDATE_STATUS)
    public AjaxResult editStatus(@RequestBody SysModuleDto module) {
        return super.editStatus(module);
    }

    /**
     * 模块批量删除
     */
    @Override
    @DeleteMapping("/batch/{idList}")
    @RequiresPermissions(Auth.SYS_MODULE_DEL)
    @Log(title = "模块管理", businessType = BusinessType.DELETE)
    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
        return super.batchRemove(idList);
    }

    /**
     * 获取模块选择框列表
     */
    @Override
    @GetMapping("/option")
    public AjaxResult option() {
        return super.option();
    }

    /**
     * 新增/修改 前置校验
     */
    @Override
    protected void AEHandleValidated(BaseConstants.Operate operate, SysModuleDto module) {
        if (baseService.checkNameUnique(module.getId(), module.getName()))
            throw new ServiceException(StrUtil.format("{}{}{}失败，{}名称已存在！", operate.getInfo(), getNodeName(), module.getName(), getNodeName()));
        if (operate.isAdd() && SecurityUtils.isNotAdminTenant() && module.isCommon())
            throw new ServiceException(StrUtil.format("{}{}{}失败，无操作权限！", operate.getInfo(), getNodeName(), module.getName()));
        if (operate.isEdit()) {
            SysModuleDto original = baseService.selectById(module.getId());
            if (ObjectUtil.isNull(original))
                throw new ServiceException("数据不存在！");
            if (SecurityUtils.isNotAdminTenant() && original.isCommon())
                throw new ServiceException(StrUtil.format("{}{}{}失败，无操作权限！", operate.getInfo(), getNodeName(), module.getName()));
            if (!StringUtils.equals(module.getIsCommon(), original.getIsCommon()))
                throw new ServiceException(StrUtil.format("{}{}{}失败，公共{}属性禁止变更！", operate.getInfo(), getNodeName(), module.getName(), getNodeName()));
        }
    }
}
