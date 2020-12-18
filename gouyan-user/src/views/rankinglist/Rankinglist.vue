<template>
  <div>
    <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item index="1">热映口碑榜</el-menu-item>
      <el-menu-item index="2">国内票房榜</el-menu-item>
      <el-menu-item index="3">北美票房榜</el-menu-item>
      <el-menu-item index="4">TOP100榜</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Rankinglist",
  data(){
    return{
      activeIndex: '1'
    }
  }
}
</script>

<style scoped>
.el-menu{
  display: flex;
  justify-content: space-between;
}

.el-menu-item{
  font-size: 18px;
}


</style>