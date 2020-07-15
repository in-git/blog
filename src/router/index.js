import Vue from 'vue'
import VueRouter from 'vue-router'
import {
	MessageBox
} from 'element-ui';

Vue.use(VueRouter)

const routes = [{
		redirect: {
			name: 'main'
		},
		path: '/'
	},
	{
		path: '/home',
		name: 'home',
		component: () => import('@/module/index/home.vue'),
		children: [{
				redirect: '/home/main',
				path: '/home'
			}, {
				path: 'main',
				name: 'main',
				component: () => import('@/module/index/main/main.vue'),
			}, {
				path: 'works',
				name: 'works',
				component: () => import('@/module/index/works/works.vue'),
			},
			{
				path: 'resume',
				name: 'resume',
				component: () => import('@/module/index/resume/resume.vue'),
			},
		]
	},

]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

export default router
