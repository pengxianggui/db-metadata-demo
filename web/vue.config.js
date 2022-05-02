let path = require('path')
module.exports = {
    publicPath: '/',
    outputDir: 'dist',
    assetsDir: 'static',
    indexPath: 'index.html',
    runtimeCompiler: true,

    devServer: {
        host: '0.0.0.0',
        port: '8080',
        https: false,
        open: true,
        overlay: {
            warnings: false,
            errors: true
        },
        sockHost: 'localhost',
        proxy: {
            [process.env.VUE_APP_BASE_API]: {
                target: process.env.VUE_APP_PROXY_URL,
                pathRewrite: {'^/api': ''},
                changeOrigin: true
            }
        }
    },
    // chainWebpack: config => {
    //     config.plugin('html')
    //         .tap(args => {
    //             args[0].favicon = path.resolve('public/logo.png');
    //             return args
    //         })
    // }
}
