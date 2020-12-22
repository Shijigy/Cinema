<template>
  <div>
    <el-carousel :height="carouselHeight">
      <el-carousel-item v-for="item in posterList" :key="item.url">
        <img :src="item.url" alt/>
      </el-carousel-item>
    </el-carousel>
    <div class="whole">
      <div class="left">
        <div class="panel">
          <div class="panel-header">
            <h2>正在热映</h2>
            <a href="#">全部</a>
          </div>
          <div class="panel-content">
            <movie-item :movieItem="item" v-for="(item, index) in ongoingMovieList" :key="index"></movie-item>
          </div>
        </div>
        <div class="panel">
          <div class="panel-header">
            <h2>即将上映</h2>
            <a href="#">全部</a>
          </div>
          <div class="panel-content">
            <div class="panel-content">
              <movie-item :movieItem="item" v-for="(item,index) in upcomingMovieList" :key="index"></movie-item>
            </div>
          </div>
        </div>
        <div class="panel">
          <div class="panel-header">
            <h2>经典影片</h2>
            <a href="#">全部</a>
          </div>
          <div class="panel-content">
            <div class="panel-content">
              <movie-item :movieItem="item" v-for="(item,index) in classicMovieList" :key="index"></movie-item>
            </div>
          </div>
        </div>
      </div>
      <div class="right">

      </div>
    </div>
  </div>
</template>

<script>
import movieItem from '../../components/movie/movie-item'
import moment from "moment";
export default {
  name: "Home",
  components: {
    movieItem
  },
  data() {
    return {
      queryInfo1: {
        total: 0,
        pageSize: 10,
        pageNum: 1,
        startDate: moment().subtract(30, "days").format("YYYY-MM-DD"),
        endDate: moment().format('YYYY-MM-DD'),
      },
      queryInfo2: {
        total: 0,
        pageSize: 10,
        pageNum: 1,
        startDate: moment().format('YYYY-MM-DD'),
      },
      queryInfo3: {
        total: 0,
        pageSize: 10,
        pageNum: 1,
      },
      posterList: [
        {url: require('../../assets/carousel1.jpg')},
        {url: require('../../assets/carousel2.jpg')},
        {url: require('../../assets/carousel3.jpg')},
        {url: require('../../assets/carousel4.jpg')}
      ],
      ongoingMovieList: [],
      upcomingMovieList: [],
      classicMovieList: [],
      carouselHeight: ''
    }
  },
  created() {
    this.getOngoingMovieList()
    this.getUpcomingMovieList()
    this.getClassicMovieList()
    this.getHeight()
  },
  methods:{
    async getOngoingMovieList(){
      const { data : res } = await axios.get('sysMovie', {params: this.queryInfo1})
      this.ongoingMovieList = res.data
      this.total = res.total
    },
    async getUpcomingMovieList() {
      const {data: res} = await axios.get('sysMovie', {params: this.queryInfo2})
      this.upcomingMovieList = res.data
      this.total = res.total
    },
    async getClassicMovieList(){
      const { data : res } = await axios.get('sysMovie', {params: this.queryInfo3})
      this.classicMovieList = res.data
      this.total = res.total
    },
    getHeight(){
      let clientWidth =   `${document.documentElement.clientWidth}`
      clientWidth *= 0.8
      this.carouselHeight = clientWidth / 1700 * 520 + 'px'

    }
  }
}
</script>

<style scoped>

.el-carousel {
  width: 80%;
  margin: 30px auto;
}

.el-carousel__item > img {
  width: 100%;
  height: auto;
}

.whole{
  width: 80%;
  margin: 30px auto;
  display: flex;
}

.left{
  width: 60%;
}

.right{
  width: 40%;
  background-color: lightpink;
}

h2{
  font-size: 26px;
}

.panel-header > a{
  text-align: center;
  text-decoration: none;
  color: #999;
  padding-right: 14px;
  background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAOCAYAAAASVl2WAAAABmJLR0QA/wD/AP+gvaeTAAAAv0lEQVQY013RTUpDQRAE4G8eghcR8ScgKCIugpJFjuIjqAvBc7jxj0muEnCjiIQQJOImB3GnbnpkfL1qpqqrunpSzvkDPxjhGdq2VarBF3q4wRHknP8RzvCEQzzguCalaHZwiwHecY6XogCf8TjFHh7Rh9Tx3AylIZa4TgWpSBuY4BSrYlFXKsr4bjrTW5HkJJa9SBW4jbtukmKxG5MDLOKqfzEPcB9LzQN8LSdfwxj7eMMlZvV/NFiPzFddEH4Bt5Y1mf3fnDwAAAAASUVORK5CYII=) no-repeat 100%
}


.panel-header{
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-right: 20px;
}


</style>