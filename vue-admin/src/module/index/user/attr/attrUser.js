let attrUser = {
	name: 'user',
	methods: {
		/*
		===================
			获取用户
		===================  
		 */
		getUsers() {
			this.$get('/manager/selectUsers').then(data => {
				data = data.filter(e => {
					e.black == 0 ? e.black = false : e.black = true
					return e
				})
				this.usersList = data
			}).catch(err => {
				this.$message('获取失败')
			})
		},
		
		/* 
		===================
			根据ID删除用户
		===================  
		 */
		deleteUser(id) {
			this.$confirm('确定删除该用户,?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				this.$get('/manager/deleteUser/'.concat(id)).then(data => {
					this.$message(data.sys_msg)
					if (data.sys_status == 30) {
						this.usersList = this.usersList.filter(e => {
							if (e.id != id) {
								return e
							}
						})
					}

				}).catch(err => {
					this.$message('删除失败')
				})
			})
		},

		/*
			功能:在更新用户之前需要执行的操作
				a.切换界面
				b.渲染列表
		 */
		beforeUpdateUser(item) {
			console.log(item);
			this.action = false
			this.userInfo.passwd = item.passwd
			this.userInfo.username = item.username
			this.userInfo.ukey = item.ukey
			this.userInfo.black = item.black
			this.userInfo.id = item.id
		},
		
		// 更新用户
		updateUser(){
			
			let data = {
				id:this.userInfo.id,
				passwd : this.userInfo.passwd,
				username : this.userInfo.username ,
				ukey : this.userInfo.ukey ,
				black : this.userInfo.black == true ? 1 : 0,
				restrictd:0
			}
			console.log(data);
			this.$get('/manager/updateUser',{
				params:data
			}).then(data=>{
				console.log(data);
			})
		}
	},
	data() {
		return {
			/* 
				属性说明
					action：用于切换 更新界面 和 列表渲染界面
					usersList：用户列表
					usersHeaders：用户列表头
			 */
			userInfo:{
				username: null,
				passwd: null,
				ukey:null,
				black:null,
				id:null
			},
			action: true,
			usersList: [],
			usersHeaders: [{
					text: 'ID',
					value: 'id',
					align: 'center'
				},
				{
					text: '用户名',
					value: 'username',
					align: 'center'
				},
				{
					text: '密码',
					value: 'passwd',
					align: 'center'
				},
				{
					text: 'UKEY',
					value: 'ukey',
					align: 'center'
				},
				{
					text: '是否禁用',
					value: 'black',
					align: 'center'
				},
				{
					text: '操作',
					value: 'action',
					align: 'center'
				}
			],

		}
	},
	/*
	  ===================
		a.获取账号密码
	  ===================
	*/
	mounted() {
		this.getUsers()
	}
}
export default attrUser
