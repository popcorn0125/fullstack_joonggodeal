// router/index.js
import { createWebHistory, createRouter } from "vue-router";

import LoginPage from "@/SignInUp/Login.vue";
import SignUpPage from "@/SignInUp/SignUp.vue";
import FindByIdPage from "@/SignInUp/FindById.vue";
import Main from "@/ContentPage/Main.vue";

import AdminLogin from '@/admin/AdminLogin.vue';
import AdminUsers from '@/admin/adminUserMangement.vue';
import ProductRegiste from "@/admin/ProductRegiste.vue";

import categoryDetail from '@/components/categortDetail.vue'
import productDetail from "@/components/productDetail.vue";



const routes = [
    {
        path: "/",
        name: "Main",
        component: Main,
    },
    {
        path: "/login",
        name: "LoginPage",
        component: LoginPage,
    },
    {
        path: "/signup",
        name: "SignUpPage",
        component: SignUpPage,
    },
    {
        path: "/findbyid",
        name: "FindByIdPage",
        component: FindByIdPage,
    },
    {
        path: "/admin/login",
        name: "AdminLogin",
        component: AdminLogin
    },
    {
        path: "/admin/users",
        name: "AdminUsers",
        component: AdminUsers
    },
    
      {
        path: '/category/:key',
        name: 'categoryDetail',
        component: categoryDetail
      },
    {
        path: '/product',
        name: 'productDetail',
        component: productDetail
    },
    {
        path: '/admin/registe',
        name: 'ProductRegiste',
        component: ProductRegiste
    }
      
    
    
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;