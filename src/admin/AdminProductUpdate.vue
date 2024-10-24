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
                subtitle="Logged in"
                title="Jane Smith"
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
                        @click="submitForm"
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

export default {
  name: "AdminProductUpdate",
  components: {
    
  },
  data() {
    return {
      valid: false,
      product: {
        name: '',
        title: '',
        manufacturer: '',
        price: null,
        description: '',
      },
      rules: {
        required: (value) => !!value || '필수 입력 항목입니다.',
        numeric: (value) => !isNaN(value) || '숫자를 입력해주세요.',
      },

    }
  },
  methods: {
    submitForm() {
      if (this.$refs.form.validate()) {
        // 폼 유효성 검증 성공 시 처리 로직
        console.log('폼 데이터:', this.product);
        alert('상품이 성공적으로 등록되었습니다.');
      } else {
        console.log('폼 유효성 검증 실패');
      }
    },

  },

  created() {

  },
  mounted() {
    
  },
}
</script>

<style scoped>
.v-text-field,
.v-textarea {
  margin-bottom: 20px;
}
</style>
