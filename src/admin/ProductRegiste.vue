<template>
  <v-card >
    <v-layout>
        <v-navigation-drawer
        location="left"
        permanent
        >
            <template v-slot:prepend>
                <v-list-item
                lines="three"
                prepend-avatar="https://randomuser.me/api/portraits/women/81.jpg"
                subtitle="환영합니다"
                :title="`${name}님`"
                ></v-list-item>
            </template>

            <v-divider></v-divider>

            <v-list density="compact" nav>
                <v-list-item prepend-icon="mdi-home-city" title="Home" @click="this.$router.push({ name:'AdminUsers' })"></v-list-item>
          <v-list-item prepend-icon="mdi-account" title="상품 등록" @click="this.$router.push({ name:'ProductRegiste' })"></v-list-item>
          <v-list-item prepend-icon="mdi-account-group-outline" title="공지사항 관리" @click="this.$router.push({name:'AdminNotice'})"></v-list-item>
            </v-list>
            <template v-slot:append>
                <div class="pa-2">
                    <v-btn color="primary" block>
                        Logout
                    </v-btn>
                </div>
            </template>
        </v-navigation-drawer>
        <v-main style="height: 100%" >
          <v-container>
            <!-- 제목 부분 -->
            <v-row>
              <v-col cols="12">
                <h1 class="text-h4 font-weight-bold">상품 조회</h1>
              </v-col>
            </v-row>

            <!-- 상품 등록 버튼 -->
            <v-row class="mb-4">
              <v-col cols="12" class="text-right">
                <v-btn color="primary" variant="outlined" @click="this.$router.push({ name: 'ProductRegistePage' })">
                  상품등록
                </v-btn>
              </v-col>
            </v-row>

            <v-row>
              
              
              <!-- 상품 목록 반복 -->
              <v-col
                v-for="(product, index) in products"
                :key="index"
                cols="12"
                md="6"
              >
                <v-card class="pa-3">
                  <v-card-title>{{ product.title }}</v-card-title>
                  <v-card-subtitle>
                    {{ product.name }}
                  </v-card-subtitle>

                  <v-card-subtitle>
                    {{ product.category }}
                  </v-card-subtitle>
                  <v-card-subtitle>
                    제조사 : {{ product.company }}
                  </v-card-subtitle>
                  <v-card-subtitle>
                    시작가 : {{ product.start_price }} 원
                  </v-card-subtitle>
                  <v-card-subtitle>
                    경매기 : {{ product.bid_price }} 원
                  </v-card-subtitle>
                  <v-card-subtitle>
                    구매자 : {{ product.id }} 님
                  </v-card-subtitle>

                  <v-card-actions>
                    <v-btn color="primary" @click="this.$router.push({name: 'AdminProductUpdate', query: {id:1}})">수정</v-btn>
                    <v-btn color="error">삭제</v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </v-main>
    </v-layout>
  </v-card>
</template>

<script>
import axios from 'axios';
export default {
  name: "ProductRegiste",
  components: {
    
  },
  data() {
    return {
      name: sessionStorage.getItem('USER_ID'),
      products: [],

    }
  },
  methods: {
    initialize() {
      const vm = this;
      axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/adminproduct/getproductlist",
          data: {id:sessionStorage.getItem('USER_ID')}
        })
          .then((response) => {
            if(response.data ) {
              vm.products = response.data;
              
            } else {
              alert("데이터가 존재하지 않습니다.");
            }
          })
          .catch((error) =>  {
            console.log('error', error);
            alert("예기치 못한 오류가 발생하였으니 잠시후 다시 시도해주세요.");
          })
    }

  },

  created() {

  },
  mounted() {
    this.initialize();
  },
}
</script>

<style scoped>
.v-card {
  border: 1px solid #ccc;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}
</style>
