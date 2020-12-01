<template>
  <div>
    <!--面包屑导航区域-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/welcome' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>影厅管理</el-breadcrumb-item>
      <el-breadcrumb-item>影厅分类</el-breadcrumb-item>
    </el-breadcrumb>

    <!--卡片视图-->
    <el-card class="box-card">
      <el-row :gutter="20">
        <!--        <el-col :span="8">-->
        <!--          <el-input placeholder="请输入影厅名称">-->
        <!--            <el-button slot="append" icon="el-icon-search"></el-button>-->
        <!--          </el-input>-->
        <!--        </el-col>-->
        <el-col :span="2">
          <el-button type="primary" @click="addDialogVisible = true">添加影厅</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="warning">删除影厅</el-button>
        </el-col>
      </el-row>

      <!--影厅分类列表-->
      <el-table :data="hallcategorylist" style="width: 45%" border stripe>
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="hallCategoryId" label="影厅编号" width="145"></el-table-column>
        <el-table-column prop="hallCategoryName" label="影厅名称" width="180"></el-table-column>
        <el-table-column label="操作" width="150">
          <template v-slot:default="slotProps" v-model="slotProps.row">
            <el-tooltip effect="dark" content="修改影厅信息" placement="top" :enterable="false" open-delay="500">
              <el-button type="primary" icon="el-icon-edit" size="mini"></el-button>
            </el-tooltip>
            <el-tooltip effect="dark" content="删除影厅" placement="top" :enterable="false" open-delay="500">
              <el-button type="danger" icon="el-icon-delete" size="mini"></el-button>
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

    <el-dialog title="添加影厅" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
      <!--内容主题区-->
      <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px">
        <!--prop：在addFormRules中定义校验规则， v-model：双向绑定数据-->
        <el-form-item label="影厅名称" prop="hallCategoryName">
          <el-input v-model="addForm.hallCategoryName"></el-input>
        </el-form-item>
      </el-form>
      <!--底部区域-->
      <span slot="footer" class="dialog-footer">
      <el-button @click="addDialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="addHallCategory">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "hallCategory",
  data() {
    return {
      queryInfo: {
        query: '',
        pageNum: 1,
        pageSize: 7
      },
      hallcategorylist: [],
      total: 0,
      url: 'http://localhost:8181/',
      //控制对话框的显示与隐藏
      addDialogVisible: false,
      //添加影厅的表单数据
      addForm: {
        hallCategoryName: ''
      },
      //验证表单规则对象
      addFormRules: {
        hallCategoryName: [
            { required: true, message: '请输入影厅名', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getHallCategoryList()
  },
  methods: {
    async getHallCategoryList() {
      const _this = this;
      axios.get(_this.url + 'sysHallCategory', {params: _this.queryInfo}).then(resp => {
        console.log(resp)
        _this.hallcategorylist = resp.data.data;
        _this.total = resp.data.total;
        _this.queryInfo.pageSize = resp.data.pageSize;
        _this.queryInfo.pageNum = resp.data.pageNum;
      })
    },
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize
      this.getHallCategoryList()
      console.log(newSize)
    },
    handleCurrentChange(newPage) {
      this.queryInfo.pageNum = newPage
      this.getHallCategoryList()
      console.log(newPage)
    },
    // 监听添加对话框的关闭事件
    addDialogClosed(){
      this.$refs.addFormRef.resetFields()
    },
    // 监听添加按钮
    addHallCategory(){
      const a = this;
      this.$refs.addFormRef.validate(async valid => {
        console.log(valid)
        if (!valid) return
        // alert(a.addForm.hallCategoryName)
        //预校验成功，发网络请求
        axios.defaults.headers.post['Content-Type'] = 'application/json'
        axios.post(this.url + 'sysHallCategory', {hallCategory: a.addForm.hallCategoryName}).then(resp => {
          console.log(resp)
          if (resp.data.code == 200){
            this.$message.success('添加影厅分类成功！')
          }else {
            this.$message.error('添加影厅分类失败！')
          }
        })
        //隐藏添加对话框
        this.addDialogVisible = false
        //重新加载列表
        this.getHallCategoryList()
      })
    }
  }
}
</script>

<style scoped>

.el-card {
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15) !important;
}

.el-table {
  margin-top: 15px;
  font-size: 12px;
}

.el-pagination {
  margin-top: 15px;
}

</style>