<template>
  <v-card flat>
    <v-card-title class="d-flex align-center pe-2">
      <h2>입찰 내역</h2>

      <v-spacer></v-spacer>

      <v-text-field
        v-model="search"
        density="compact"
        label="Search"
        prepend-inner-icon="mdi-magnify"
        variant="solo-filled"
        flat
        hide-details
        single-line
      ></v-text-field>
    </v-card-title>

    <v-divider></v-divider>
    <v-data-table v-model:search="search" :items="items">
      <template v-slot:item.name="{item}">
        <v-text>{{ item.title }}</v-text>
      </template>

      <template v-slot:item.image="{ item }">
        <v-card class="my-2" elevation="2" rounded>
          <v-img
            :src="`https://cdn.vuetifyjs.com/docs/images/graphics/gpus/${item.image}`"
            height="64"
            cover
          ></v-img>
        </v-card>
      </template>

      <template v-slot:item.price="{item}">
        <v-text>{{ item.price }}</v-text>
      </template>

      <template v-slot:item.date="{item}">
        <v-text>{{ item.date }}</v-text>
      </template>

      <template v-slot:item.button="{ item }">
        <v-btn v-if="false" variant="outlined" style="color: #1b75d0">
          {{ item.button }}
        </v-btn>
        <v-btn v-if="true" variant="outlined" style="color: #1b75d0" readonly>
          배송중
        </v-btn>
      </template>
    </v-data-table>
  </v-card>
</template>

<script>

export default {
  name: "Main",
  components: {
    
  },
  data() {
    return {
      search: '',
        items: [
          {
            title: 'Nebula GTX 3080',
            image: '1.png',
            price: 699.99,
            date: '2024-11-20 14:55',
            button: '구매',
          },
          {
            title: 'Galaxy RTX 3080',
            image: '2.png',
            price: 799.99,
            date: '2024-11-20 14:55',
            stock: false,
          },
          {
            title: 'Orion RX 6800 XT',
            image: '3.png',
            price: 649.99,
            date: '2024-11-20 14:55',
            stock: true,
          },
          {
            title: 'Vortex RTX 3090',
            image: '4.png',
            price: 1499.99,
            date: '2024-11-20 14:55',
            stock: true,
          },
          {
            title: 'Cosmos GTX 1660 Super',
            image: '5.png',
            price: 299.99,
            date: '2024-11-20 14:55',
            stock: false,
          },
        ],

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
