import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';

/* ------ *-*-*-*-*-* ------ */
/* ------- Axios依赖
/* ------ *-*-*-*-*-* ------ */
import {
	post,
	get,
	patch,
	put
} from '@/global/utils/http.js'
Vue.prototype.$post = post;
Vue.prototype.$get = get;
Vue.prototype.$patch = patch;
Vue.prototype.$put = put;

/* ------ *-*-*-*-*-* ------ */
/* ------- ElementUI 
/* ------ *-*-*-*-*-* ------ */

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'element-ui/lib/theme-chalk/display.css';
Vue.use(ElementUI);


/* ------ *-*-*-*-*-* ------ */
/* ---------- Vue ---------- */
/* ------ *-*-*-*-*-* ------ */
new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')

Vue.config.productionTip = false