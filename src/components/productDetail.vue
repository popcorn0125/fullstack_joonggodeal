<template>
  <v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
        <h1 class="font-weight-bold text-h2 text-basil">중고딜</h1>
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
      :src="`http://localhost:8080/images/${product.filename}`"
      cover
    ></v-img>

    <v-card-item>
      <v-card-title>{{ product.title }}</v-card-title>
      <v-card-subtitle>
        <span class="me-1">이름 : {{ product.name }}</span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">제조사 : {{ product.company }}</span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">등록일 : {{ product.create_date }}</span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">카테고리 : {{ product.category_name }}</span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">시작가격 : {{ product.startprice }}</span>
      </v-card-subtitle>
      <v-card-subtitle>
        <span class="me-1">현재 경매 가격 : {{ product.currentprice == 0 ? "아직 제시 가격 없음": product.currentprice }}</span>
      </v-card-subtitle>
    </v-card-item>

    <v-card-title>가격 제시</v-card-title>
    
    <div class="px-4 mb-2">
      <h5>Split</h5>

      <v-number-input control-variant="split" :step="5" v-model="submitPrice"></v-number-input>
    </div>

    <v-card-actions>
      <v-btn
        color="deep-purple-lighten-2"
        text="제출하기"
        block
        border
        @click="submitPriceBtn()"
      ></v-btn>
    </v-card-actions>

    <v-divider class="mx-4 mb-1"></v-divider>
    <v-card-title>제품 설명</v-card-title>
    <v-card-text>
      <div>
        {{ product.description }}
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
import axios from 'axios';
import { VNumberInput } from 'vuetify/labs/VNumberInput'
export default {
  name: "ProductDetail",
  components: {
    VNumberInput
  },
  data() {
    return {
      submitPrice: 0,
        idx : 0,
        items: ['카테고리'],
        product: {}
    }
  },
  methods: {
    submitPriceBtn() {
      const vm = this;
      if (vm.submitPrice < vm.product.startprice || vm.submitPrice < vm.product.currentprice) {
        alert('제시한 가격이 시작가 또는 현재가 보다 낮게 작성하셨습니다. 다시 제시해주세요.');
        return
      }

      const postData = {
        goods_idx: parseInt(vm.idx),
        bid_price: vm.submitPrice,
        id: sessionStorage.getItem('USER_ID')
      }
      axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/productcategory/submitprice",
          data: postData
      })
      .then((response) => {
        console.log(response.data)
          if(response.data > 0) {
              alert('제시한 가격을 전달하였습니다.');
              history.go(0);

          }
      })
      .catch(function(){
          alert("에러가 발생하였습니다.")
      });

    },
    setting() {
      const vm = this;
      console.log(vm.idx)
      axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/productcategory/getonegoods",
          data: {idx: parseInt(vm.idx)}
      })
      .then((response) => {
        console.log(response.data)
          if(response.data != null) {
              vm.product = response.data;
          }
      })
      .catch(function(){
          alert("에러가 발생하였습니다.")
      });
    },

  },

  created() {

  },
  mounted() {
    this.idx = this.$route.query.id
    this.setting();
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
