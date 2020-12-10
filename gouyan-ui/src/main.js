import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
// 导入字体图标
import './assets/css/fonts/iconfont.css'

axios.defaults.baseURL = 'http://127.0.0.1:8181/'
axios.interceptors.request.use(config => {
  config.headers.Token = window.sessionStorage.getItem('token')
  return config
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
