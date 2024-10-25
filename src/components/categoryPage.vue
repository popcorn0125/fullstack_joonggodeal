<template>
<v-card>
    <v-data-iterator :items="games" :items-per-page="games.length">
        <template v-slot:default="{ items }">
        <v-container class="pa-2" fluid>
            <v-row dense>
            <v-col v-for="item in items" :key="item.title" cols="3" md="4">
                <v-card class="pb-3" border flat>
                <v-img :src="item.raw.img"></v-img>

                <v-list-item :subtitle="item.raw.subtitle" class="mb-2">
                    <template v-slot:title>
                    <strong class="text-h6 mb-2">{{ item.raw.title }}</strong>
                    </template>
                </v-list-item>

                <div class="d-flex justify-end px-4">
                    <v-btn
                    class="text-none"
                    size="small"
                    text="상품 보러가기"
                    border
                    flat
                    @click="categoryDetailPage(item.raw)"
                    >
                    </v-btn>
                </div>
                </v-card>
            </v-col>
            </v-row>
        </v-container>
        </template>
    </v-data-iterator>
</v-card>
</template>

<script>
import axios from 'axios';
export default {
    name: "categoryPage",
    components: {
        
    },
    data() {
        return {
        
        games: [
            // {

            // title: '모바일/태블릿',
            // key: 'mobile'
            // },
            // {
            // // img: home,
            // title: '가전제품',
            // key: 'appliances'
            // },
            // {
            //     title: '전자제품',
            //     key: 'electronics'
            // },
            // {
            // // img: 'https://cdn.vuetifyjs.com/docs/images/graphics/games/3.png',
            // title: '노트북/PC',
            // key: 'pc'
            // },
            // {
            // // img: 'https://cdn.vuetifyjs.com/docs/images/graphics/games/5.png',
            // title: '게임',
            // key:'game'
            // },
            // {
            // // img: 'https://cdn.vuetifyjs.com/docs/images/graphics/games/6.png',
            // title: '도서/음반/문구',
            // key: 'book'
            // },
            // {
            // // img: 'https://cdn.vuetifyjs.com/docs/images/graphics/games/7.png',
            // title: '패션의류',
            // key: 'fashion'
            // },
            // {
            // // img: 'https://cdn.vuetifyjs.com/docs/images/graphics/games/7.png',
            // title: '뷰티',
            // key: 'beauty'
            // },
            // {
            // // img: 'https://cdn.vuetifyjs.com/docs/images/graphics/games/7.png',
            // title: '수입명품',
            // key: 'brandshop'
            // },
            // {
            // title: '패션잡화',
            // key: 'fashiongoods'
            // },
            // {
            // title: '출산/유아동',
            // key:'infant'
            // },
            // {
            // title: '카메라/캠코더',
            // key: 'camera'
            // },
            // {
            // title: '가구/인테리어',
            // key: 'interior'
            // },
            // {
            // title: '리빙/생활',
            // key: 'living'
            // },
            // {
            // title: '반려동물/취미',
            // key: 'pet'
            // },
            // {
            // title: '티켓/쿠폰',
            // key: 'coupon'
            // },
            // {
            // title: '스포츠',
            // key: 'sports'
            // },
            // {
            // title: '레저/여행',
            // key: 'travel'
            // },
            // {
            // title: '중고차',
            // key: 'car'
            // },
        ],
        }
    },
    methods: {
        categoryDetailPage(raw) {
            console.log(raw)
            this.$cookies.set('category', raw.title);
            this.$cookies.set('category_idx', raw.key);
            this.$router.push({name: 'categoryDetail'})
        },

        setting() {
            axios({
                method : 'post',
                header: { 'Content-Type': 'application/json; charset=UTF-8' },
                url: "/productcategory/getcategory",
            })
            .then((response) => {
                if(response.data) {
                    this.games = response.data;
                }
            })
            .catch(function(){
                vm.errorModalContent();
            });
        }

    },

    created() {

    },
    mounted() {
        if(sessionStorage.getItem('USER_ID') == null && sessionStorage.getItem('JSESSIONID') == null) {
            this.$router.push({name:'LoginPage'});
            return
        }
        this.setting();
    },
}
</script>

<style scoped>
</style>
