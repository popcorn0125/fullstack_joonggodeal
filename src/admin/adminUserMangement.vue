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

                        <!-- 삭제 확인 다이얼로그 -->
                        <v-dialog v-model="dialogDelete" max-width="500px">
                          <v-card>
                            <v-card-title class="headline">회원 삭제</v-card-title>
                            <v-card-text>정말로 이 회원을 삭제하시겠습니까?</v-card-text>
                            <v-card-actions>
                              <v-btn color="primary" text @click="dialogDelete = false">취소</v-btn>
                              <v-btn color="red" text @click="deleteItem">삭제</v-btn>
                            </v-card-actions>
                          </v-card>
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
                    <v-icon size="small"  @click="confirmDelete(item)"> mdi-delete </v-icon>
                    </template>
                </v-data-table>
            </v-card>
        </v-main>
    </v-layout>
  </v-card>
</template>

<script>
import axios from 'axios';
export default {
  name: "Admin",
  components: {
  },
  data() {
    return {
      dialogDelete: false,
      deleteItemData: null,
      name: '',
      dialog: false,
      headers: [
        {
          title: '닉네임',
          align: 'start',
          sortable: false,
          key: 'nickname',
        },
        { title: '이름', key: 'name' },
        { title: '아이디', key: 'id' },
        // { title: '상점명', key: 'store' },
        { title: '가입일', key: 'create_date' },
        { title: '탈퇴여부', key: 'isdelete' },
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
     // 삭제 확인 다이얼로그 열기
     confirmDelete(item) {
      this.dialogDelete = true;
      this.deleteItemData = item; // 삭제할 항목을 저장
    },

    // 회원 삭제 요청
    deleteItem() {
      axios.post(`/adminpost/deleteuser`, { id: this.deleteItemData.idx })
        .then(response => {
          if (response.data) {
            this.desserts = this.desserts.filter(item => item.id !== this.deleteItemData.id);
            this.dialogDelete = false; // 다이얼로그 닫기
          } else {
            alert("삭제 실패");
          }
        })
        .catch(error => {
          console.error("삭제 요청 오류:", error);
        });
    },

    // 초기값
    initialize() {
      const vm = this;
      axios({
        method : 'post',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/adminpost/getusers",
      })
        .then((response) => {
          if(response.data) {
            vm.desserts = response.data;
            
          } else {
            alert("데이터가 존재하지 않습니다.");
          }
        })
        .catch((error) =>  {
          console.log('error', error);
          alert("예기치 못한 오류가 발생하였으니 잠시후 다시 시도해주세요.");
        })
        
      },

  },

  created() {
    
  },
  mounted() {
    if(sessionStorage.getItem('USER_ID') == null && sessionStorage.getItem('JSESSIONID') == null) {
      this.$router.push({name:'AdminLogin'});
      return
    }
    this.name = sessionStorage.getItem('USER_ID');
    this.initialize();
  },
}
</script>

<style scoped>

</style>
