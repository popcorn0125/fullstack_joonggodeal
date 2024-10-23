import { createApp } from 'vue'
import App from './App.vue'
import routers from './routers/router.js'  // router import
import cookies from 'vue3-cookies'
import vuetify from './plugins/vuetify'

// 위 createApp 코드 아래처럼 변경
const app = createApp(App)
app.use(routers)  // router 추가
app.use(cookies, {
    expire : "1d",
    path : "/",
})
app.use(vuetify)
app.mount('#app')
