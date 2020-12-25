<template>
  <el-container>
    <el-aside>
      <h1>个人中心</h1>
      <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          :router="true">
        <el-menu-item :index="item.path" v-for="item in menuList" :key="item.id">{{item.name}}</el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script>
export default {
  name: "UserMenu",
  data(){
    return{
      url:'',
      menuList:[
        {
          id:1,
          name:'我的订单',
          path:'/bill'
        },
        {
          id:2,
          name:'基本信息',
          path:'/user'
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>