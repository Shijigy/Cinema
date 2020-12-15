<template>
  <div>
    <!--面包屑导航区域-->
    <div class="board">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/welcome' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>电影管理</el-breadcrumb-item>
        <el-breadcrumb-item>电影评论</el-breadcrumb-item>
      </el-breadcrumb>
    </div>


    <!--卡片视图-->
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="2">
          <el-button type="danger" @click="multipleDelete" v-has>批量删除</el-button>
        </el-col>
      </el-row>

      <!--电影评论列表-->
      <el-table :data="moviecommentlist" style="width: 100%" border stripe @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="movieId" label="电影编号" width="145"></el-table-column>
        <el-table-column prop="userId" label="用户编号" width="145"></el-table-column>
        <el-table-column prop="commentTime" label="评论时间" width="145"></el-table-column>
        <el-table-column prop="content" label="评论内容" width="145"></el-table-column>
        <el-table-column prop="score" label="评分" width="145"></el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-tooltip effect="dark" content="删除影评" placement="top" :enterable="false" :open-delay="500">
              <el-button v-has type="danger" icon="el-icon-delete" size="mini" @click="deleteMovieComment(scope.row.movieId,scope.row.userId,scope.row.commentTime,scope.row.content,scope.row.score)"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <!--分页区域-->
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryInfo.pageNum"
          :page-sizes="[5, 7, 9]"
          :page-size="queryInfo.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>

    </el-card>

<!--    &lt;!&ndash;添加影厅对话框&ndash;&gt;-->
<!--    <el-dialog title="添加影厅" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">-->
<!--      &lt;!&ndash;内容主题区&ndash;&gt;-->
<!--      <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px">-->
<!--        &lt;!&ndash;prop：在addFormRules中定义校验规则， v-model：双向绑定数据&ndash;&gt;-->
<!--        <el-form-item label="影厅名称" prop="hallCategoryName">-->
<!--          <el-input v-model="addForm.hallCategoryName"></el-input>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      &lt;!&ndash;底部区域&ndash;&gt;-->
<!--      <span slot="footer" class="dialog-footer">-->
<!--      <el-button @click="addDialogVisible = false">取 消</el-button>-->
<!--      <el-button type="primary" @click="addHallCategory">确 定</el-button>-->
<!--      </span>-->
<!--    </el-dialog>-->

<!--    &lt;!&ndash;修改影厅对话框&ndash;&gt;-->
<!--    <el-dialog title="修改影厅" :visible.sync="editDialogVisible" width="50%" @close="editDialogClosed">-->
<!--      <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="100px">-->
<!--        <el-form-item label="影厅编号">-->
<!--          <el-input v-model="editForm.hallCategoryId" disabled></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="影厅名称" prop="hallCategoryName">-->
<!--          <el-input v-model="editForm.hallCategoryName"></el-input>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      <span slot="footer" class="dialog-footer">-->
<!--        <el-button @click="editDialogVisible = false">取 消</el-button>-->
<!--        <el-button type="primary" @click="editHallCategoryInfo">确 定</el-button>-->
<!--      </span>-->
<!--    </el-dialog>-->

  </div>
</template>

<script>
import global from "@/assets/css/global.css"
export default {
  name: "movieComment",
  // this.$message和this.$confirm都属于原型挂载, 在element.js中配置
  // Vue.prototype.$message = Message
  // Vue.prototype.$confirm = MessageBox.confirm
  data() {
    return {
      queryInfo: {
        query: '',
        pageNum: 1,
        pageSize: 7
      },
      moviecommentlist: [],
      total: 0,
      url: 'http://localhost:8181/',
      //控制对话框的显示与隐藏
      addDialogVisible: false,
      //添加影厅的表单数据
      // addForm: {
      //   hallCategoryName: ''
      // },
      // //验证表单规则对象
      // addFormRules: {
      //   hallCategoryName: [
      //     { required: true, message: '请输入影厅名', trigger: 'blur' }
      //   ]
      // },
      // editDialogVisible: false,
      // editForm: {},
      // editFormRules: {
      //   hallCategoryName: [
      //     { required: true, message: '请输入影厅名', trigger: 'blur' }
      //   ]
      // },
      multipleSelection: []
    }
  },
  created() {
    this.getMovieCommentList()
  },
  methods: {
    getMovieCommentList() {
      const _this = this;
      axios.get(_this.url + 'sysMovieComment', {params: _this.queryInfo}).then(resp => {
        console.log(resp)
        _this.moviecommentlist = resp.data.data;
        _this.total = resp.data.total;
        _this.queryInfo.pageSize = resp.data.pageSize;
        _this.queryInfo.pageNum = resp.data.pageNum;
      })
    },
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize
      this.getMovieCommentList()
      console.log(newSize)
    },
    handleCurrentChange(newPage) {
      this.queryInfo.pageNum = newPage
      this.getMovieCommentList()
      console.log(newPage)
    },
    // 监听添加对话框的关闭事件
    addDialogClosed(){
      this.$refs.addFormRef.resetFields()
    },
    // 监听添加按钮
    // addHallCategory(){
    //   const _this = this;
    //   this.$refs.addFormRef.validate(async valid => {
    //     console.log(valid)
    //     if (!valid) return
    //     //预校验成功，发网络请求
    //     axios.defaults.headers.post['Content-Type'] = 'application/json'
    //     await axios.post(_this.url + 'sysHallCategory', JSON.stringify(_this.addForm)).then(resp => {
    //       console.log(resp)
    //       if (resp.data.code !== 200){
    //         this.$message.error('添加电影评论失败！')
    //       }
    //     })
    //     //隐藏添加对话框
    //     this.addDialogVisible = false
    //     //重新加载列表
    //     this.getHallCategoryList()
    //     this.$message.success('添加电影评论成功！')
    //   })
    // },
    // 显示修改对话框，回显数据
    // showEditDialog(id){
    //   const _this = this
    //   axios.get(_this.url + 'sysHallCategory/' + id ).then(resp => {
    //     console.log(resp)
    //     _this.editForm = resp.data.data
    //   })
    //   this.editDialogVisible = true
    // },
    // 监听修改对话框的关闭事件
    // editDialogClosed(){
    //   this.$refs.editFormRef.resetFields()
    // },
    // 修改电影评论信息并提交
    // editHallCategoryInfo(){
    //   this.$refs.editFormRef.validate(async valid => {
    //     const _this = this
    //     if (!valid) return
    //     axios.defaults.headers.put['Content-Type'] = 'application/json'
    //     await axios.put(_this.url + '/sysHallCategory', JSON.stringify(_this.editForm)).then(resp => {
    //       if (resp.data.code !== 200){
    //         this.$message.error('修改电影评论失败！')
    //       }
    //     })
    //     this.editDialogVisible = false
    //     this.getHallCategoryList()
    //     this.$message.success('修改电影评论成功！')
    //   })
    // },
    // 监听多选框变化
    handleSelectionChange(val){
      this.multipleSelection = val
    },
    async multipleDelete(){
      const _this = this
      //询问用户是否确认删除
      const resp = await this.$confirm('此操作将永久删除这些条目, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).catch(err => err)

      // 用户确认删除, resp为字符串"confirm"
      // 用户取消删除，resp为字符串"cancel"
      if (resp == 'cancel'){
        return _this.$message.info('已取消删除')
      }

      let ids = []
      this.multipleSelection.forEach(data => {
        ids.push(data.movieId)
      })
      await axios.delete(_this.url + 'sysMovieComment/' + ids).then(resp => {
        if (resp.data.code !== 200){
          this.$message.success('批量删除电影评论失败！')
        }
      })
      this.getMovieCommentList()
      this.$message.success('批量删除电影评论成功！')
    },
    //根据id删除对应的电影评论
    async deleteMovieComment(id1,id2,time,c,s){
      let deleteInfo = [{
        movieId : id1,
        userId : id2,
        commentTime : time,
        content : c,
        score : s
      }]
      console.log(deleteInfo);
      const _this = this
      //询问用户是否确认删除
      const resp = await this.$confirm('此操作将永久删除该条目, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).catch(err => err)

      // 用户确认删除, resp为字符串"confirm"
      // 用户取消删除，resp为字符串"cancel"
      console.log(resp)
      if (resp == 'cancel'){
        return _this.$message.info('已取消删除')
      }
      axios.defaults.headers.post['Content-Type'] = 'application/json'
      await axios.post(_this.url + 'sysMovieComment/delete', JSON.stringify(deleteInfo)).then(resp => {
        console.log(resp);
        console.log(deleteInfo)
        if (resp.data.code !== 200){
          _this.$message.success('删除电影评论失败！')
        }
      })
      this.getMovieCommentList()
      this.$message.success('删除电影评论成功！')
    }
  }
}
</script>

<style scoped>

</style>