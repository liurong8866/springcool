package com.springcool.system.authority.controller;

import com.springcool.system.authority.domain.vo.SysAuthTree;
import com.springcool.system.authority.service.ISysAuthService;
import com.springcool.common.core.domain.R;
import com.springcool.common.core.utils.TreeUtils;
import com.springcool.common.core.web.result.AjaxResult;
import com.springcool.common.security.annotation.InnerAuth;
import com.springcool.common.security.annotation.Logical;
import com.springcool.common.security.annotation.RequiresPermissions;
import com.springcool.common.security.auth.Auth;
import com.springcool.common.web.entity.controller.BasisController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限管理 业务处理
 *
 * @author springcool
 */
@RestController
@RequestMapping("/auth")
public class SysAuthController extends BasisController {

    @Autowired
    private ISysAuthService authService;

    /**
     * 获取租户权限 | 叶子节点 | 内部调用
     */
    @InnerAuth
    @GetMapping("/inner/getTenantAuth")
    public R<Long[]> getTenantAuthInner() {
        List<SysAuthTree> leafNodes = TreeUtils.getLeafNodes(TreeUtils.buildTree(authService.selectTenantAuth()));
        return R.ok(leafNodes.stream().map(SysAuthTree::getId).toArray(Long[]::new));
    }

    /**
     * 新增租户权限 | 内部调用
     */
    @InnerAuth
    @PostMapping("/inner/addTenantAuth")
    public R<Boolean> addTenantAuthInner(@RequestBody Long[] authIds) {
        authService.addTenantAuth(authIds);
        return R.ok();
    }

    /**
     * 修改租户权限 | 内部调用
     */
    @InnerAuth
    @PostMapping("/inner/editTenantAuth")
    public R<Boolean> editTenantAuthInner(@RequestBody Long[] authIds) {
        authService.editTenantAuth(authIds);
        return R.ok();
    }

    /**
     * 获取公共模块|菜单权限树
     */
    @GetMapping(value = "/tenant/authScope")
    @RequiresPermissions(value = {Auth.TE_TENANT_ADD, Auth.TE_TENANT_AUTH}, logical = Logical.OR)
    public AjaxResult getCommonAuthScope() {
        return AjaxResult.success(TreeUtils.buildTree(authService.selectCommonAuthScope()));
    }

    /**
     * 获取企业模块|菜单权限树
     */
    @GetMapping(value = "/enterprise/authScope")
    @RequiresPermissions(value = {Auth.SYS_ROLE_ADD, Auth.SYS_ROLE_AUTH}, logical = Logical.OR)
    public AjaxResult getEnterpriseAuthScope() {
        return AjaxResult.success(TreeUtils.buildTree(authService.selectEnterpriseAuthScope()));
    }

}
