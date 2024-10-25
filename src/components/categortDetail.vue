<template>
<v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
        <h1 class="font-weight-bold text-h2 text-basil">중고딜</h1>
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
                    
                    :src="`http://localhost:8080/images/${item.raw.src}`"
                    height="150"
                    cover
                    ></v-img>

                    <v-list-item
                    :title="item.raw.title"
                    density="comfortable"
                    lines="two"
                    :subtitle="item.raw.name"
                    >
                        <template v-slot:title>
                            <strong class="text-h6"> {{ item.raw.title }} </strong>
                        </template>
                    </v-list-item>

                    <v-table class="text-caption" density="compact">
                        <tbody>
                            <tr align="right">
                            <th>제목 :</th>

                            <td>{{ item.raw.title }}</td>
                            </tr>

                            <tr align="right">
                            <th>시작가:</th>

                            <td>{{ item.raw.startprice }}</td>
                            </tr>

                            <tr align="right">
                            <th>현재가: </th>

                            <td>{{ item.raw.currentprice == 0? "아직 제시된 가격이 없음" : item.raw.currentprice }}</td>
                            </tr>

                            <tr align="right">
                            <th>경매 진행 여부:</th>

                            <td>{{ item.raw.sell == 'N' ? '진행중' : '종료' }}</td>
                            </tr>

                            <tr align="left" v-if="item.raw.sell=='N'?true:false">
                            <v-btn
                                @click="detailProduct(item.raw.idx)"
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
import axios from 'axios';

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
        ],
    }
    },
    methods: {
        detailProduct(id) {
            console.log('id',id)
            this.$router.push({name: 'productDetail', query: {id:id}});
        },
        onClickSeeAll() {
            this.itemsPerPage = this.itemsPerPage === 4 ? this.mice.length : 4
        },

        settingTitle() {
            const vm = this;
            vm.title = vm.$cookies.get('category');
            axios({
                method : 'post',
                header: { 'Content-Type': 'application/json; charset=UTF-8' },
                url: "/productcategory/getcategorygoods",
                data: {idx: parseInt(vm.title_key)}
            })
            .then((response) => {
                if(response.data != null) {
                    vm.mice = response.data;
                }
            })
            .catch(function(){
                alert("에러가 발생하였습니다.")
            });
        }
    },
    mounted() {
        this.title_key = this.$cookies.get('category_idx');
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