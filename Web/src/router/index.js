import Vue from 'vue'
import Router from 'vue-router'
import LoginPage from '@/components/LoginPage'
import login from '@/components/login/login'
import register from '@/components/login/register'
import MainPage from '@/components/mainPage'
import ArticlePage from '@/components/ArticlePage'
import WriteArticlePage from '@/components/WriteArticlePage'
import ToolsPage from '@/components/ToolsPage'
import SearchPage from '@/components/SearchPage'
import PersonPage from '@/components/PersonPage'


Vue.use(Router)

export default new Router({
  // mode: 'history',
  routes: [
    {
      path: '/',
      name: 'LoginPage',
      component: LoginPage,
      redirect:login,
      children:[
        {
          path: '/login',
          name: 'login',
          component: login,
       
        },
        {
          path: '/register',
          name: 'register',
          component: register,
       
        }
      ]
    },
    {
      path:'/mainPage',
      name:'mainPage',
      component:MainPage
    },
    {
      path:'/articlePage',
      name:'articlePage',
      component:ArticlePage
    },
    {
      path:'/writeArticlePage',
      name:'writeArticlePage',
      component:WriteArticlePage
    },
    {
      path:'/personPage',
      name:'personPage',
      component:PersonPage
    },
    {
      path:'/toolsPage',
      name:'toolsPage',
      component:ToolsPage
    },
    {
      path:'/searchPage',
      name:'searchPage',
      component:SearchPage
    }
    
  ]
})
