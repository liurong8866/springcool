package com.springcool.cool.system.authority.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.springcool.cool.system.api.authority.domain.dto.SysMenuDto;
import com.springcool.cool.system.api.authority.domain.dto.SysModuleDto;
import com.springcool.cool.system.api.authority.domain.query.SysMenuQuery;
import com.springcool.cool.system.api.authority.domain.model.LoginUser;
import com.springcool.cool.system.authority.service.ISysMenuService;
import com.springcool.cool.system.authority.service.ISysModuleService;
import com.springcool.cool.common.core.constant.basic.BaseConstants;
import com.springcool.cool.common.core.constant.system.AuthorityConstants;
import com.springcool.cool.common.core.domain.R;
import com.springcool.cool.common.core.exception.ServiceException;
import com.springcool.cool.common.core.utils.StringUtils;
import com.springcool.cool.common.core.utils.TreeUtils;
import com.springcool.cool.common.core.web.result.AjaxResult;
import com.springcool.cool.common.core.web.validate.V_A;
import com.springcool.cool.common.core.web.validate.V_E;
import com.springcool.cool.common.log.annotation.Log;
import com.springcool.cool.common.log.enums.BusinessType;
import com.springcool.cool.common.security.annotation.InnerAuth;
import com.springcool.cool.common.security.annotation.Logical;
import com.springcool.cool.common.security.annotation.RequiresPermissions;
import com.springcool.cool.common.security.auth.Auth;
import com.springcool.cool.common.security.service.TokenService;
import com.springcool.cool.common.security.utils.SecurityUtils;
import com.springcool.cool.common.web.entity.controller.TreeController;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ???????????? ????????????
 *
 * @author springcool
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController extends TreeController<SysMenuQuery, SysMenuDto, ISysMenuService> {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysModuleService moduleService;

    /** ?????????????????? */
    @Override
    protected String getNodeName() {
        return "??????";
    }

    /** ????????????????????? */
    protected String getParentName() {
        return "??????";
    }

    /**
     * ???????????????????????????????????? | ????????????
     */
    @InnerAuth
    @GetMapping("/inner/{id}")
    public R<SysMenuDto> getInfoInner(@PathVariable Serializable id) {
        return R.ok(baseService.selectById(id));
    }

    /**
     * ??????????????????
     */
    @GetMapping("/getRouters/{moduleId}")
    public AjaxResult getRouters(@PathVariable Long moduleId) {
        LoginUser loginUser = tokenService.getLoginUser();
        Map<String, Object> menuMap = loginUser.getMenuRoute();
        if (ObjectUtil.isNull(menuMap.get(moduleId.toString()))) {
            List<SysMenuDto> menus = baseService.getRoutes(moduleId);
            menuMap.put(moduleId.toString(), baseService.buildMenus(TreeUtils.buildTree(menus)));
            tokenService.setLoginUser(loginUser);
        }
        return AjaxResult.success(menuMap.get(moduleId.toString()));
    }

    /**
     * ??????????????????
     */
    @Override
    @GetMapping("/list")
    @RequiresPermissions(Auth.SYS_MENU_LIST)
    public AjaxResult list(SysMenuQuery menu) {
        return super.list(menu);
    }

    /**
     * ????????????????????????????????????
     */
    @GetMapping("/list/exclude")
    @RequiresPermissions(Auth.SYS_MENU_LIST)
    public AjaxResult listExNodes(SysMenuQuery menu) {
        return super.listExNodes(menu);
    }

    /**
     * ??????????????????
     */
    @Override
    @GetMapping(value = "/{id}")
    @RequiresPermissions(Auth.SYS_MENU_SINGLE)
    public AjaxResult getInfoExtra(@PathVariable Serializable id) {
        return super.getInfoExtra(id);
    }

    /**
     * ??????????????????????????????????????????????????????
     */
    @PostMapping("/routeList")
    public AjaxResult getMenuByMenuType(@RequestBody SysMenuDto menu) {
        if (ObjectUtil.isNull(menu) || ObjectUtil.isNull(menu.getModuleId()) || ObjectUtil.isNull(menu.getMenuType()))
            throw new ServiceException("?????????????????????");
        List<SysMenuDto> menus = baseService.getMenuByMenuType(menu.getModuleId(), menu.getMenuType());
        return AjaxResult.success(TreeUtils.buildTree((menus)));
    }

    /**
     * ????????????????????????????????????????????????????????????????????????
     */
    @PostMapping("/routeList/exclude")
    public AjaxResult getMenuByMenuTypeExNodes(@RequestBody SysMenuDto menu) {
        if (ObjectUtil.isNull(menu) || ObjectUtil.isNull(menu.getModuleId()) || ObjectUtil.isNull(menu.getMenuType()))
            throw new ServiceException("?????????????????????");
        List<SysMenuDto> menus = baseService.getMenuByMenuType(menu.getModuleId(), menu.getMenuType());
        Iterator<SysMenuDto> it = menus.iterator();
        while (it.hasNext()) {
            SysMenuDto next = (SysMenuDto) it.next();
            if (ObjectUtil.equals(next.getId(), menu.getId()) ||
                    ArrayUtils.contains(StringUtils.split(next.getAncestors(), StrUtil.COMMA), menu.getId() + StrUtil.EMPTY))
                it.remove();
        }
        return AjaxResult.success(TreeUtils.buildTree((menus)));
    }

    /**
     * ????????????
     */
    @Override
    @PostMapping
    @RequiresPermissions(Auth.SYS_MENU_ADD)
    @Log(title = "????????????", businessType = BusinessType.INSERT)
    public AjaxResult add(@Validated({V_A.class}) @RequestBody SysMenuDto menu) {
        return super.add(menu);
    }

    /**
     * ????????????
     */
    @Override
    @PutMapping
    @RequiresPermissions(Auth.SYS_MENU_EDIT)
    @Log(title = "????????????", businessType = BusinessType.UPDATE)
    public AjaxResult edit(@Validated({V_E.class}) @RequestBody SysMenuDto menu) {
        return super.edit(menu);
    }

    /**
     * ??????????????????
     */
    @Override
    @PutMapping("/status")
    @RequiresPermissions(value = {Auth.SYS_MENU_EDIT, Auth.SYS_MENU_ES}, logical = Logical.OR)
    @Log(title = "????????????", businessType = BusinessType.UPDATE_STATUS)
    public AjaxResult editStatus(@RequestBody SysMenuDto menu) {
        return super.editStatus(menu);
    }

    /**
     * ??????????????????
     */
    @Override
    @DeleteMapping("/batch/{idList}")
    @RequiresPermissions(Auth.SYS_MENU_DEL)
    @Log(title = "????????????", businessType = BusinessType.DELETE)
    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
        return super.batchRemove(idList);
    }

    /**
     * ???????????????????????????
     */
    @Override
    @GetMapping("/option")
    public AjaxResult option() {
        return super.option();
    }

    /**
     * ???????????? ??????????????????/??????
     */
    @Override
    protected void AEHandleValidated(BaseConstants.Operate operate, SysMenuDto menu) {
        if (ObjectUtil.equals(menu.getId(), AuthorityConstants.MENU_TOP_NODE))
            throw new ServiceException(StrUtil.format("??????{}??????????????????", getNodeName()));
        if (baseService.checkNameUnique(menu.getId(), menu.getParentId(), menu.getName()))
            throw new ServiceException(StrUtil.format("{}{}{}?????????{}??????????????????", operate.getInfo(), getNodeName(), menu.getTitle(), getNodeName()));
        if (operate.isAdd() && SecurityUtils.isNotAdminTenant() && menu.isCommon())
            throw new ServiceException(StrUtil.format("{}{}{}???????????????????????????", operate.getInfo(), getNodeName(), menu.getTitle()));
        if (operate.isEdit()) {
            SysMenuDto original = baseService.selectById(menu.getId());
            if (ObjectUtil.isNull(original))
                throw new ServiceException("??????????????????");
            if (SecurityUtils.isNotAdminTenant() && original.isCommon())
                throw new ServiceException(StrUtil.format("{}{}{}???????????????????????????", operate.getInfo(), getNodeName(), menu.getTitle()));
            if (!StringUtils.equals(menu.getIsCommon(), original.getIsCommon()))
                throw new ServiceException(StrUtil.format("{}{}{}???????????????{}?????????????????????", operate.getInfo(), getNodeName(), menu.getTitle(), getNodeName()));
        }
        if (menu.isCommon()) {
            SysModuleDto module = moduleService.selectById(menu.getModuleId());
            if (ObjectUtil.isNull(module))
                throw new ServiceException("??????????????????");
            if (module.isNotCommon())
                throw new ServiceException(StrUtil.format("{}{}{}???????????????{}?????????????????????{}??????", operate.getInfo(), getNodeName(), menu.getTitle(), getNodeName(), getParentName()));
            SysMenuDto parentMenu = baseService.selectById(menu.getParentId());
            if (ObjectUtil.isNull(parentMenu))
                throw new ServiceException("??????????????????");
            if (parentMenu.isNotCommon())
                throw new ServiceException(StrUtil.format("{}{}{}???????????????{}?????????????????????{}??????", operate.getInfo(), getNodeName(), menu.getTitle(), getNodeName(), getNodeName()));
        }
    }

    /**
     * ???????????? ??????????????????
     * ??????????????????
     *
     * @param operate ????????????
     * @param idList  Id??????
     */
    @Override
    protected void RHandleValidated(BaseConstants.Operate operate, List<Long> idList) {
        // remove top node
        for (int i = idList.size() - 1; i >= 0; i--)
            if (ObjectUtil.equals(idList.get(i), AuthorityConstants.MENU_TOP_NODE))
                idList.remove(i);
        if (CollUtil.isEmpty(idList))
            throw new ServiceException(StrUtil.format("?????????????????????????????????{}???", getNodeName()));
    }
}
