<template>
  <v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
      <h1 class="font-weight-bold text-h2 text-basil">중고나라</h1>
    </v-card-title>

    <v-tabs v-model="tab" bg-color="transparent" color="basil" grow>
      <v-tab v-for="(item, index) in items" :key="index" :value="index">
        {{ item }}
      </v-tab>
    </v-tabs>
    <!-- 컴포넌트 -->
    <component :is="currentTabComponent"></component>
  </v-card>
</template>

<script>
import categoryPage from '@/components/categoryPage.vue';
import auctionHistory from '@/components/auctionHistory.vue';
import notice from '@/components/notice.vue';
import myInfo from '@/components/myInfo.vue';
export default {
  name: "Main",
  components: {
    categoryPage,
    auctionHistory,
    notice,
    myInfo,
  },
  data() {
    return {
      tab: 0,
      items: ['카테고리', '경매 진행 내역', '공지사항', '내 정보'],
      
    }
  },
  methods: {
    

  },

  created() {

  },
  mounted() {
    
  },
  computed: {
    currentTabComponent() {
      switch(this.tab){
        case 0:
          return 'categoryPage';
        case 1:
          return 'auctionHistory';
        case 2:
          return 'notice';
        case 3:
          return 'myInfo';
      }
    }
  }
}
</script>

<style scoped>
  /* Helper classes */
  .bg-basil {
    background-color: #fffbe6 !important;
  }
  .text-basil {
    color: #356859 !important;
  }
</style>
