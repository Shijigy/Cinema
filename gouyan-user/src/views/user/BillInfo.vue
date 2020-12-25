<template>
  <div >
  <div class="order-box" v-for="item in billList">
    <div class="order-header">
      <span class="order-date">{{item.billDate}}}</span>
      <span class="order-id">狗眼订单号:{{item.billId}}</span>
      <span class="del-order"  @click="deleteBill(item.billId)">
        <i class="el-icon-delete"></i>
      </span>
    </div>
    <div class="order-body">
      <div class="poster">
        <img :src="getSrc(item.sysSession.sysMovie.moviePoster)">
      </div>
    </div>
    <div class="order-content">
      <div class="movie-name">{{item.sysSession.sysMovie.movieNameCn}}</div>
      <div class="cinema-name">{{item.sysSession.sysCinema.cinemaName}}</div>
      <div class="hall-ticket">
        <span>{{item.sysSession.sysHall.sysHallCategory.hallCategoryName+item.sysSession.sysHall.hallName}}</span>
        <span></span>
      </div>
      <div class="show-time">{{item.sysSession.sessionDate}}</div>
    </div>
    <div class="order-price">￥{{item.sysSession.sessionPrice}}</div>
    <div class="order-status">
      {{item.billState?'已完成':'未完成'}}
    </div>
    <div class="actions">
      <div>
        <a href="" class="order-detail" >查看详情</a>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "BillInfo",
  data(){
    return{
      queryInfo:{
        userId:''
      },
      billList:[
        {
          sysSession:{
            sysMovie:{
              moviePoster:''
            }
          }
        }
      ]
    }
  },
  methods:{
    getUser(){
      this.queryInfo.userId = JSON.parse(window.sessionStorage.getItem('loginUser')).userId
    },
    getBillList(){
      const _this = this
      axios.get('sysBill',{params:_this.queryInfo}).then(resp=>{
        _this.billList = resp.data.data
        console.log(_this.billList)
      })

    },
    async deleteBill(id){
      const _this = this
      const resp = await this.$confirm('此操作将永久删除订单信息,是否继续?','提示',{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).catch(err=>err)
      if(resp=="cancel"){
        return _this.$message.info('已取消删除')
      }
      await axios.delete('sysBill/'+id).then(resp=>{
        if (resp.data.code !== 200){
          this.$message.success('删除失败！')
        }
      })
      this.getBillList()
      this.$message.success('删除成功！')
    },
    getSrc(s){
      return 'http://127.0.0.1:8181'+JSON.parse(s)[0]
    },
  },
  created() {
    this.getUser()
    this.getBillList()
  }
}
</script>

<style scoped>
.order-box {
  border: 1px solid #e5e5e5;
  margin: 0 40px 30px 0;
}
.order-box .order-header {
  background-color: #f7f7f7;
  font-size: 14px;
  padding: 16px 20px;
}
.order-box .order-header .order-date {
  color: #333;
  display: inline-block;
  margin-right: 30px;
}
.order-box .order-header .order-id {
  color: #999;
}
.order-box .order-header .del-order {
  width: 15px;
  height: 16px;
  float: right;
}
.order-box .order-body {
  padding: 20px;
  padding-right: 0;
}
.order-box .order-body .poster {
  border: 2px solid #fff;
  -webkit-box-shadow: 0 1px 2px 0 hsla(0,0%,53%,.5);
  box-shadow: 0 1px 2px 0 hsla(0,0%,53%,.5);
  margin-right: 11px;
  font-size: 0;
}

.order-box .order-body .poster img {
  width: 100%;
  height: 100%;
}

.order-box .order-body .order-content {
  width: 49%;
}
.order-box .order-body .movie-name {
  font-size: 16px;
  font-weight: 700;
  color: #333;
  margin: 4px 0 7px -6px;
}
.order-box .order-body .cinema-name, .order-box .order-body .hall-ticket {
  font-size: 12px;
  color: #999;
  margin-bottom: 4px;
}
.order-box .order-body .cinema-name, .order-box .order-body .hall-ticket {
  font-size: 12px;
  color: #999;
  margin-bottom: 4px;
}
.order-box .order-body .show-time {
  font-size: 12px;
  color: #f03d37;
}
.order-box .order-body .actions, .order-box .order-body .order-price, .order-box .order-body .order-status {
  font-size: 14px;
  color: #333;
  width: 12%;
  line-height: 95px;
}
.order-box .order-body .actions .order-detail {
  color: #333;
}

.order-box .order-body>div {
  display: inline-block;
  vertical-align: top;
}
body {
  font-family: Microsoft YaHei,Helvetica,Arial,sans-serif;
  background-color: #fff;
  -webkit-font-smoothing: subpixel-antialiased;
}

</style>