import Vue from 'vue'
import DbMeta from 'db-metadata'
import ElementUI from 'element-ui'

import App from './App.vue'
import router from './router'

import DbMetaConf from './dbmeta.config'

// css
import 'element-ui/lib/theme-chalk/index.css'
import 'db-metadata/lib/db-metadata.css'

Vue.use(ElementUI)

Vue.use(DbMeta, DbMetaConf)
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
