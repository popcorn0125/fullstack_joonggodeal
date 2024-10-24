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
            <v-btn color="primary" block>Logout</v-btn>
          </div>
        </template>
      </v-navigation-drawer>

      <v-main style="height: 100%">
        <v-container>
          <!-- 제목 부분 -->
            <v-row>
              <v-col cols="12">
                <h1 class="text-h4 font-weight-bold">공지사항 목록</h1>
              </v-col>
            </v-row>

            <!-- 상품 등록 버튼 -->
            <v-row class="mb-4">
              <v-col cols="12" class="text-right">
                <v-btn color="primary" variant="outlined" @click="this.$router.push({ name: 'ProductRegistePage' })">
                  공지 작성
                </v-btn>
              </v-col>
            </v-row>
          <v-row>
            <v-col v-for="(notice, index) in notices" :key="index" cols="12" md="6">
              <v-card class="pa-3">
                <v-card-title>{{ notice.title }}</v-card-title>
                <v-card-subtitle>작성자: {{ notice.author }} | 등록일: {{ notice.date }}</v-card-subtitle>
                <v-card-text>{{ notice.content }}</v-card-text>
                <v-card-actions>
                  <v-btn color="primary" @click="editNotice(notice)">수정</v-btn>
                  <v-btn color="error" @click="deleteNotice(notice)">삭제</v-btn>
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

export default {
  name: "AdminNotice",
  components: {
    
  },
  data() {
    return {
      notices: [
        {
          title: '공지사항 1',
          author: '홍길동',
          content: '공지사항 내용 1',
          date: '2024-10-24',
        },
        {
          title: '공지사항 2',
          author: '김철수',
          content: '공지사항 내용 2',
          date: '2024-10-23',
        },
      ],

    }
  },
  methods: {
    editNotice(notice) {
      this.$router.push({ name: 'AdminNoticeUpdate', query: { id: 1 } });
    },
    deleteNotice(notice) {
      // 삭제 로직 추가
      console.log('Deleted:', notice);
    },

  },

  created() {

  },
  mounted() {
    
  },
}
</script>

<style scoped>

</style>
