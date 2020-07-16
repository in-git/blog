import f from '@/global/utils/commjs.js'
let attr = {
	methods: {
		push(url, index) {
			this.sidebarActive = index
			f.push(url, this)
		}
	},
	data() {
		return {
			/* 
				 * - * - * - * - - * - * - * - * - - * - * - * - * - - * - * - * - * -
										  左侧导航列表 
				* - * - * - * - - * - * - * - * - - * - * - * - * - - * - * - * - * -
			 */
			sidebarActive: 0,
			sidebarClass: 'list-group-item my-index-side-nav border-0 rounded-30  my-3 my-bgcolor d-flex mx-4  justify-content-around',
			sidebar: [{
					id: 1,
					title: '主页',
					href: '/home/main'
				},
				{
					id: 2,
					title: '作品',
					href: '/home/works'
				},

				{
					id: 3,
					title: '关于我',
					href: '/home/resume'
				},
				{
					id: 4,
					title: '关于本页',
					href: '/home/website'
				},
			],
			jumbotronShow: false,
		}
	},

}
export default attr
