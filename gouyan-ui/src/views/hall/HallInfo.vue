<template>
  <div>
    <!--面包屑导航区域-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/welcome' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>影厅管理</el-breadcrumb-item>
      <el-breadcrumb-item>影厅信息</el-breadcrumb-item>
    </el-breadcrumb>

    <!--卡片视图-->
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="4">
          <el-select v-model="selectedCinemaId" placeholder="请选择影院名称" clearable >
            <el-option
                v-for="item in cinemaList"
                :key="item.cinemaId"
                :label="item.cinemaName"
                :value="item.cinemaId">
            </el-option>
          </el-select>
        </el-col>
        <el-col :span="4">
          <el-select v-model="selectedHallCategoryId" placeholder="请选择影厅分类" clearable>
            <el-option
                v-for="item in hallCategoryList"
                :key="item.hallCategoryId"
                :label="item.hallCategoryName"
                :value="item.hallCategoryId">
            </el-option>
          </el-select>
        </el-col>
        <el-col :span="4">
          <el-select v-model="selectedHallState" placeholder="请选择影厅状态" clearable>
            <el-option v-for="item in states" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </el-col>
        <el-col :span="1.5">
          <el-button icon="el-icon-search" @click="getHallList"></el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="primary" @click="addDialogVisible = true">添加影厅</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="danger" @click="multipleDelete">批量删除</el-button>
        </el-col>
      </el-row>

      <!--影厅分类列表-->
      <el-table :data="hallList" style="width: 100%" border stripe @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="sysCinema.cinemaName" label="影院名称"></el-table-column>
        <el-table-column prop="hallName" label="影厅名称"></el-table-column>
        <el-table-column prop="sysHallCategory.hallCategoryName" label="影厅分类"></el-table-column>
        <el-table-column prop="rowStart" label="起始行"></el-table-column>
        <el-table-column prop="rowNums" label="行数"></el-table-column>
        <el-table-column prop="seatNumsRow" label="行座位数"></el-table-column>
        <el-table-column prop="hallState" label="影厅状态">
          <template slot-scope="scope">
            <el-switch v-model="scope.row.hallState" @change="hallStateChanged(scope.row)"></el-switch>
          </template>
        </el-table-column>
        <!--是否启用-->

        <el-table-column label="操作" width="180">
          <template slot-scope="scope">
            <el-tooltip effect="dark" content="修改影厅信息" placement="top" :enterable="false" :open-delay="500">
              <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.cinemaId, scope.row.hallId)"></el-button>
            </el-tooltip>
            <el-tooltip effect="dark" content="删除影厅" placement="top" :enterable="false" :open-delay="500">
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteHallById(scope.row.cinemaId, scope.row.hallId)"></el-button>
            </el-tooltip>
            <el-tooltip effect="dark" content="安排座位" placement="top" :enterable="false" :open-delay="500">
              <el-button type="warning" icon="el-icon-setting" size="mini" @click="arrangeSeat(scope.row.cinemaId, scope.row.hallId)"></el-button>
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

    <!--添加影厅对话框-->
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

    <!--修改影厅对话框-->
    <el-dialog title="修改影厅" :visible.sync="editDialogVisible" width="50%" @close="editDialogClosed">
      <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="100px">
        <el-form-item label="影厅编号">
          <el-input v-model="editForm.hallCategoryId" disabled></el-input>
        </el-form-item>
        <el-form-item label="影厅名称" prop="hallCategoryName">
          <el-input v-model="editForm.hallCategoryName"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="editHallCategoryInfo">确 定</el-button>
      </span>
    </el-dialog>


  </div>
</template>

<script>
import global from "@/assets/css/global.css"
export default {
  name: "HallInfo",
  data() {
    return {
      queryInfo: {
        cinemaId: '',
        hallCategoryId: '',
        hallState: '',
        pageNum: 1,
        pageSize: 7
      },
      hallList: [],
      total: 0,
      url: 'http://localhost:8181/',
      //控制对话框的显示与隐藏
      addDialogVisible: false,
      //添加影厅的表单数据
      addForm: {
        cinemaId: '',
        hallId: '',
        hallName: '',
        hallCategoryId: '',
        rowNums: '',
        seatNumsRow: '',
        seatNums: '',
        seatState: '',
        hallState: ''
      },
      //验证表单规则对象
      addFormRules: {
        cinemaId: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallId: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallName: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallCategoryId: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        rowNums: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        seatNumsRow: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallState: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
      },
      editDialogVisible: false,
      editForm: {},
      editFormRules: {
        cinemaId: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallId: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallName: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallCategoryId: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        rowNums: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        seatNumsRow: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
        hallState: [
          { required: true, message: '请输入影厅名', trigger: 'blur' }
        ],
      },
      selectedCinemaId: '',
      selectedHallCategoryId: '',
      selectedHallState: '',
      cinemaList: [],
      hallCategoryList: [],
      states: [
        {
          id: 0,
          name: '未启用'
        },
        {
          id: 1,
          name: '已启用'
        }
      ],
      multipleSelection: []
    }
  },
  created() {
    this.getHallList()
    this.getCinemaList()
    this.getHallCategoryList()
  },
  methods: {
    getHallList() {
      this.queryInfo.cinemaId = this.selectedCinemaId
      this.queryInfo.hallCategoryId = this.selectedHallCategoryId
      this.queryInfo.hallState = this.selectedHallState
      const _this = this;
      axios.get(_this.url + 'sysHall', {params: _this.queryInfo}).then(resp => {
        console.log(resp)
        _this.hallList = resp.data.data;
        _this.total = resp.data.total;
        _this.queryInfo.pageSize = resp.data.pageSize;
        _this.queryInfo.pageNum = resp.data.pageNum;
      })
    },
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize
      this.getHallList()
      console.log(newSize)
    },
    handleCurrentChange(newPage) {
      this.queryInfo.pageNum = newPage
      this.getHallList()
      console.log(newPage)
    },
    // 监听添加对话框的关闭事件
    addDialogClosed(){
      this.$refs.addFormRef.resetFields()
    },
    // 监听添加按钮
    addHallCategory(){
      const _this = this;
      this.$refs.addFormRef.validate(async valid => {
        console.log(valid)
        if (!valid) return
        //预校验成功，发网络请求
        axios.defaults.headers.post['Content-Type'] = 'application/json'
        await axios.post(_this.url + 'sysHallCategory', JSON.stringify(_this.addForm)).then(resp => {
          console.log(resp)
          if (resp.data.code !== 200){
            this.$message.error('添加影厅分类失败！')
          }
        })
        //隐藏添加对话框
        this.addDialogVisible = false
        //重新加载列表
        this.getHallCategoryList()
        this.$message.success('添加影厅分类成功！')
      })
    },
    // 显示修改对话框，回显数据
    showEditDialog(id){
      const _this = this
      axios.get(_this.url + 'sysHallCategory/' + id ).then(resp => {
        console.log(resp)
        _this.editForm = resp.data.data
      })
      this.editDialogVisible = true
    },
    // 监听修改对话框的关闭事件
    editDialogClosed(){
      this.$refs.editFormRef.resetFields()
    },
    // 修改影厅分类信息并提交
    editHallCategoryInfo(){
      this.$refs.editFormRef.validate(async valid => {
        const _this = this
        if (!valid) return
        axios.defaults.headers.put['Content-Type'] = 'application/json'
        await axios.put(_this.url + '/sysHallCategory', JSON.stringify(_this.editForm)).then(resp => {
          if (resp.data.code !== 200){
            this.$message.error('修改影厅分类失败！')
          }
        })
        this.editDialogVisible = false
        this.getHallCategoryList()
        this.$message.success('修改影厅分类成功！')
      })
    },
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
        let item = {
          cinemaId: data.cinemaId,
          hallId: data.hallId
        }
        ids.push(item)
      })
      console.log(ids)
      axios.defaults.headers.post['Content-Type'] = 'application/json'
      await axios.post(_this.url + 'sysHall/delete', JSON.stringify(ids)).then(resp => {
        if (resp.data.code !== 200){
          this.$message.success('批量删除影厅分类失败！')
        }
      })
      this.getHallList()
      this.$message.success('批量删除影厅分类成功！')
    },
    //根据id删除对应的影厅分类
    async deleteHallById(id1, id2){
      let deleteInfo = [{
        cinemaId: id1,
        hallId: id2
      }]
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

      console.log(deleteInfo)
      axios.defaults.headers.post['Content-Type'] = 'application/json'
      await axios.post(_this.url + 'sysHall/delete', JSON.stringify(deleteInfo)).then(resp => {
        if (resp.data.code !== 200){
          _this.$message.success('删除影厅信息失败！')
        }
      })
      this.getHallList()
      this.$message.success('删除影厅信息成功！')
    },
    getCinemaList(){
      const _this = this;
      axios.get(_this.url + 'sysCinema').then(resp => {
        console.log(resp)
        _this.cinemaList = resp.data.data;
      })
    },
    getHallCategoryList(){
      const _this = this;
      axios.get(_this.url + 'sysHallCategory').then(resp => {
        console.log(resp)
        _this.hallCategoryList = resp.data.data;
      })
    },
    async hallStateChanged(hallInfo){
      const _this = this
      axios.defaults.headers.put['Content-Type'] = 'application/json'
      await axios.put(_this.url + '/sysHall', JSON.stringify(hallInfo)).then(resp => {
        if (resp.data.code !== 200){
          _this.$message.error('更新影厅状态失败！')
        }
      })
      this.getHallList()
      this.$message.success('更新影厅状态成功！')
    }
  }
}
</script>

<style scoped>

</style>