<template>
  <v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
        <h1 class="font-weight-bold text-h2 text-basil">중고나라</h1>
    </v-card-title>

    <v-tabs v-model="tab" bg-color="transparent" color="basil" grow>
        <v-tab v-for="(item, index) in items" :key="index" :value="index" @click="this.$router.push({path: '/'})">
        {{ item }}
        </v-tab>
    </v-tabs>
    <!-- 컴포넌트 -->
    
    </v-card>
    <v-card
    :disabled="loading"
    :loading="loading"
    class="mx-auto my-12"
    max-width="70%"
  >
    <v-img
      height="250"
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
      cover
    ></v-img>

    <v-card-item>
      <v-card-title>제목</v-card-title>

      <v-card-subtitle>
        <span class="me-1">등록일 : </span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">카테고리 : </span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">가격 : </span>
      </v-card-subtitle>
    </v-card-item>

    <v-card-title>가격 제시</v-card-title>
    
    <div class="px-4 mb-2">
      <h5>Split</h5>

      <v-number-input control-variant="split" :step="5"></v-number-input>
    </div>

    <v-card-actions>
      <v-btn
        color="deep-purple-lighten-2"
        text="제출하기"
        block
        border
        @click="reserve"
      ></v-btn>
    </v-card-actions>

    <v-divider class="mx-4 mb-1"></v-divider>
    <v-card-title>제품 설명</v-card-title>
    <v-card-text>
      <div>
        Small plates, salads & sandwiches - an intimate setting with 12 indoor
        seats plus patio seating.
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
import { VNumberInput } from 'vuetify/labs/VNumberInput'
export default {
  name: "ProductDetail",
  components: {
    VNumberInput
  },
  data() {
    return {
        idx : 0,
        items: ['카테고리']
    }
  },
  methods: {
    

  },

  created() {

  },
  mounted() {
    this.idx = this.$route.id
  },
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
