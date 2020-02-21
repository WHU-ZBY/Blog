// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import vueAxios from 'vue-axios'
import axios from 'axios'
import Antd from 'ant-design-vue'
import store from './store/store'
import Vuex from 'vuex'
import Toast from './assets/js/Toast'

// import Input from 'ant-design-vue/lib/input'

// import Button from 'ant-design-vue/lib/button'
import 'ant-design-vue/dist/antd.css'


Vue.use(vueAxios, axios)
// Vue.component(Button.name, Button)
// Vue.component(Input.name,Input)
Vue.use(Antd)
Vue.use(Vuex)
// Vue.use(jwtDecode)
Vue.config.productionTip = false
Vue.prototype.$toast = Toast
// 全局路由构造函数，判断是否登录和要跳转到页面
router.beforeEach((to, from, next) => {
  if (to.matched.some(m => m.meta.requireAuth)) {    // 需要登录
    if(window.localStorage.token && window.localStorage.isLogin === '1'){
      next()
    } else if (to.path !== '/login') {
      let token = window.localStorage.token;
      if (token === 'null' || token === '' || token === undefined){
          next({path: '/login'})
          Toast({ message: '检测到您还未登录,请登录后操作！', duration: 1500 })
      }
    } else {
      next()
    }
  } else {   // 不需要登录
    next()
  }
})


//添加请求拦截器
axios.interceptors.request.use(
  config =>{
    if(store.state.token){
      config.headers.common['token'] =store.state.token
    }
    return config;
  },
  error =>{
    //对请求错误做什么
    return Promise.reject(error);
  })

//http reponse响应拦截器
axios.interceptors.response.use(
  response =>{
    return response;
  },
  error=>{
    if(error.response){
      switch(error.response.status){
        case 401:
          localStorage.removeItem('token');
          router.replace({
            path: '/login',
            query: {redirect: router.currentRoute.fullPath}//登录成功后跳入浏览的当前页面
          })
      }
    }
  })








/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
