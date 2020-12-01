import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

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
import RoleAuthority from "@/views/role/RoleAuthority";
import SessionInfo from "@/views/session/SessionInfo";
import BillInfo from "@/views/user/BillInfo";
import UserHobby from "@/views/user/UserHobby";
import UserInfo from "@/views/user/UserInfo";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
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
      { path: '/role', component: RoleAuthority}
    ]
  }
]

const router = new VueRouter({
  routes,
  mode: 'history',
})

export default router
