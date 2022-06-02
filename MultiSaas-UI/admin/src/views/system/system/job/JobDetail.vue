<template>
  <PageWrapper :title="getTitle" @back="goBack">
    <Description @register="register" class="mt-4" />
  </PageWrapper>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue'
import { getJobApi } from '@service/system/system/job'
import { Description, useDescription } from '@/components/Description'
import { detailSchema } from './job.data'
import { useRoute } from 'vue-router'
import { JobIndexGo } from '@enums/system/system/job.enum'
import { useTabs } from '@/hooks/web/useTabs'
import { PageWrapper } from '@/components/Page'
import { useUserStore } from '@/store/user'
import { DescItemSizeEnum } from '@admin/tokens'

export default defineComponent({
  components: { Description, PageWrapper },
  setup() {
    const route = useRoute()
    const { setTitle } = useTabs()
    const getTitle = ref('定时任务调度详情')

    const [register, { setDescProps }] = useDescription({
      title: '定时任务调度详情',
      schema: detailSchema,
      column: DescItemSizeEnum.DEFAULT,
    })

    onMounted(async () => {
      const ${pkColumn.javaField} = route.params.${pkColumn.javaField} as any
      const data = await getJobApi(${pkColumn.javaField})
      setDescProps({ data: data })
      getTitle.value = '定时任务调度详情:' + data?.${pkColumn.javaField}
      setTitle(getTitle.value)
    })

    /** 返回定时任务调度主页 */
    function goBack() {
      useUserStore().getRoutePath(JobIndexGo)
    }

    return { register, getTitle, goBack }
  },
})
</script>
