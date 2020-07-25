import f from '@/global/utils/commjs.js'
import weblist from '../weblist.vue'
let homeJs = {
	mounted() {
		let remostHost = 'http://134.175.79.33:15005/img/1920x1080/'

		this.$get('/user/message').then(data => {
			data = data.data
			data.motto.forEach((e, i) => {
				this.redis[`motto${i+1}`] = e
			})
			/*
				图片分页处理
			*/
			data.fileList.map((e, i) => {
				this.arrs.push(remostHost + e)
			})
			
			this.arrLength =Math.ceil(this.arrs.length / this.pagesize) 
			this.redis.view = data.view

			this.currentImgPath = data.carousel[0]

			this.redis.notice = data.notice

			this.redis.signal = data.signal
		}).catch(err => {})
	},
	methods: {
		/* 修改密钥 */
		updateSignal() {
			let data = {
				signal: this.redis.signal
			}
			this.$get('/user/setNotice', data).then(data => {
				if (data.sys_status == 20) {
					this.$message("更新成功")
				}

			}).catch(e => {
				this.$message("更新失败")
			})
		},
		/* 更新通知 */
		updateNotice() {
			let data = {
				notice: this.redis.notice
			}
			this.$get('/user/setNotice', data).then(data => {
				if (data.sys_status == 20) {
					this.$message("更新成功")
				}

			}).catch(e => {
				this.$message("更新失败")
			})
		},
		// 修改轮播图
		changeCarousel() {
			let data = {
				url: this.currentImgPath,
				symbol: this.selectCarousel
			}
			this.$get('/user/carouselUpdata', data).then(data => {
				this.$message("修改成功")
				this.carouselPanel = []
			}).catch(err => {
				this.$message("修改失败")
			})
		},
		// 复制图片路径
		copy(url) {
			f.copy(url)
			this.$message("复制成功")
			this.currentImgPath = url;
		},

		/*
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  座右铭修改
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		*/
		updateMotto(symbol, text) {
			let data = {
				text: text
			}
			this.$get("/user/updateMotto/" + symbol, data).then(data => {
				this.$message({
					message: '恭喜你，这是一条成功消息',
					type: 'success'
				});
			}).catch(err => {
				this.$message.error("更新出了错")
			})
		},

		/*
		 -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 			  分页选择
		 -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		primaryPage() {
			this.currentPage = 1;
		},
		prePage() {
			if (this.currentPage == 1) {
				return;
			}
			this.currentPage = this.currentPage - 1;
		},
		nextPage() {
			if (this.currentPage == Math.ceil(this.arrs.length / this.pagesize)) {
				return;
			}
			this.currentPage = this.currentPage + 1;
		},
		lastPage() {
			this.currentPage = Math.ceil(this.arrs.length / this.pagesize);
		},


		// 初始化Github列表
		initGithub() {
			this.$get('/user/githubs').then(data => {
				this.githubs = []
				data.forEach(e => {
					this.githubs.push(e)
				})

			}).catch(err => {
				this.$message({
					message: "出了点错",
					type: 'error'
				})
			})
		},
		/*
		 -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 			  添加Github
		 -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		addGithub() {
			let data = this.github
			this.$get('/user/addGithub', data).then(data => {
				if (data.sys_status == 40) {
					this.$message({
						message: data.sys_msg,
						type: 'success'
					})
				}
				if (data.sys_status == -40) {
					this.$message({
						message: "修改失败",
						type: 'error'
					})
				}
				
				this.githubs.push(data)
				
				for (let i in this.github) {
					this.github[i] = null
				}
				
				this.githubVar.alt = true
			}).catch(err => {
				this.$message({
					message: "修改失败",
					type: 'error'
				})
			})
			
		},
		/* -·-·-·-·-·-
		
		 打开GitHub列表
		 
		 -·-·-·-·-·-*/
		openGithub(item) {
			this.githubVar.alt = false
			this.github = item
		},
		/* -·-·-·-·-·-
		
		 更新GitHub列表
		 
		 -·-·-·-·-·-*/
		updateGithub(){
			
			this.$get('/user/updateGithub',this.github).then(data=>{
				if(data.sys_status == 20){
					this.$message({
						message:'修改成功',
						type:'success'
					})
				}
				else{
					this.$message({
						message:'修改失败',
						type:'error'
					})
				}
				
				this.githubVar.alt = true
			})
		},
		deleteGithub(item) {
				this.$get('/user/deleteGithub/' + item.id).then(data => {
					this.$message({
						message: data.sys_msg,
						type: 'success'
					})
					let index = this.githubs.indexOf(item)
					this.githubs.splice(index, 1)
				})

		},
	},

	data: () => ({
		redis: {
			view: 0,
			motto1: "",
			motto2: "",
			motto3: "",
			notice: '',
			signal: ''
		},

		currentPage: 1, //当前页号
		pagesize: 4, //每页大小
		arrs: [],
		arrLength: 10,
		carouselIndex: [0, 1, 2],
		currentImgPath: '',
		selectCarousel: 0,
		carouselPanel: [],
		tab: 0,

		// Github属性

		githubHeads: [{
				text: 'ID',
				align: 'center',
				value: 'id',
			}, {
				text: 'title',
				align: 'center',
				value: 'title',
			}, {
				text: '图片',
				align: 'center',
				value: 'img',
			}, {
				text: '描述',
				align: 'center',
				value: 'description',
			},
			{
				text: '下载地址',
				value: 'download',
				align: 'center',
			}, {
				text: '克隆地址',
				value: 'address',
				align: 'center',
			},
			{
				text: 'Github地址',
				value: 'url',
				align: 'center',
			},
			{
				text: '操作',
				align: 'center',
				value: 'action'
			}

		],
		githubs: [],
		github: {
			id: null,
			title: null,
			img: null,
			description: null,
			download: null,
			address: null,
			url: null,
			action: null
		},
		githubRules: {
			rules: [
				v => !!v || '不能为空',
				v => (v && v.length > 2) || '长度大于二',
			],
			imgRules: [
				v => !!v || '输入不能为空',
				v => (v && v.length > 8) || '输入合法地址'
			],
			valid: true,
		},
		githubVar: {
			alt: true
		},

	}),
	// 计算属性
	computed: {
		page_arrs() {
			let {
				currentPage,
				pagesize
			} = this;
			// 返回
			return this.arrs.slice(
				(currentPage - 1) * pagesize,
				currentPage * pagesize
			);
		},
		current_page() {
			return this.currentPage;
		}
	},
	components: {
		weblist
	}
}
export default homeJs
