let attr = {
	methods: {
		// 进度条
		format(percentage) {
			return percentage === 100 ? '满' : `${percentage}%`;
		},
		handleClick(tab, event) {
			if (tab.name == 'third') {
				this.$bvModal.show('confirm')
			}
		},
		back() {
			window.location.reload()
		},
		onOpen() {
			this.$refs.popover.$emit('open')
		},
		confirm() {
			let data = {
				symbol: this.symbol
			}
			this.$get('/resume/signal', data).then(data => {

				if (data.sys_status == 10) {
					this.$message({
						showClose: true,
						message: '暗号正确',
						type: 'success'
					});
					this.$bvModal.hide('confirm')
					this.workShow = false
				} else {
					this.$message({
						showClose: true,
						message: '暗号好像不对呢',
						type: 'error'
					});
				}

			}).catch(err => {
				this.$bvToast.toast("出了不可预料的错误", {
					title: data.sys_msg,
					autoHideDelay: 5000,
				})
			})
		}
	},

	data() {
		return {
			spares: [{
					tags: ['Dokcer', '阿里云', 'Nodejs', 'MybatisPlus', '网页备案']
				},
				{
					tags: ['计算机网络', '计算机组成原理', '51单片机']
				},
				{
					tags: ['PhotoShop', 'UI设计']
				},
				{
					tags: ['Nodejs', 'C#', 'Python', 'C']
				},
			],
			activities: [{
					content: '完成单体应用架构简单规范，整合-引导式风格-，极大提高项目稳定性，加强运维安全',
					timestamp: '2019-07',
				},
				{
					content: '完成Vue,Redis,Nginx应用层学习，开始进阶JVM原理层,作品:仿哔哩哔哩购',
					timestamp: '2020-05',
				},
				{
					content: '完成,JS,CSS,Bootstrap进阶学习,对应作品：公司官网',
					timestamp: '2020-03',
				}, {
					content: '完成SPRINGBOOT,Mysql,Mybatis应用层学习,对应作品API管理中心',
					timestamp: '2019-12'
				}, {
					content: '零基础开启Java之旅',
					timestamp: '2019-10'
				}
			],
			symbol: "",
			workShow: true,
			activeName: 'first',
			skills: [{
					subject: [{
							subtitle: '基础',
							tagName: ['数据结构', "设计模式", "JVM", "集合框架"],
						},
						{
							subtitle: '框架',
							tagName: ['SpringBoot', "Spring", "Mybatis", "AOP", "Shiro"],
						},
					],
					language: 'JAVA',
					assessment: `了解常用数据结构:链表，栈等;了解常用设计模式:工厂模式，单例等;了解常用集合：ArrayList等`,
					percent: 40
				},
				{
					subject: [{
							subtitle: '基础',
							tagName: ['HTML', "JAVASCRIPT", "CSS", 'ES6'],
						},
						{
							subtitle: '框架',
							tagName: ['Vue', "Bootstrap", "Vuetify", "Jquery"],
						},

					],
					language: '前端',
					assessment: `动手写代码较多，理论与实际结合，学完用，用完学。擅长响应式开发	,能动手设计UI界面以及美工`,
					percent: 40
				},
				{
					language: '数据运维',
					subject: [{
						subtitle: '基础',
						tagName: ['Mysql', "Linux", "Nginx", 'Tomcat', "Redis"],
					}, ],
					assessment: `熟悉TOMCAT项目部署，熟悉MYSQL基本CURD,能避免索引失效，熟悉Linux基本操作，了解Redis基本用法，了解Nginx基本用法`,
					percent: 20
				},
			]
		};
	}

}
export default attr
