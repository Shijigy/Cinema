<template>
  <el-container>
    <el-header>
      <el-menu :default-active="$route.path"
               class="nav-menu"
               mode="horizontal"
               :router="true"
               active-text-color="#409EFF"
               background-color="#47464A">
        <el-menu-item :index="item.path" v-for="item in menuList" :key="item.id">{{item.name}}</el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "Movie",
  data(){
    return {
      menuList: [
        {
          id: '1',
          name: '正在热映',
          path: '/movie/movieOngoing'
        },
        {
          id: '2',
          name: '即将上映',
          path: '/movie/movieUpcoming'
        },
        {
          id: '3',
          name: '经典影片',
          path: '/movie/movieClassics'
        }
      ]
    }
  },
  created() {
  }
}
</script>

<style scoped>
.el-header{
  padding: 0px;
}

.nav-menu{
  display: flex;
  justify-content: space-around;
}

.el-menu-item{
  font-size: 16px;
}

.el-menu-item:hover{
  color: #FFFFFF !important;
}
</style>