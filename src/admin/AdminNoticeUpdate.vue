<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer location="left" permanent>
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
            <v-btn color="primary" block @click="logout()">Logout</v-btn>
          </div>
        </template>
      </v-navigation-drawer>

      <v-main style="height: 100%">
        <v-container>
          <h1>공지사항 수정</h1>
          <v-form ref="form" v-model="valid">
            <!-- 작성자 -->
            <v-text-field
              label="작성자"
              v-model="notice.author"
              :rules="[rules.required]"
              required
            ></v-text-field>

            <!-- 제목 -->
            <v-text-field
              label="제목"
              v-model="notice.title"
              :rules="[rules.required]"
              required
            ></v-text-field>

            <!-- 내용 -->
            <v-textarea
              label="내용"
              v-model="notice.content"
              :rules="[rules.required]"
              required
            ></v-textarea>

            <v-row>
              <!-- 수정 버튼 -->
              <v-btn
                color="primary"
                class="mt-4"
                @click="updateNotice"
              >
                수정하기
              </v-btn>

              <v-btn
                color="red"
                class="mt-4"
                @click="cancel"
                style="margin-left: 10px;"
              >
                취소하기
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
  name: "AdminNoticeUpdate",
  components: {
    
  },
  data() {
    return {
      valid: false,
      notice: {
        author: '운영자', // 수정할 공지사항의 현재 작성자
        title: '수정 제목',
        content: '수정 내용',
      },
      rules: {
        required: (value) => !!value || '필수 입력 항목입니다.',
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
    updateNotice() {
      if (this.$refs.form.validate()) {
        // 수정 로직 처리
        console.log('Notice Updated:', this.notice);
        this.$router.push({ name: 'NoticeList' }); // 목록 페이지로 이동
      }
    },
    cancel() {
      this.$router.push({ name: 'NoticeList' }); // 목록 페이지로 이동
    },

  },

  created() {

  },
  mounted() {
    if(sessionStorage.getItem('USER_ID') == null && sessionStorage.getItem('JSESSIONID') == null) {
      this.$router.push({name:'AdminLogin'});
      return
    }
  },
}
</script>

<style scoped>

</style>
