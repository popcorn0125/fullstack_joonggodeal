<template>
<div class="form">
       <p class="form-title">관리자</p>
        <div class="input-container">
          <input type="email" placeholder="Enter ID" v-model="user.id">
          <span>
          </span>
      </div>
      <div class="input-container">
          <input type="password" placeholder="Enter Password" v-model="user.pw">
        </div>
         <button type="submit" class="submit" @click="login()">
        로그인
      </button>

      <p class="signup-link">
        No account?
        <a href="/admin/signup">관리자 등록</a>
      </p>
    </div>
    
</template>

<script>
import axios from 'axios';
export default {
  name: "AdminLogin",
  components: {
  },
  props: {
    source: String
  },

  data() {
    return {
      step: 1,
      user: {
        id: '',
        pw: ''
      }
    }
  },
  methods: {
    login() {
      const vm = this;
      if(vm.user.id == '' || vm.user.id.trim() == null || vm.user.id.trim() == '') {
        alert("아이디를 입력해주세요");
        return ;
      }
      if(vm.user.pw == '' || vm.user.pw.trim() == null || vm.user.pw.trim() == '') {
        alert("비밀번호를 입력해주세요");
        return ;
      }
      console.log('로그인 버튼 누르기 전')
      axios({
        method : 'post',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/adminlogin/verify",
        data: vm.user,
      })
        .then((response) => {
          if(response.data.result > 0) {
            sessionStorage.setItem("USER_ID", response.data.USER_ID);
            sessionStorage.setItem("JSESSIONID", response.data.JSESSIONID);
            alert("로그인을 성공하였습니다.");
            vm.$router.push({name: 'AdminUsers'});
          } else {
            alert(`'${response.data.message}'`);
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
    
  },
}
</script>

<style scoped>
.form {
  margin: auto;
  background-color: #fff;
  display: block;
  padding: 1rem;
  max-width: 350px;
  border-radius: 0.5rem;
  box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
}

.form-title {
  font-size: 1.25rem;
  line-height: 1.75rem;
  font-weight: 600;
  text-align: center;
  color: #000;
}

.input-container {
  position: relative;
}

.input-container input, .form button {
  outline: none;
  border: 1px solid #e5e7eb;
  margin: 8px 0;
}

.input-container input {
  background-color: #fff;
  padding: 1rem;
  padding-right: 3rem;
  font-size: 0.875rem;
  line-height: 1.25rem;
  width: 300px;
  border-radius: 0.5rem;
  box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
}

.submit {
  display: block;
  padding-top: 0.75rem;
  padding-bottom: 0.75rem;
  padding-left: 1.25rem;
  padding-right: 1.25rem;
  background-color: #4F46E5;
  color: #ffffff;
  font-size: 0.875rem;
  line-height: 1.25rem;
  font-weight: 500;
  width: 100%;
  border-radius: 0.5rem;
  text-transform: uppercase;
}

.signup-link {
  color: #6B7280;
  font-size: 0.875rem;
  line-height: 1.25rem;
  text-align: center;
}

.signup-link a {
  text-decoration: underline;
}
</style>
