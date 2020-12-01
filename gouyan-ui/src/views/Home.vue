<template>
  <el-container class="home-container">
    <el-header>
      <div>
        <img src="../assets/logo.png" alt="" height="50px" width="50px">
        <span>狗眼电影后台管理系统</span>
      </div>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <el-container>
      <el-aside :width="isCollapsed ? '64px' : '250px'">
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <!--侧边栏菜单-->
        <el-menu
            background-color="#333744"
            text-color="#fff"
            active-text-color="#409EFF"
            unique-opened
            :collapse="isCollapsed"
            :collapse-transition="false"
            :router="true">
          <!--一级菜单-->
          <el-submenu :index="String(item.data.id)" v-for="item in menulist" :key="item.data.id">
            <!--一级菜单的模板区域-->
            <template slot="title">
              <!--图标-->
              <i :class="iconlist[item.data.id]"></i>
              <!--文本-->
              <span>{{item.data.name}}</span>
            </template>
            <!--二级菜单-->
            <el-menu-item :index="'/' + subItem.path" v-for="subItem in item.data.children" :key="subItem.id">
              <template slot="title">
                <!--图标-->
                <i class="el-icon-menu"></i>
                <!--文本-->
                <span>{{ subItem.name }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>



<script>
export default {
  data(){
    return {
      //左侧菜单数据
      menulist: [
        {
          "data":
              {
                "id": 1,
                "name": "影院管理",
                "path": null,
                "children": [
                  {
                    "id": 11,
                    "name": "影院信息管理",
                    "path": "cinema",
                    "children": []
                  },
                  {
                    "id": 12,
                    "name": "影院区域管理",
                    "path": "cinemaArea",
                    "children": []
                  },
                  {
                    "id": 13,
                    "name": "影院品牌管理",
                    "path": "cinemaBrand",
                    "children": []
                  },
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
        {
          "data":
              {
                "id": 2,
                "name": "电影管理",
                "path": null,
                "children": [
                  {
                    "id": 21,
                    "name": "电影信息管理",
                    "path": "movie",
                    "children": []
                  },
                  {
                    "id": 22,
                    "name": "电影评论管理",
                    "path": "movieComment",
                    "children": []
                  },
                  {
                    "id": 23,
                    "name": "电影年代管理",
                    "path": "movieAge",
                    "children": []
                  },
                  {
                    "id": 24,
                    "name": "电影区域管理",
                    "path": "movieArea",
                    "children": []
                  },
                  {
                    "id": 25,
                    "name": "电影类别管理",
                    "path": "movieCategory",
                    "children": []
                  },
                  {
                    "id": 26,
                    "name": "电影播放时段管理",
                    "path": "movieRuntime",
                    "children": []
                  }
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
        {
          "data":
              {
                "id": 3,
                "name": "影厅管理",
                "path": null,
                "children": [
                  {
                    "id": 31,
                    "name": "影厅信息管理",
                    "path": "hall",
                    "children": []
                  },
                  {
                    "id": 32,
                    "name": "影厅类别管理",
                    "path": "hallCategory",
                    "children": []
                  }
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
        {
          "data":
              {
                "id": 4,
                "name": "场次管理",
                "path": null,
                "children": [
                  {
                    "id": 41,
                    "name": "场次信息管理",
                    "path": "session",
                    "children": []
                  }
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
        {
          "data":
              {
                "id": 5,
                "name": "演员管理",
                "path": null,
                "children": [
                  {
                    "id": 51,
                    "name": "演员信息管理",
                    "path": "actor",
                    "children": []
                  },
                  {
                    "id": 52,
                    "name": "演员角色管理",
                    "path": "actorRole",
                    "children": []
                  }
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
        {
          "data":
              {
                "id": 6,
                "name": "用户管理",
                "path": null,
                "children": [
                  {
                    "id": 61,
                    "name": "用户信息管理",
                    "path": "user",
                    "children": []
                  },
                  {
                    "id": 62,
                    "name": "订单管理",
                    "path": "bill",
                    "children": []
                  },
                  {
                    "id": 63,
                    "name": "用户爱好管理",
                    "path": "hobby",
                    "children": []
                  }
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
        {
          "data":
              {
                "id": 7,
                "name": "权限管理",
                "path": null,
                "children": [
                  {
                    "id": 71,
                    "name": "角色信息管理",
                    "path": "role",
                    "children": []
                  }
                ]
              },
          "meta":
              {
                "msg": "获取菜单列表成功",
                "status": 200
              }
        },
      ],
      iconlist: {
        '1': 'el-icon-s-home',
        '2': 'el-icon-video-camera-solid',
        '3': 'el-icon-s-help',
        '4': 'el-icon-message-solid',
        '5': 'el-icon-s-custom',
        '6': 'el-icon-user-solid',
        '7': 'el-icon-warning'
      },
      isCollapsed: false
    }
  },
  name: "Home",
  methods:{
    logout(){

    },
    // 菜单展开与闭合：点击事件
    toggleCollapse(){
      this.isCollapsed = !this.isCollapsed
    }
  }
}
</script>

<style>

.home-container{
  height: 100%;
}

.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: whitesmoke;
  font-size: 20px;
}

.el-header > div{
  display: flex;
  align-items: center;
}

div > span{
  margin-left: 15px;
}



.el-aside {
  background-color: #333744;
}

.el-main{
  background-color: #EAEDF1;
}

.toggle-button{
  background-color: #4A5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;

}
</style>
