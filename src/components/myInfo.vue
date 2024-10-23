<template>
  <div style="width: 100%; height: 100%; background-color: #fff;">
    <v-card class="mx-auto" color="surface-variant">
    <v-card-title> 닉네임 </v-card-title>

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

        <v-card-text> 이름 : </v-card-text>
        <v-card-text> 닉네임 : </v-card-text>
        <v-card-text> 아이디 : </v-card-text>
        <v-card-text> 가입일 : </v-card-text>
      </div>
    </v-expand-transition>
    <template v-slot:actions>
      <v-btn color="red-lighten-2" text="로그아웃" block></v-btn>
    </template>
  </v-card>
  </div>
  
</template>
<script>

export default {
  name: "myInfo",
  components: {
    
  },
  data() {
    return {
      show: false,

    }
  },
  methods: {
    

  },

  created() {

  },
  mounted() {
    
  },
}
</script>

<style scoped>

</style>
