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
                <v-list-item prepend-icon="mdi-home-city" title="Home"  @click="this.$router.push({name:'AdminUsers'})"></v-list-item>
                <v-list-item prepend-icon="mdi-account" title="상품 등록"  @click="this.$router.push({name:'ProductRegiste'})"></v-list-item>
                <v-list-item prepend-icon="mdi-account-group-outline" title="공지사항 관리" ></v-list-item>
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

        </v-main>
    </v-layout>
  </v-card>
</template>

<script>

export default {
  name: "ProductRegiste",
  components: {
    
  },
  data() {
    return {
      

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
