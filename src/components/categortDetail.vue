<template>
<v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
        <h1 class="font-weight-bold text-h2 text-basil">중고나라</h1>
    </v-card-title>

    <v-tabs v-model="tab" bg-color="transparent" color="basil" grow>
        <v-tab v-for="(item, index) in items" :key="index" :value="index" @click="this.$router.push({path: '/'})">
        {{ item }}
        </v-tab>
    </v-tabs>
    <!-- 컴포넌트 -->
    
</v-card>
<v-data-iterator :items="mice" :items-per-page="itemsPerPage" style="margin-top: 15px;">
        <template v-slot:header="{ page, pageCount, prevPage, nextPage }">
            <h1
                class="text-h4 font-weight-bold d-flex justify-space-between mb-4 align-center"
            >
                <div class="text-truncate">{{ title }}</div>

                <div class="d-flex align-center">
                    <!-- 검색 들어갈 자리 -->

                    <div class="d-inline-flex">
                        <v-btn
                        :disabled="page === 1"
                        class="me-2"
                        icon="mdi-arrow-left"
                        size="small"
                        variant="tonal"
                        @click="prevPage"
                        ></v-btn>

                        <v-btn
                        :disabled="page === pageCount"
                        icon="mdi-arrow-right"
                        size="small"
                        variant="tonal"
                        @click="nextPage"
                        ></v-btn>
                    </div>
                </div>
            </h1>
        </template>

        <template v-slot:default="{ items }">
        <v-row>
            <v-col v-for="(item, i) in items" :key="i" cols="12" sm="4" xl="3">
                <v-sheet border>
                    <v-img
                    :gradient="`to top right, rgba(255, 255, 255, .1), rgba(${item.raw.color}, .15)`"
                    :src="item.raw.src"
                    height="150"
                    cover
                    ></v-img>

                    <v-list-item
                    :title="item.raw.name"
                    density="comfortable"
                    lines="two"
                    subtitle="Lorem ipsum dil orei namdie dkaf"
                    >
                        <template v-slot:title>
                            <strong class="text-h6"> {{ item.raw.name }} </strong>
                        </template>
                    </v-list-item>

                    <v-table class="text-caption" density="compact">
                        <tbody>
                            <tr align="right">
                            <th>상태:</th>

                            <td>{{ item.raw.status }}</td>
                            </tr>

                            <tr align="right">
                            <th>시작가:</th>

                            <td>{{ item.raw.startPrice }}</td>
                            </tr>

                            <tr align="right">
                            <th>현재가:</th>

                            <td>{{ item.raw.currentPrice }}</td>
                            </tr>

                            <tr align="right">
                            <th>경매 진행 여부:</th>

                            <td>{{ item.raw.wireless ? '진행중' : '종료' }}</td>
                            </tr>

                            <tr align="left" v-if="item.raw.wireless">
                            <v-btn
                                @click="detailProduct(1)"
                                style="margin: 10px"
                                class="text-none"
                                size="small"
                                text="경매 참가"
                                border
                                flat
                            >
                            </v-btn>
                            </tr>
                        </tbody>
                    </v-table>
                </v-sheet>
            </v-col>
        </v-row>
        </template>

        <template v-slot:footer="{ page, pageCount }">
            <v-footer
                class="justify-space-between text-body-2 mt-4"
                color="surface-variant"
            >
                Total mice: {{ mice.length }}

                <div>Page {{ page }} of {{ pageCount }}</div>
            </v-footer>
        </template>
    </v-data-iterator>
</template>

<script>
export default {
    name: 'categoryDetail',
    data() {
    return {
        tab: 0,
        items: ['카테고리'],
        title: '',
        title_key: '',
        itemsPerPage: 12,
        mice: [
        {
            name: 'Logitech G Pro X',
            color: '14, 151, 210',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: 'yes',
            description: 'Logitech G Pro X',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/1.png',
        },
        {
            name: 'Razer DeathAdder V2',
            color: '12, 146, 47',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 69.99,
            description: 'Razer DeathAdder V2',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/2.png',
        },
        {
            name: 'Corsair Dark Core RGB',
            color: '107, 187, 226',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: true,
            price: 89.99,
            description: 'Corsair Dark Core RGB',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/3.png',
        },
        {
            name: 'SteelSeries Rival 3',
            color: '228, 196, 69',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 29.99,
            description: 'SteelSeries Rival 3',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/4.png',
        },
        {
            name: 'HyperX Pulsefire FPS Pro',
            color: '156, 82, 251',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 44.99,
            description: 'HyperX Pulsefire FPS Pro',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/5.png',
        },
        {
            name: 'Zowie EC2',
            color: '166, 39, 222',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 69.99,
            description: 'Zowie EC2',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/6.png',
        },
        {
            name: 'Roccat Kone AIMO',
            color: '131, 9, 10',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 79.99,
            description: 'Roccat Kone AIMO',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/7.png',
        },
        {
            name: 'Logitech G903',
            color: '232, 94, 102',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: true,
            price: 129.99,
            description: 'Logitech G903',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/8.png',
        },
        {
            name: 'Cooler Master MM711',
            color: '58, 192, 239',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 49.99,
            description: 'Cooler Master MM711',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/9.png',
        },
        {
            name: 'Glorious Model O',
            color: '161, 252, 250',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 49.99,
            description: 'Glorious Model O',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/10.png',
        },
        {
            name: 'HP Omen Photon',
            color: '201, 1, 2',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: true,
            price: 99.99,
            description: 'HP Omen Photon',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/11.png',
        },
        {
            name: 'Asus ROG Chakram',
            color: '10, 181, 19',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: true,
            price: 159.99,
            description: 'Asus ROG Chakram',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/12.png',
        },
        {
            name: 'Razer Naga X',
            color: '100, 101, 102',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 79.99,
            description: 'Razer Naga X',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/13.png',
        },
        {
            name: 'Mad Catz R.A.T. 8+',
            color: '136, 241, 242',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: false,
            price: 99.99,
            description: 'Mad Catz R.A.T. 8+',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/14.png',
        },
        {
            name: 'Alienware 610M',
            color: '109, 110, 114',
            status: 'A급',
            startPrice: 149.99,
            currentPrice: 180.12,
            wireless: true,
            price: 99.99,
            description: 'Alienware 610M',
            src: 'https://cdn.vuetifyjs.com/docs/images/graphics/mice/15.png',
        },
        ],
    }
    },
    methods: {
        detailProduct(id) {
            this.$router.push({name: 'productDetail', query: {id:id}});
        },
        onClickSeeAll() {
            this.itemsPerPage = this.itemsPerPage === 4 ? this.mice.length : 4
        },

        settingTitle() {
            const vm = this;
            switch(vm.title_key) {
                case 'mobile':
                    vm.title = "모바일/태블릿"
                    break;
                case 'appliances':
                    vm.title = "가전제품";
                    break;
                case 'electronics':
                    vm.title = "전자제품";
                    break;
                case 'pc':
                    vm.title = "노트북/PC";
                    break;
                case 'game':
                    vm.title = "게임";
                    break;
                case 'book':
                    vm.title = "도서/음반/문구";
                    break;
                case 'fashion':
                    vm.title = "패션의류";
                    break;
                case 'beauty':
                    vm.title = "뷰티";
                    break;
                case 'brandshop':
                    vm.title = "수입명품";
                    break;
                case 'fashiongoods':
                    vm.title = "패션잡화";
                    break;
                case 'infant':
                    vm.title = "출산/유아동";
                    break;
                case 'camera':
                    vm.title = "카메라/캠코더";
                    break;
                case 'interior':
                    vm.title = "가구/인테리어";
                    break;
                case 'living':
                    vm.title = "리빙/생활";
                    break;
                case 'pet':
                    vm.title = "반려동물/취미";
                    break;
                case 'coupon':
                    vm.title = "티켓/쿠폰";
                    break;
                case 'sports':
                    vm.title = "스포츠";
                    break;
                case 'travel':
                    vm.title = "레저/여행";
                    break;
                case 'car':
                    vm.title = "중고차";
                    break;
                default:
                    vm.title = "카테고리 없음";
            }
        }
    },
    mounted() {
        this.title_key = this.$route.params.key;
        console.log('title key', this.title_key)
        this.settingTitle();

    }
}
</script>

<style scoped>
  /* Helper classes */
  .bg-basil {
    background-color: #fffbe6 !important;
  }
  .text-basil {
    color: #356859 !important;
  }
</style>  