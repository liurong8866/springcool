package com.springcool.cool.system.controller;

import com.springcool.cool.system.domain.query.SysJobQuery;
import com.springcool.cool.system.domain.dto.SysJobDto;
import com.springcool.cool.system.service.ISysJobService;
import com.springcool.common.web.entity.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import RequiresPermissions;
import V_A;
import V_E;
import AjaxResult;
import Log;
import BusinessType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 定时任务调度管理 业务处理
 *
 * @author springcool
 */
@RestController
@RequestMapping("/job")
public class SysJobController extends BaseController<SysJobQuery, SysJobDto, ISysJobService> {

    /** 定义节点名称 */
    @Override
    protected String getNodeName() {
        return "定时任务调度" ;
    }

    /**
     * 查询定时任务调度列表
     */
    @Override
    @GetMapping("/list")
    @RequiresPermissions(Auth.SYS_JOB_LIST)
    public AjaxResult list(SysJobQuery job) {
        return super.list(job);
    }

    /**
     * 查询定时任务调度详细
     */
    @Override
    @GetMapping(value = "/{id}")
    @RequiresPermissions(Auth.SYS_JOB_SINGLE)
    public AjaxResult getInfoExtra(@PathVariable Serializable id) {
        return super.getInfoExtra(id);
    }

    /**
     * 定时任务调度导出
     */
    @Override
    @PostMapping("/export")
    @RequiresPermissions(Auth.SYS_JOB_EXPORT)
    @Log(title = "定时任务调度管理", businessType = BusinessType.EXPORT)
    public void export(HttpServletResponse response, SysJobQuery job) {
        super.export(response, job);
    }

    /**
     * 定时任务调度新增
     */
    @Override
    @PostMapping
    @RequiresPermissions(Auth.SYS_JOB_ADD)
    @Log(title = "定时任务调度管理", businessType = BusinessType.INSERT)
    public AjaxResult add(@Validated({V_A.class}) @RequestBody SysJobDto job) {
        return super.add(job);
    }

    /**
     * 定时任务调度修改
     */
    @Override
    @PutMapping
    @RequiresPermissions(Auth.SYS_JOB_EDIT)
    @Log(title = "定时任务调度管理", businessType = BusinessType.UPDATE)
    public AjaxResult edit(@Validated({V_E.class}) @RequestBody SysJobDto job) {
        return super.edit(job);
    }

    /**
     * 定时任务调度批量删除
     */
    @Override
    @DeleteMapping("/batch/{idList}")
    @RequiresPermissions(Auth.SYS_JOB_DEL)
    @Log(title = "定时任务调度管理", businessType = BusinessType.DELETE)
    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
        return super.batchRemove(idList);
    }

    /**
     * 获取定时任务调度选择框列表
     */
    @Override
    @GetMapping("/option")
    public AjaxResult option() {
        return super.option();
    }

    interface Auth {
        /** 系统 - 定时任务调度管理 - 列表 */
        String SYS_JOB_LIST = "system:job:list" ;
        /** 系统 - 定时任务调度管理 - 详情 */
        String SYS_JOB_SINGLE = "system:job:single" ;
        /** 系统 - 定时任务调度管理 - 新增 */
        String SYS_JOB_ADD = "system:job:add" ;
        /** 系统 - 定时任务调度管理 - 修改 */
        String SYS_JOB_EDIT = "system:job:edit" ;
        /** 系统 - 定时任务调度管理 - 删除 */
        String SYS_JOB_DEL = "system:job:delete" ;
        /** 系统 - 定时任务调度管理 - 导出 */
        String SYS_JOB_EXPORT = "system:job:export" ;
    }
}
