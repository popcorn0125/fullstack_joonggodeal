<template>
  <div style="width: 100%; height: 100%; background-color: #fff;">
    <v-card class="mx-auto" color="surface-variant">
    <v-card-title> {{ member.id }} </v-card-title>

    <v-card-actions>
      <v-btn color="orange-lighten-2" text="상세정보"></v-btn>

      <v-spacer></v-spacer>

      <v-btn
        :icon="show ? 'mdi-chevron-up' : 'mdi-chevron-down'"
        @click="show = !show"
      ></v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text> 이름 : {{ member.name }}</v-card-text>
        <v-card-text> 닉네임 : {{ member.nickname }}</v-card-text>
        <v-card-text> 아이디 : {{ member.id }}</v-card-text>
        <v-card-text> 가입일 : {{ member.create_date }}</v-card-text>
      </div>
    </v-expand-transition>
    <template v-slot:actions>
      <v-btn color="red-lighten-2" text="로그아웃" block @click="logout()"></v-btn>
    </template>
  </v-card>
  </div>
  
</template>
<script>
import axios from 'axios';


export default {
  name: "myInfo",
  components: {
    
  },
  data() {
    return {
      show: false,
      member: {}

    }
  },
  methods: {
    // 로그아웃
    logout() {
      const vm = this;
      axios({
        method : 'post',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/memberLogin/logout",
      })
        .then((response) => {
          if(response.data) {
            sessionStorage.removeItem('USER_ID');
            sessionStorage.removeItem('JSESSIONID');
            vm.$router.push({name:"LoginPage"});
          } else {
            alert("데이터가 존재하지 않습니다.");
          }
        })
        .catch((error) =>  {
          console.log('error', error);
          alert("예기치 못한 오류가 발생하였으니 잠시후 다시 시도해주세요.");
        })
    },

    initialize() {
      axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/api/getUserInfo",
          data: {id: sessionStorage.getItem('USER_ID')}
      })
      .then((response) => {
        console.log(response.data)
          if(response.data != null) {
              this.member = response.data;
          }
      })
      .catch(function(){
          alert('오류가 발생하였습니다.')
      });
    }

  },

  created() {

  },
  mounted() {
    this.initialize()
  },
}
</script>

<style scoped>

</style>
