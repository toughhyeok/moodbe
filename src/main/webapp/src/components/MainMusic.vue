<template>
  <div class="hello">

    <!-- Navigation-->
    <MainNavBar />
    <!-- Product section-->
    <section class="py-5">
      <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
          <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="../static/image/adoy_blanc.jpeg"
              alt="adoy_blanc" /></div>
          <div class="col-md-6">
            <div class="small mb-1">2023.09.19</div>
            <h1 class="display-5 fw-bolder">ADOY - Blanc</h1>
            <div class="fs-5 mb-5">
              <span>(feat. George)</span>
            </div>
            <p class="lead">
              오늘의 노래는 "ADOY"의 "Blanc"에요.
              "You make me drop this way"라는 가사처럼 "Blanc"의 고조되는 비트와 "George"의 목소리에 푹 빠져보는 건 어떨까요?
            </p>
            <div class="d-flex">
              <button class="btn btn-outline-dark flex-shrink-0" type="button">
                <i class="bi-youtube me-1"></i>
                Youtube에서 음악 듣기
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Card Music section-->
    <MainCardMusic />
    <!-- Footer-->
    <MainFooter />
  </div>
</template>

<script>
import MainNavBar from './MainNavBar.vue';
import MainFooter from './MainFooter.vue';
import MainCardMusic from './MainCardMusic.vue';

export default {
  name: 'MainMusic',
  components: {
    MainNavBar,
    MainCardMusic,
    MainFooter,
  },
  props: {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
