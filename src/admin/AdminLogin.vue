<template>
<v-container>
      <v-row align="center" justify="center" >
          <v-col cols="12" sm="10">
            <v-card class="elevation-6 mt-10"  >
             <v-window v-model="step">
                <v-window-item :value="1">
                  <v-row>
                    <v-col cols="12" md="6">
                      <v-card-text class="mt-12">
                        <h1
                          class="text-center"
                        >관리자 로그인</h1>
                      
                        <v-row align="center" justify="center">
                          <v-col cols="12" sm="8">
                           
                          <v-text-field
                            label="ID"
                            outlined
                            dense
                            color="blue"
                            autocomplete="false"
                           class="mt-16"
                          />
                          <v-text-field
                            label="Password"
                            outlined
                            dense
                            color="blue"
                          autocomplete="false"
                           type="password"
                          
                          />
                            <v-row>
                              <v-col cols="12" sm="5">
                                <span class="caption blue--text" style="font-size: 0.7rem;">비밀번호 재설정</span>
                              </v-col>
                            </v-row>
                            <v-row>
                              <v-col cols="12" sm="5">
                                
                              </v-col>
                            </v-row>
                          <v-btn color="blue" dark block tile>Log in</v-btn>
                     
                         <h5
                          class="text-center  grey--text mt-4 mb-3"
                        >Or </h5>
                        <div class="text-center">
                          <v-btn tile outlined dark @click="">SIGN UP</v-btn>
                        </div>
                          </v-col>
                        </v-row>  
                      </v-card-text>
                    </v-col>
                    
                  </v-row>
                </v-window-item>
                
              </v-window>
            </v-card>
          </v-col>
      </v-row>
  </v-container>
    
</template>

<script>

export default {
  name: "AdminLogin",
  components: {
  },
  props: {
    source: String
  },

  data() {
    return {
      step: 1

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
.v-application .rounded-bl-xl {
    border-bottom-left-radius: 300px !important;
}
.v-application .rounded-br-xl {
    border-bottom-right-radius: 300px !important;
}
</style>
