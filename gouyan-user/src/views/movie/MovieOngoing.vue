<template>
  <div class="movie-list">
    <movie-item :movieItem="item" v-for="item in movieList" :key="item.movieId"></movie-item>
  </div>
</template>

<script>
import movieItem from '../../components/movie/movie-item'
import moment from 'moment'
export default {
  name: "MovieOngoing",
  components:{
    movieItem
  },
  props:{
    movieCategoryId: Number,
    movieAreaId: Number,
    movieAgeId: Number,
    orderByColumn: String
  },
  data(){
    return{
      pageSize: 30,
      pageNum: 1,
      startDate: moment().subtract(30, "days").format("YYYY-MM-DD"),
      endDate: moment().format('YYYY-MM-DD'),
      movieList: []
    }
  },
  computed: {
    listenChange () {
      const {movieCategoryId, movieAreaId, movieAgeId, orderByColumn} = this
      return {movieCategoryId, movieAreaId, movieAgeId, orderByColumn}
    }
  },
  created() {
    this.getMovieList()
  },
  watch:{
    listenChange(){
      this.getMovieList()
    }
  },
  methods: {
    async getMovieList(){
      let queryInfo = {
        movieCategoryId: this.movieCategoryId,
        movieAgeId: this.movieAgeId,
        movieAreaId: this.movieAreaId,
        orderByColumn: this.orderByColumn,
        pageSize: this.pageSize,
        pageNum: this.pageNum,
        startDate: this.startDate,
        endDate: this.endDate
      }
      const { data : res } = await axios.get('sysMovie', {params: queryInfo})
      this.movieList = res.data
    }
  }
}
</script>

<style scoped>
.movie-list{
  display: flex;
  flex-wrap: wrap;
}
</style>