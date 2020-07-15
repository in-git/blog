import Vue from 'vue'
import App from './App.vue'
import router from './router/index.js'

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)	
// import vuetify from './plugins/vuetify';
// import 'vuetify/dist/vuetify.min.css'
/* ------ *-*-*-*-*-* ------ */
/* ------- ElementUI ------- */
/* ------ *-*-*-*-*-* ------ */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'element-ui/lib/theme-chalk/display.css';
Vue.use(ElementUI);



/* ------ *-*-*-*-*-* ------ */
/* ------- Axios依赖 ------- */
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

Vue.config.productionTip = false


/* ------ *-*-*-*-*-* ------ */
/* ---------- Vue ---------- */
/* ------ *-*-*-*-*-* ------ */
new Vue({
	router,
	// vuetify,
	render: h => h(App)
}).$mount('#app')
