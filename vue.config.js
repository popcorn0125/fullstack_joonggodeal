const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  // build 경로 설정
  // outputDir: "../todomypet_backend/src/main/resources/static",
  devServer: {
    // 프록시 설정
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/memberLogin': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/adminpost': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/adminlogin': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/adminproduct': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/adminnotice': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/productcategory': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      
    }
  }
})
