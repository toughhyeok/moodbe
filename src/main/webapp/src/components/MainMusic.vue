<template>
  <div class="hello">

    <!-- Navigation-->
    <MainNavBar ref="mainNavBar" @onClickAllMusic="scrollTo('mainCardMusic')" />
    <!-- Product section-->
    <section class="py-5" v-if="latestMusic.id">
      <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
          <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" :src=latestMusic.imagePath />
          </div>
          <div class="col-md-6">
            <div class="small mb-1">{{ dateFormat(latestMusic.modifiedDate) }}</div>
            <h1 class="display-5 fw-bolder">{{ latestMusic.author }} - {{ latestMusic.title }}</h1>
            <div class="fs-5 mb-5" v-if="latestMusic.feat">
              <span>(feat. {{ latestMusic.feat }})</span>
            </div>
            <p class="lead">{{ latestMusic.content }}</p>
            <div class="d-flex">
              <a :href="latestMusic.youtubeUrl" target="_blank"><button class="btn btn-outline-dark flex-shrink-0"
                  type="button">
                  <i class="bi-youtube me-1"></i>
                  Youtube에서 음악 듣기
                </button>
              </a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Card Music section-->
    <MainCardMusic ref="mainCardMusic" @clickMusicCard="setMusicToMain" />
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
  },
  data: function () {
    return {
      latestMusic: {
        id: null,
        createdDate: '',
        modifiedDate: '',
        title: '',
        content: '',
        author: '',
        feat: '',
        imagePath: '',
        youtubeUrl: ''
      }
    }
  },
  mounted() {
    this.$axios.get('/music/latest')
      .then(res => {
        this.latestMusic = res.data;
      });
  },
  methods: {
    dateFormat(datetime) {
      return datetime.split('T')[0];
    },
    setMusicToMain(music) {
      this.latestMusic = music;
      this.scrollTo('mainNavBar')
    },
    scrollTo(refName) {
      this.$refs[refName].$el.scrollIntoView({ behavior: 'smooth' });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
[v-cloak] {
  display: none;
}
</style>
