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
            ['/api']: {
                target: 'http://localhost:8888',
                pathRewrite: {'^/api': ''},
                changeOrigin: true
            }
        }
    },
}
