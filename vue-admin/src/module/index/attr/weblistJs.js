let attr = {
	methods: {
		/*
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						  根据ID查询
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		selectById() {
			console.log(this.selectId);
			let tmp = this.weblists.find(e => {
				return e.id == this.selectId
			})
			console.log(tmp);
		},

		/* 
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						  添加网页列表
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		addWeblist() {
			this.$get('/user/addWeblist', this.weblist).then(data => {

				switch (Number(data.sys_status)) {
					case 40:
						{
							this.$message("添加成功");
							this.weblists.push(this.weblist)
							break;
						}
					case -40:
						{
							this.$message("添加失败");
							break;
						}
				}
			}).catch(err => {
				this.$message("添加失败");
			})
			this.dialog.addDialog = false
		},
		/*
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						  删除网页列表
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		deleteWeblist(id) {

			this.$get('/user/deleteWeblistById/'.concat(id.toString())).then(data => {
				console.log(this.weblists);
				if (data.sys_status == 30) {
					this.weblists = this.weblists.filter(e => {
						return e.id != id
					})
					this.$message("删除成功");
				}
				if (data.sys_status == -30) {
					this.$message("删除失败");
				}
				this.dialog.deleteDialog = false
			})
		},
		/*
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						  打开更新对话框
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		openDialog(id) {
			let tpmList = this.weblists.filter(e => {
				return e.id == id
			})
			this.weblist = tpmList[0]
			this.dialog.updateDialog = true

		},
		/*
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						  更新网页列表
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		updateWeblist() {
			console.log(this.weblist);
			this.$get("/user/updateWebList", this.weblist).then(data => {
				this.$message("更新成功")
				this.dialog.updateDialog = false
				console.log(data);
			}).catch(err => {
				this.$message("更新失败")
				this.dialog.updateDialog = true
			})
		},

		/*
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						  关闭对话框之前
			-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
		 */
		handleClose(done) {
			this.$confirm('确认关闭？')
				.then(_ => {
					this.dialog.updateDialog = false
					done();
				})
				.catch(_ => {});
		}
	},
	mounted() {
		this.$get('/user/getWeblist').then(data => {
			this.weblists = data
		}).catch(err => {
			this.$alert('与服务器连接失败', '提示', {
				confirmButtonText: '确定'
			});
		})
	},
	computed: {
		com_weblist: {
			get() {
				return this.weblist
			},
			set(newVal) {
				this.weblist = newVal
			}
		}
	},

	data: () => ({
		dialog: {
			updateDialog: false,
			addDialog: false
		},
		weblist: {
			icon: '',
			tips: '',
			tipsTitle: '提示',
			name: '',
			href: ''
		},
		weblists: [],
		selectId: ''
	}),

}
export default attr
