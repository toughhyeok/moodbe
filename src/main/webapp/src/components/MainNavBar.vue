<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
      <a class="navbar-brand" href="/"><img src="../assets/moodbe-logo.png" alt="moodbe-logo">&nbsp;Moodbe</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
          class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
          <li class="nav-item"><div class="nav-link inactive">About</div></li>
          <li class="nav-item active"><a class="nav-link active" style="cursor: pointer;"
              @click="onClickAllMusic">Music</a></li>
        </ul>
        <form class="d-flex">
          <button class="btn btn-outline-dark" type="submit" disabled>
            <i class="bi-person-fill me-1"></i>
            로그인
            <!-- # TODO for reply noti -->
            <!-- <span class="badge bg-dark text-white ms-1 rounded-pill">0</span> -->
          </button>
        </form>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'MainNavBar',
  props: {
  },
  methods: {
    onClickAllMusic() {
      this.$emit("onClickAllMusic");
    }
  }
}
</script>

<style scoped></style>