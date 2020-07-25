let attr = {
	name: 'website',
	mounted() {
		this.$get('/user/website/messageList').then(data => {
			data.list.forEach(e => {
				this.messages.push(e)
			})
			this.total = data.pages
		})
	},
	watch: {
		page() {
			this.getMessage(this.page)
		}
	},

	data() {
		return {
			pageA: false,
			messages: [],
			message: {
				id: null,
				imgSrc: null,
				name: null,
				content: null,
				love: null,
				isVip: null
			},
			page: 1,
			total: 0,
			searchName: ''
		}
	},
	methods: {
		/* 搜索留言 */
		searchMessage() {
			let data = {
				name: this.searchName
			}
			console.log(data);
			this.$get('/user/website/searchMessage', data).then(data => {
				this.messages = []
				this.searchName = ''
				console.log(data);
				data.list.forEach(e => {
					this.messages.push(e)
				})
			})


		},
		getMessage(page = 1) {
			let data = {
				page: page
			}
			this.messages = []
			this.$get('/user/website/messageList', data).then(data => {
				data.list.forEach(e => {
					this.messages.push(e)
				})

			})
		},
		change(id) {
			this.pageA = !this.pageA
			let e = this.messages.find(e => {
				return e.id == id
			})
			this.message = e
		},
		goBackHome() {
			this.pageA = false
		},
		/* 根据ID删除元素 */
		deleteMessage(id) {
			this.$get('/user/website/deleteMessage/' + id).then(data => {
				if (30 == data.sys_status) {
					this.messages = this.messages.filter(e => {
						return id != e.id
					})
					this.$message('删除成功')
				}

			}).catch(err => {
				this.$message("错误")
			})
		},
		// 更新数据
		updateMessage() {
			let data = this.message

			this.$get('/user/website/updateMessage', data).then(data => {
				if (data.sys_status == '20') {
					this.$message(data.sys_msg)
				} else {
					this.$message('修改失败')
				}
				this.pageA = false
			})
		}
	},
}
export default attr
