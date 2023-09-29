<template>
  <section id="page-all-music" class="py-5 bg-light">
    <div class="container px-4 px-lg-5 mt-5">
      <h2 class="fw-bolder mb-4">다른 추천 곡</h2>
      <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
        v-if="allMusic.length !== 0">
        <div class="col mb-5" v-for="(music, index) in allMusic" v-bind:key="music.id">
          <div class="card h-100 music-card" @click="clickMusicCard(music)">
            <!-- Badge-->
            <div v-if="index === 0" class="badge bg-success text-white position-absolute"
              style="top: 0.5rem; right: 0.5rem">New
            </div>
            <!-- Music image-->
            <img class="card-img-top" :src="music.imagePath" :alt="music.author + ' - ' + music.title" />
            <!-- Music details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- Music author name-->
                <h5 class="fw-bolder">{{ music.author }} - {{ music.title }}</h5>
                <!-- Music feat-->
                <p v-if="music.feat">(feat. {{ music.feat }})</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'MainCardMusic',
  props: {
  },
  data() {
    return {
      allMusic: []
    }
  },
  mounted() {
    this.$axios.get('/music/all')
      .then(res => {
        this.allMusic = res.data;
      });
  },
  methods: {
    clickMusicCard(music) {
      this.$emit("clickMusicCard", music);
    }
  }
}
</script>

<style scoped>
.music-card:hover {
  box-shadow: 0 1rem 3rem rgba(0, 0, 0, 0.175) !important;
  cursor: pointer;
}
</style>