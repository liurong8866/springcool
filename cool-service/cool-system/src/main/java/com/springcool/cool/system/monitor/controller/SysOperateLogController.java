package com.springcool.cool.system.monitor.controller;

import com.springcool.cool.common.core.domain.R;
import com.springcool.cool.common.core.web.result.AjaxResult;
import com.springcool.cool.common.log.annotation.Log;
import com.springcool.cool.common.log.enums.BusinessType;
import com.springcool.cool.common.security.annotation.InnerAuth;
import com.springcool.cool.common.security.annotation.RequiresPermissions;
import com.springcool.cool.common.security.auth.Auth;
import com.springcool.cool.common.web.entity.controller.BaseController;
import com.springcool.cool.system.api.log.domain.dto.SysOperateLogDto;
import com.springcool.cool.system.api.log.domain.query.SysOperateLogQuery;
import com.springcool.cool.system.monitor.service.ISysOperateLogService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 操作日志管理 业务处理
 *
 * @author springcool
 */
@RestController
@RequestMapping("/operateLog")
public class SysOperateLogController extends BaseController<SysOperateLogQuery, SysOperateLogDto, ISysOperateLogService> {

    /** 定义节点名称 */
    @Override
    protected String getNodeName() {
        return "操作日志";
    }

    /**
     * 新增操作日志 | 内部调用
     */
    @InnerAuth
    @PostMapping
    public R<Boolean> addInner(@RequestBody SysOperateLogDto operateLog) {
        baseService.insert(operateLog);
        return R.ok();
    }

    /**
     * 查询操作日志列表
     */
    @Override
    @GetMapping("/list")
    @RequiresPermissions(Auth.SYS_OPERATE_LOG_LIST)
    public AjaxResult list(SysOperateLogQuery operateLog) {
        return super.list(operateLog);
    }

    /**
     * 查询操作日志详细
     */
    @Override
    @GetMapping(value = "/{id}")
    @RequiresPermissions(Auth.SYS_OPERATE_LOG_SINGLE)
    public AjaxResult getInfoExtra(@PathVariable Serializable id) {
        return super.getInfoExtra(id);
    }

    /**
     * 操作日志导出
     */
    @Override
    @PostMapping("/export")
    @RequiresPermissions(Auth.SYS_OPERATE_LOG_EXPORT)
    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    public void export(HttpServletResponse response, SysOperateLogQuery operateLog) {
        super.export(response, operateLog);
    }


    @DeleteMapping("/clean")
    @RequiresPermissions(Auth.SYS_OPERATE_LOG_DEL)
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    public AjaxResult clean() {
        baseService.cleanOperateLog();
        return AjaxResult.success();
    }
}
