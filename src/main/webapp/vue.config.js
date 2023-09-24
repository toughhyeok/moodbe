const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../resources/static',
  devServer: {
    proxy: 'http://localhost:8080'
  }
})
