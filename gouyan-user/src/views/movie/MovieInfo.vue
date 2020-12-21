<template>
  <div>
    这里是电影详情页面，电影id为: {{this.$route.params.movieId}}
  </div>
</template>

<script>
import movieItem from './../../components/movie/movie-item';
export default {
  name: "MovieInfo",
  components:{
    movieItem
  },
  data() {
    return {

    }
  },
  created(){
  }
}
</script>

<style scoped>

</style>