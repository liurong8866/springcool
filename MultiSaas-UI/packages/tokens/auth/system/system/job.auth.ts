/** 定时任务调度权限标识 */
export enum JobAuth {
  // 查看定时任务调度列表
  LIST = 'system:job:list',
  // 查询定时任务调度详情
  SINGLE = 'system:job:single',
  // 新增定时任务调度
  ADD = 'system:job:add',
  // 修改定时任务调度
  EDIT = 'system:job:edit',
  // 删除定时任务调度
  DELETE = 'system:job:delete',
  // 定时任务调度导入
  IMPORT = 'system:job:import',
  // 定时任务调度导出
  EXPORT = 'system:job:export',
}
