import { JobIM, JobPM, JobPPM, JobLRM } from '@admin/types/modules/system/system/job'
import { defaultRequest } from '../../../request'
import { formatToDateTime } from '@admin/utils'

enum Api {
  LIST_JOB = '/system/job/list',
  OPTION_JOB = '/system/job/option',
  GET_JOB = '/system/job/',
  ADD_JOB = '/system/job',
  EDIT_JOB = '/system/job',
  DEL_BATCH_JOB = '/system/job/batch/',
  DEL_BATCH_FORCE_JOB = '/system/job/batch/force/',
  EXPORT_JOB = '/system/job/export',
}

/** 查询定时任务调度列表 */
export const listJobApi = (params?: JobPPM) =>
  defaultRequest.get<JobLRM>({ url: Api.LIST_JOB, params })

/** 查询定时任务调度选择框列表 */
export const optionJobApi = () =>
  defaultRequest.get<JobLRM>({ url: Api.OPTION_JOB })

/** 查询定时任务调度详细 */
export const getJobApi = (${IdName}: any) =>
  defaultRequest.get<JobIM>({ url: Api.GET_JOB, params: ${IdName} })

/** 新增定时任务调度 */
export const addJobApi = (params: JobIM) =>
  defaultRequest.post({ url: Api.ADD_JOB, params })

/** 修改定时任务调度 */
export const editJobApi = (params: JobIM) =>
  defaultRequest.put({ url: Api.EDIT_JOB, params })

/** 删除定时任务调度 */
export const delJobApi = (${IdName}s: any | any[]) =>
  defaultRequest.delete({ url: Api.DEL_BATCH_JOB, params: ${IdName}s.toString() })

/** 导出定时任务调度 */
export const exportJobApi = async (params?: JobPM) =>
  defaultRequest.export<any>(
    { url: Api.EXPORT_JOB, params: params },
    '定时任务调度_' + formatToDateTime(new Date()) + '.xlsx',
  )
