<template>
  <div class="container">
    <div class="py-5 text-center">
      <h2>새로운 음악 등록</h2>
    </div>
    <div class="row justify-content-md-center">
      <div class="col col-lg-8">
        <h4 class="mb-3">음악 정보</h4>
        <b-form @submit="onSubmit">
          <div class="row mb-3">
            <div class="col-md-6 md-3">
              <b-form-group id="input-group-1" label="가수" label-for="input-1">
                <b-form-input id="input-1" v-model="form.author" type="text" required></b-form-input>
              </b-form-group>
            </div>
            <div class="col-md-6 md-3">
              <b-form-group id="input-group-2" label="제목" label-for="input-2">
                <b-form-input id="input-2" v-model="form.title" type="text" required></b-form-input>
              </b-form-group>
            </div>
          </div>

          <div class="mb-3">
            <b-form-group id="input-group-3" label="이미지 URL" label-for="input-3">
              <b-form-input id="input-3" v-model="form.imagePath" type="url"
                placeholder="https://moodbe-storage-2023.s3.ap-northeast-2.amazonaws.com/*" required></b-form-input>
            </b-form-group>
          </div>

          <div class="mb-3">
            <b-form-group id="input-group-4" label="Youtube URL" label-for="input-4">
              <b-form-input id="input-4" v-model="form.youtubeUrl" type="url" placeholder="https://youtube.com/watch?v=*"
                required></b-form-input>
            </b-form-group>
          </div>

          <div class="mb-3">
            <b-form-group id="input-group-5" label-for="input-5">
              <label for="input-5">Feat. <span class="text-muted">(선택)</span></label>
              <b-form-input id="input-5" v-model="form.feat" type="text">
              </b-form-input>
            </b-form-group>
          </div>

          <div class="mb-3">
            <b-form-group id="input-group-6" label="노래 설명" label-for="input-6">
              <b-form-textarea id="input-6" rows="5" v-model="form.content" type="text" required>
              </b-form-textarea>
            </b-form-group>
          </div>

          <button class="btn btn-dark btn-block" type="submit">저장</button>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MusicRegistration',
  props: {
  },
  data() {
    return {
      form: {
        author: '',
        title: '',
        imagePath: '',
        youtubeUrl: '',
        feat: '',
        content: ''
      }
    }
  },
  methods: {
    initForm() {
      this.form.author = '';
      this.form.title = '';
      this.form.imagePath = '';
      this.form.youtubeUrl = '';
      this.form.feat = '';
      this.form.content = '';
    },
    onSubmit(event) {
      event.preventDefault()
      this.$axios.post('/music/register', this.form)
        .then(res => {
          alert(`${res.data.author} - ${res.data.title} 등록 성공!`)
          this.initForm();
        })
        .catch(err => {
          alert(err.message)
        });
    },
  }
}
</script>
