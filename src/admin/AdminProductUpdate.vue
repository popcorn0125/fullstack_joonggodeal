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
                    <v-btn color="primary" block @click="logout()">
                        Logout
                    </v-btn>
                </div>
            </template>
        </v-navigation-drawer>
        <v-main style="height: 100%" >
          <v-container>
            <h1>상품 수정</h1>
            <v-form ref="form" v-model="valid">
            <!-- 물품 이름 -->
            <v-text-field
                label="물품 이름"
                v-model="product.name"
                :rules="[rules.required]"
                required
            ></v-text-field>

            <!-- 제목 -->
            <v-text-field
                label="제목"
                v-model="product.title"
                :rules="[rules.required]"
                required
            ></v-text-field>

            <!-- 제조사 -->
            <v-text-field
                label="제조사"
                v-model="product.manufacturer"
                :rules="[rules.required]"
                required
            ></v-text-field>

            <!-- 등록할 가격 -->
            <v-text-field
                label="등록할 가격"
                v-model="product.price"
                :rules="[rules.required, rules.numeric]"
                required
                type="number"
            ></v-text-field>

            <!-- 설명 -->
            <v-textarea
                label="설명"
                v-model="product.description"
                :rules="[rules.required]"
                required
            ></v-textarea>

            <!-- 사진 업로드 -->
            <v-file-input
                label="사진 업로드"
                v-model="product.image"
                :rules="[rules.required]"
                required
                accept="image/*"
                prepend-icon="mdi-camera"
            ></v-file-input>
            <v-row>

                <!-- 등록 버튼 -->
                <v-btn
                style="margin-right: 10px;"
                        color="red"
                        class="mt-4"
                        @click="this.$router.push({name:'ProductRegiste'})"
                        >
                        취소하기
                    </v-btn>
                    
                    <!-- 등록 버튼 -->
                    <v-btn
                    color="primary"
                    class="mt-4"
                    @click="submitForm"
                    >
                    수정하기
                </v-btn>
            </v-row>
            </v-form>
        </v-container>
        </v-main>
    </v-layout>
  </v-card>

</template>

<script>
import axios from 'axios';

export default {
  name: "AdminProductUpdate",
  components: {
    
  },
  data() {
    return {
      name: sessionStorage.getItem('USER_ID'),
      valid: false,
      product: {
        name: '',
        title: '',
        manufacturer: '',
        price: null,
        description: '',
        category: '',
        idx: '',
        image: ''
      },
      rules: {
        required: (value) => !!value || '필수 입력 항목입니다.',
        numeric: (value) => !isNaN(value) || '숫자를 입력해주세요.',
      },

    }
  },
  methods: {
    // 로그아웃
    logout() {
      const vm = this;
      axios({
        method : 'post',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/adminlogin/logout",
      })
        .then((response) => {
          if(response.data) {
            sessionStorage.removeItem('USER_ID');
            sessionStorage.removeItem('JSESSIONID');
            vm.$router.push({name:"AdminLogin"});
          } else {
            alert("데이터가 존재하지 않습니다.");
          }
        })
        .catch((error) =>  {
          console.log('error', error);
          alert("예기치 못한 오류가 발생하였으니 잠시후 다시 시도해주세요.");
        })
    },
    submitForm() {
      if (this.$refs.form.validate()) {
        
        // 폼 유효성 검증 성공 시 처리 로직
        const formData = new FormData();
        
        // product의 속성들을 FormData에 추가
        formData.append('name', this.product.name);
        formData.append('title', this.product.title);
        formData.append('manufacturer', this.product.manufacturer);
        formData.append('price', this.product.price);
        formData.append('description', this.product.description);
        formData.append('category', this.product.category);
        formData.append('idx', this.product.idx)
        
        // 이미지 파일 추가
        formData.append('image', this.product.image);
        axios({
          method : 'post',
          header: { 'Content-Type': 'multipart/form-data' },
          url: "/adminproduct/update",
          data: formData
        })
          .then((response) => {
            if(response.data > 0) {
              alert("상품이 성공적으로 수정되었습니다.")
              this.$router.push({name: 'ProductRegiste'})
              
            } else {
              alert("다시 작성해주세요");
            }
          })
          .catch((error) =>  {
            console.log('error', error);
            alert("예기치 못한 오류가 발생하였으니 잠시후 다시 시도해주세요.");
          })
      } else {
        console.log('폼 유효성 검증 실패');
      }
    },

    initialize() {
      axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/adminproduct/getonegoods",
          data: {idx:this.product.idx}
        })
          .then((response) => {
            if(response.data ) {
              this.product = response.data;
              console.log(this.product)
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
    if(sessionStorage.getItem('USER_ID') == null && sessionStorage.getItem('JSESSIONID') == null) {
      this.$router.push({name:'AdminLogin'});
      return
    }
    this.product.idx = parseInt(this.$route.query.id);
    this.initialize();
  },
}
</script>

<style scoped>
.v-text-field,
.v-textarea {
  margin-bottom: 20px;
}
</style>
