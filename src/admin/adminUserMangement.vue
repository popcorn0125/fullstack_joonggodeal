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
            <!-- 회원 관리 테이블 -->
            <v-card style="width: 96%; margin: 20px; border-radius: 5px;"
                :color="color"
                :variant="variant"
                class="mx-auto"
            >
            
                <v-data-table 
                    :headers="headers"
                    :items="desserts"
                > 
                    <template v-slot:top >
                    <v-toolbar flat style="background-color: #1867c0; color:white">
                        <v-toolbar-title>회원 관리</v-toolbar-title>

                        <v-dialog v-model="dialogDelete" max-width="500px">
                        // 삭제 경고 alert 창
                        </v-dialog>
                        <v-text-field
        v-model="search"
        density="compact"
        label="Search"
        prepend-inner-icon="mdi-magnify"
        variant="solo-filled"
        flat
        hide-details
        single-line
        style="margin-right: 20px;"
      ></v-text-field>
                    
                    </v-toolbar>
                    
                    </template>
                    <template v-slot:item.delete="{ item }">
                    <v-icon size="small" @click=""> mdi-delete </v-icon>
                    </template>
                </v-data-table>
            </v-card>
        </v-main>
    </v-layout>
  </v-card>
</template>

<script>

export default {
  name: "Admin",
  components: {
  },
  data() {
    return {
      length: 3,
      onboarding: 0,
      dialog: false,
      dialogDelete: false,
      headers: [
        {
          title: '이메일',
          align: 'start',
          sortable: false,
          key: 'email',
        },
        { title: '이름', key: 'name' },
        { title: '아이디', key: 'id' },
        { title: '상점명', key: 'store' },
        { title: '가입일', key: 'createDate' },
        { title: '탈퇴여부', key: 'isDelete' },
        { title: '삭제', key: 'delete', sortable: false },
      ],
      desserts: [],
      editedIndex: -1,
      editedItem: {
        name: '',
        calories: 0,
        fat: 0,
        carbs: 0,
        protein: 0,
      },
      defaultItem: {
        name: '',
        calories: 0,
        fat: 0,
        carbs: 0,
        protein: 0,
      },

    }
  },
  methods: {
    initialize() {
        this.desserts = [
          {
            email: 'a12a25@gmail.com',
            name: '홍길동',
            id: 'hong123',
            store: 'hello',
            createDate: '2024-10-18',
            isDelete: 'N',
          },
          {
            email: 'a12a25@gmail.com',
            name: '홍길동',
            id: 'hong123',
            store: 'hello',
            createDate: '2024-10-18',
            isDelete: 'N',
          },
          {
            email: 'a12a25@gmail.com',
            name: '홍길동',
            id: 'hong123',
            store: 'hello',
            createDate: '2024-10-18',
            isDelete: 'N',
          },
          {
            email: 'a12a25@gmail.com',
            name: '홍길동',
            id: 'hong123',
            store: 'hello',
            createDate: '2024-10-18',
            isDelete: 'N',
          },
          {
            email: 'a12a25@gmail.com',
            name: '홍길동',
            id: 'hong123',
            store: 'hello',
            createDate: '2024-10-18',
            isDelete: 'N',
          },
        ]
      },

  },

  created() {
    this.initialize()
  },
  mounted() {
    
  },
}
</script>

<style scoped>

</style>
