import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import { Message }from 'element-ui'

import Login from '@/views/Login';
import Welcome from "@/views/Welcome";
import ActorInfo from "@/views/actor/ActorInfo";
import ActorRole from "@/views/actor/ActorRole";
import CinemaArea from "@/views/cinema/CinemaArea";
import CinemaInfo from "@/views/cinema/CinemaInfo";
import CinemaBrand from "@/views/cinema/CinemaBrand";
import HallInfo from "@/views/hall/HallInfo";
import HallCategory from "@/views/hall/HallCategory";
import MovieAge from "@/views/movie/MovieAge";
import MovieArea from "@/views/movie/MovieArea";
import MovieCategory from "@/views/movie/MovieCategory";
import MovieComment from "@/views/movie/MovieComment";
import MovieInfo from "@/views/movie/MovieInfo";
import MovieRuntime from "@/views/movie/MovieRuntime";
import SessionInfo from "@/views/session/SessionInfo";
import BillInfo from "@/views/user/BillInfo";
import UserHobby from "@/views/user/UserHobby";
import UserInfo from "@/views/user/UserInfo";
import ResourceInfo from "@/views/role/ResourceInfo";
import RoleInfo from "@/views/role/RoleInfo";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Login,
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/home',
    component: Home,
    redirect: '/welcome',
    children: [
      { path: '/welcome', component: Welcome },
      { path: '/cinema', component: CinemaInfo},
      { path: '/cinemaArea', component: CinemaArea},
      { path: '/cinemaBrand', component: CinemaBrand},
      { path: '/movie', component: MovieInfo},
      { path: '/movieComment', component: MovieComment},
      { path: '/movieAge', component: MovieAge},
      { path: '/movieArea', component: MovieArea},
      { path: '/movieCategory', component: MovieCategory},
      { path: '/movieRuntime', component: MovieRuntime},
      { path: '/hall', component: HallInfo},
      { path: '/hallCategory', component: HallCategory},
      { path: '/session', component: SessionInfo},
      { path: '/actor', component: ActorInfo},
      { path: '/actorRole', component: ActorRole},
      { path: '/user', component: UserInfo},
      { path: '/bill', component: BillInfo},
      { path: '/hobby', component: UserHobby},
      { path: '/role', component: RoleInfo},
      { path: '/resource', component: ResourceInfo}
    ]
  }
]

const router = new VueRouter({
  routes,
  mode: 'history',
})

//挂载路由导航守卫
router.beforeEach((to, from, next) =>{
  //to 将要访问的路径
  //from 从哪个页面来
  //next 一个放行函数

  if(to.path == '/login') return next();
  //获取token
  const token = window.sessionStorage.getItem("token")
  if(!token){
    Message.error('抱歉，请先登录')
    return next('/login');
  }
  next();
})

export default router
