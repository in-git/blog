let attr = {
	data() {
		return {
			gameTips:`一开始构思做一个简单的网络对战小游戏，因一些原因放弃了。
			思路:使用websocket通讯，每个用户上线,新建对象，每个对象具备移动攻击的能力，
			键盘按键信息上传到服务端，实现动作同步
			`,
			collapseActive:'2',
			
			activeNames: ['1'],
			activeName: 'first',
			active: 0,
			timeline_2019: [{
					name: 'API管理中心',
					description: '为每个注册用户分配一个唯一API，支持管理员发表文章以及在线聊天和留言',
					href: 'http://134.175.79.33:15006/',
					time: '2019/12',
					tag: ['css', 'jquery', 'springboot', 'mysql']
				},

			],
			timeline_2020: [{
					name: '公司官网',
					description: '纯静态页面，使用Bootstrap开发，由Linux引擎在云端执行,响应式开发，能让用户在多种设备下具有良好的响应效果',
					href: 'http://134.175.79.33:15005/jym/index.html',
					time: '2020/03',
					tag: ['bootstrap']
				},
				{
					name: '仿Bilibili购',
					description: '实现用户登录，权限校验，用户私人空间，表单验证，滚动加载等',
					href: 'http://134.175.79.33:15007',
					time: '2020/05',
					tag: ['springboot', 'jquery', 'bootstrap', 'mybatis']
				},
				{
					name: '权限模板',
					description: '使用自定义的一套开发规范，',
					href: 'http://134.175.79.33:15000/',
					time: '2020/06',
					tag: ['springboot', 'vue', 'mysql']
				},
				
			]
		};
	},

	methods: {
		handleChange(val) {
			// console.log(val);
		},
		handleClick(tab, event) {
			// console.log(tab, event);
		},
		next() {
			if (this.active++ > 2) this.active = 0;
		}
	},

}
export default attr
