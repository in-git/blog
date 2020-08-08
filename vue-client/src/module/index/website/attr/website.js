let attr = {
	data() {
		return {
			view:0,
			maker: ['UI设计', '前端', '后台', '运维', '美工'],
			// 评分
			star: 0,
			isStar: false,
			activeTab: 'struct',

			// 留言面板开关
			messageBorderShow: true,
			messages: [],
			message: '',
			randomHeadImg: '',
			sex: [{
				value: '男',
				label: '男'
			}, {
				value: '女',
				label: '女'
			}, ],
			sexValue: '男',
			randomName: '',
			// 留言分页

			pages: {
				currentPage: 1,
				total: 10
			},
			temp: {
				msgText: ['前往留言', '返回列表'],
			},
			// 屏幕加载中..
			isLocked:false
		}
	},
	methods: {
		// 随机语录,由java远程调用实现
		randomText() {
			this.$get('website/randomText').then(data => {
				this.message = data.trim()
			})
		},
		// 点赞
		addLove(id) {
			this.$get('/website/addLove/' + id).then(data => {
				this.$notify.success({
					title: '提示',
					message: '点赞成功',
					position: 'top-right'
				});
				this.messages = this.messages.filter(e => {
					if (e.id == id) {
						e.love++
					}
					return e
				})
			}).catch(err => {
				this.$notify.error({
					title: '提示',
					message: '出了意外',
					position: 'top-right'
				});
			})
		},
		// 获取随机头像
		getRandomHeadImg() {
			let data = {
				format: 'json',
				sort: this.sexValue
			}
			this.$get('https://api.uomg.com/api/rand.avatar?', data).then(data => {
				this.randomHeadImg = data.imgurl
			})
		},
		// 获取随机名字
		getRandomName() {
			this.$get('/website/randomName').then(data => {
				this.randomName = data
			})
		},
		// 发送留言
		sendMsg() {
			let data = {
				imgSrc: this.randomHeadImg,
				name: this.randomName,
				content: this.message,
			}
			if (!!this.message) {
				this.$get('/website/addMessage', data).then(data => {
					if (data.sys_status == -10) {
						this.$notify({
							title: '提示',
							message: '似乎哪里不对呢',
							type: 'error'
						});
					}
					if (data.sys_status == 40) {
						this.$message("添加成功")
					}
					this.message = null
					this.messageBorderShow = true
				})
			} else {
				this.$notify({
					title: '提示',
					message: '似乎哪里不对呢',
					type: 'error'
				});
			}

		},
		handleClick(tab, event) {
			if (tab.name == 'message') {
				this.getMessages()
			}
		},

		handleCurrentChange(val) {
			this.getMessages(val)
		},
		// 获取消息
		getMessages(page = 1) {
			// this.isLocked = true
			this.messages = []
			let data = {
				page: page
			}
			this.$get('/website/getMessages', data).then(data => {
				data.list.forEach(e => {
					this.pages.total = data.total
					this.messages.push(e)
				})
				// 屏幕加载中..
				// this.isLocked = false
			})
		},
		// 评分系统
		setRate() {
			if(this.star < 4){
				this.$message({
					message: '由于你的评分低于4分，经过四舍五入，化成五星好评',
					type: 'success'
				})
				this.star = 5
			}
			this.$get('/website/setRate/'.concat(this.star)).then(data => {
				
				if (data.sys_msg == 10) {
					this.$message({
						message: '评分成功',
						type: 'success'
					})
				}
				if(data.sys_msg === 40){
					this.$message({
						message: '评分失败，你可能已经评价过了',
						type: 'error'
					})
				}

			}).catch(err=>{
				
			})
			
		},
		// 获取评分
		getInfo() {
			
			this.$get('/website/getInfo').then(data => {
				data = data.data
				if (data.averageStar > 5) {
					data.averageStar = 5
				}
				this.view = data.view
				this.star = data.averageStar
			})
		}
		
	},
	mounted() {
		this.getRandomHeadImg()
		this.getRandomName()
		this.randomText()
		this.getInfo()
	}
}
export default attr
