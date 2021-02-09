import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from "../Login";
import UserRegister from "../UserRegister";

Vue.use(Router)

export default new Router({
  routes: [
/*    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },*/
    {
      path:'/',
      name:"login",
      component:Login
    },
    {
      path:'/register',
      name:"register",
      component:UserRegister
    }
  ]
})
