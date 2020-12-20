<template>
  <!-- 一部电影 -->
  <div class="movie-item">
    <div v-on:mouseover="isHover = true" v-on:mouseleave="isHover = false">
      <!-- 海报 -->
      <a href="/movieInfo">
        <img class="poster" src="https://p0.meituan.net/movie/df84690ded848edf709187eae23a7969866455.jpg@464w_644h_1e_1c">
      </a>
      <!-- 鼠标划过时的效果 -->
      <div class="movie-item-hover" v-if="isHover">
        <!-- 海报 -->
        <a href="/movieInfo">
          <img class="poster-hover" src="https://p0.meituan.net/movie/df84690ded848edf709187eae23a7969866455.jpg@464w_644h_1e_1c">
          <!-- 鼠标划过时显示的信息 -->
          <div class="movie-hover-info">
            <div class="title-hover">
              <span class="name-tags">送你一朵小红花</span>
            </div>
            <div class="title-hover">
              <span class="name-tags">类型: </span>剧情/爱情/纪录片
            </div>
            <div class="title-hover">
              <span class="name-tags">主演: </span>易烊千玺/王源/王一博
            </div>
            <div class="title-hover">
              <span class="name-tags">上映时间: </span>2020/12/19
            </div>
          </div>
        </a>
      </div>
    </div>
    <!-- 标题 -->
    <div class="title-style">
      <a href="/movieInfo">送你一朵小红花</a>
    </div>
    <!-- 评分 -->
    <div class="title-style score">
      9.5
    </div>
  </div>
</template>

<script>
export default {
  name: "movie-item",
  data() {
    return {
      isHover: false
    }
  }
}
</script>

<style scoped>
.movie-item{
  margin-top: 30px;
  margin-left: 30px;
  display: inline-block;
  vertical-align: top;
  position: relative;
}

.poster{
  width: 160px;
  height: 220px;
}

.title-style{
  width: 160px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  text-align: center;
  font-size: 16px;
  color: #333;
  margin-top: 10px;
}

.score{
  color: #ffb400;
  font-size: 24px;
  font-style: italic;
}

a{
  text-decoration: none;
  color: #333;
}

.movie-item-hover{
  position: absolute;
  width: 218px;
  height: 300px;
  z-index: 10;
  top: -40px;
  left: -29px;
  overflow: hidden;
  background: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
}

.poster-hover{
  width: 218px;
  height: 300px;
}

.movie-hover-info{
  padding: 16px;
  height: 150px;
  box-sizing: border-box;
  position: absolute;
  z-index: 11;
  top: 150px;
  background: #fff;
  width: 218px;
  color: #999;
}

.title-hover:first-child{
  font-size: 20px;
  line-height: 20px;
  margin-top: 6px;
}

.title-hover{
  font-size: 16px;
  line-height: 16px;
  margin-top: 12px;
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.name-tags{
  color: #333;
}
</style>