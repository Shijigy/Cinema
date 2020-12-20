<template>
  <div class="movie-list">
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
    <movie-item></movie-item>
  </div>
</template>

<script>
import movieItem from '../../components/movie/movie-item'
export default {
  name: "MovieOngoing",
  components:{
    movieItem
  },
  data(){
    return{

    }
  },
  created() {
  }
}
</script>

<style scoped>
.movie-list{
  display: flex;
  flex-wrap: wrap;
}
</style>