<template>
  <div>
    <BasicTable @register="registerTable">
      <template #toolbar>
        <a-button
          :preIcon="IconEnum.ADD"
          v-auth="JobAuth.ADD"
          @click="handleCreate"
          type="primary"
        >
          新增
        </a-button>
        <a-button
          :preIcon="IconEnum.DELETE"
          v-auth="JobAuth.DELETE"
          @click="handleDelete"
          type="primary"
          color="error"
        >
          删除
        </a-button>
        <a-button
          :preIcon="IconEnum.EXPORT"
          v-auth="JobAuth.EXPORT"
          @click="handleExport"
          type="primary"
          color="warning"
        >
          导出
        </a-button>
      </template>
      <template #action="{ record }">
        <TableAction
          :actions="[
            {
              icon: IconEnum.VIEW,
              tooltip: '查看',
              auth: JobAuth.SINGLE,
              onClick: handleView.bind(null, record),
            },
            {
              icon: IconEnum.EDIT,
              tooltip: '编辑',
              auth: JobAuth.EDIT,
              onClick: handleEdit.bind(null, record),
            },
            {
              icon: IconEnum.DELETE,
              tooltip: '删除',
              auth: JobAuth.DELETE,
              color: 'error',
              onClick: handleDelete.bind(null, record),
            },
          ]"
        />
      </template>
    </BasicTable>
    <JobModal @register="registerModal" @success="handleSuccess" />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive } from 'vue'
import { listJobApi, delJobApi, exportJobApi } from '@service/system/system/job'
import { useModal } from '@/components/Modal'
import { useMessage } from '@/hooks/web/useMessage'
import { IconEnum } from '@admin/tokens'
import { BasicTable, TableAction, useTable } from '@/components/Table'
import { JobAuth } from '@auth/system/system/job.auth'
import { columns, searchFormSchema } from './job.data'
import { JobDetailGo } from '@enums/system/system/job.enum'
import JobModal from './JobModal.vue'
import { useUserStore } from '@/store/user'
import { JobPM } from '@type/system/system/job'

export default defineComponent({
  name: 'JobManagement',
  components: { BasicTable, JobModal, TableAction },
  setup() {
    const { createMessage, createConfirm } = useMessage()
    const [registerModal, { openModal }] = useModal()
    const state = reactive<{
      ${pkColumn.javaField}s: (string | number)[]
      ${pkColumn.javaField}Names: string
    }>({
      ${pkColumn.javaField}s: [],
      ${pkColumn.javaField}Names: '',
    })
    const [registerTable, { reload, getForm }] = useTable({
      title: '定时任务调度列表',
      api: listJobApi,
      striped: false,
      useSearchForm: true,
      rowKey: '${pkColumn.javaField}',
      bordered: true,
      showIndexColumn: true,
      columns,
      formConfig: {
        labelWidth: 120,
        schemas: searchFormSchema,
      },
      showTableSetting: true,
      tableSetting: {
        fullScreen: true,
      },
      actionColumn: {
        width: 220,
        title: '操作',
        dataIndex: 'action',
        slots: { customRender: 'action' },
      },
      rowSelection: {
        onChange: (selectedRowKeys, selectRows) => {
          state.${pkColumn.javaField}s = selectedRowKeys
          state.${pkColumn.javaField}Names = selectRows
            .map((item) => {
              return item.${pkColumn.javaField}
            })
            .join(',')
        },
      },
    })

    /** 查看按钮 */
    function handleView(record: Recordable) {
      useUserStore().getRoutePath(JobDetailGo, record.${pkColumn.javaField})
    }

    /** 新增按钮 */
    function handleCreate() {
      openModal(true, {
        isUpdate: false,
      })
    }

    /** 修改按钮 */
    function handleEdit(record: Recordable) {
      openModal(true, {
        record,
        isUpdate: true,
      })
    }

    /** 删除按钮 */
    function handleDelete(record: Recordable) {
      const delIds = record.${pkColumn.javaField} || state.${pkColumn.javaField}s
      const delNames = record.${pkColumn.javaField} || state.${pkColumn.javaField}Names
      if (!record.${pkColumn.javaField} && state.${pkColumn.javaField}s.length === 0) {
        createMessage.warning('请选择要操作的数据！')
      } else {
        createConfirm({
          iconType: 'warning',
          title: '提示',
          content: '是否确定要删除' + delNames + '?',
          onOk: () =>
            delJobApi(delIds).then(() => {
              createMessage.success('删除' + delNames + '成功！')
              reload()
            }),
        })
      }
    }

    /** 导出按钮 */
    function handleExport() {
      const value = getForm().getFieldsValue() as JobPM
      exportJobApi(value)
    }

    function handleSuccess() {
      reload()
    }

    return {
      IconEnum,
      JobAuth,
      registerTable,
      registerModal,
      handleView,
      handleCreate,
      handleEdit,
      handleDelete,
      handleExport,
      handleSuccess,
    }
  },
})
</script>
