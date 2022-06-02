import { BasicFetchResult, BasicPageParams, BaseEntity } from '../../../src'

/** job info model */
export interface JobIM extends BaseEntity {
}

/** job list model */
export type JobLM = JobIM[]

/** job param model */
export type JobPM = JobIM

/** job page param model */
export type JobPPM = BasicPageParams & JobPM

/** job list result model */
export type JobLRM = BasicFetchResult<JobIM>
