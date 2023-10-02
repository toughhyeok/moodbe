<template>
  <div class="container">
    <div class="py-4 text-center">
      <h2>새로운 음악 등록</h2>
    </div>
    <div class="row justify-content-md-center">
      <div class="col col-lg-8">
        <h4 class="mb-3">이미지 다운로드</h4>
        <b-form>
          <div class="mb-3">
            <b-form-group id="input-group-0" label="Youtube URL" label-for="input-0">
              <b-form-input id="input-0" v-model="youtubeUrl" type="url" placeholder="https://youtube.com/watch?v=*"
                required></b-form-input>
            </b-form-group>
          </div>
          <div class="mb-3">
            <p><a target="_blank" :href="imageDownloadLink">{{ imageDownloadLink }}</a></p>
          </div>
          <button class="btn btn-dark btn-block" type="button" @click="createImageDownloadUrl">링크 생성</button>
        </b-form>
        <hr class="mb-3">
      </div>
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
            <b-form-group id="input-group-3" label-for="input-3">
              <label for="input-3">이미지 파일 <span class="text-muted">(<b-icon icon="exclamation-circle-fill"></b-icon> 파일 이름
                  예시: japanese-breakfast-soft-sounds-from-another-planet.jpeg)</span></label>
              <b-form-file id="input-3" :state="Boolean(form.file)" v-model="form.file" placeholder="파일을 선택하거나 여기에 드롭하세요."
                drop-placeholder="파일을 여기에 드롭하세요." required></b-form-file>
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
              <b-form-textarea id="input-6" rows="3" v-model="form.content" type="text" required>
              </b-form-textarea>
            </b-form-group>
          </div>

          <button class="mb-5 btn btn-dark btn-block" type="submit">저장</button>
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
  watch: {
    youtubeUrl() {
      if (this.youtubeUrl === '') this.imageDownloadLink = '';
    }
  },
  data() {
    return {
      youtubeUrl: '',
      imageDownloadLink: '',
      form: {
        author: '',
        title: '',
        file: null,
        youtubeUrl: '',
        feat: '',
        content: ''
      }
    }
  },
  methods: {
    initForm() {
      this.youtubeUrl = '';
      this.form.author = '';
      this.form.title = '';
      this.form.file = null;
      this.form.youtubeUrl = '';
      this.form.feat = '';
      this.form.content = '';
    },
    onSubmit(event) {
      event.preventDefault()
      this.$axios.post('/music/register', this.form, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
        .then(res => {
          alert(`${res.data.author} - ${res.data.title} 등록 성공!`)
          this.initForm();
        })
        .catch(err => {
          if (err.response.data.message) alert(err.response.data.message);
          else alert(err.message);
        });
    },
    createImageDownloadUrl() {
      const videoId = this.youtubeUrl.split('v=')[1];
      if (!videoId) {
        alert('Invalid Youtube URL!')
        this.imageDownloadLink = '';
        return;
      }
      this.imageDownloadLink = `https://i1.ytimg.com/vi/${videoId}/sddefault.jpg`;
    }
  }
}
</script>
