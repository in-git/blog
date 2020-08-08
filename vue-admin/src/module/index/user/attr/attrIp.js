let attrIp = {
	data() {
		return {
			ipInfo: [],
			headers: [{
					text: 'ip',
					align: 'center',
					sortable: true,
					value: 'ip',
				},
				{
					text: '操作',
					value: 'action',
					align: 'center'
				}
			],
			// 对IP进行分页
			currentPage: 1,
			totalCount: null,
			pageNum: 20
		}
	},
	mounted() {
		this.getIps()
	},
	methods: {
		/* 
		===================
			a.删除IP
		=================== 
		*/
		deleteIp(v) {
			console.log(v);
			this.$get('/manager/deleteIp/' + v).then(data => {
				this.$message(sys_msg)
			}).catch(err => {
				this.$message('失败')
			})
		},
		/* 
				===================
					a.获取IP
				=================== 
				*/
		getIps() {
			this.$get("/manager/info").then(data => {
				data = data.data.ip
				let arr = []
				for (let k of data) {
					let obj = {
						ip: null
					}
					obj.ip = k
					arr.push(obj)
				}
				this.ipInfo = arr
				this.totalCount = arr.length
			})
		},
		/*
		===================
			a.对IP进行分页
		=================== 
		*/
		nextPage() {
			let totalPage = Math.ceil(this.totalCount/this.pageNum)
			if(totalPage > this.currentPage){
				this.currentPage ++
			}
		},
		prePage(){
			if(this.currentPage>1){
				this.currentPage--
			}
		}

	},
	computed: {
		com_ips() {
			return this.ipInfo.slice((this.currentPage - 1) * this.pageNum, (this.currentPage) * this.pageNum)
		},
		com_nextPage(){
			return this.totalCount - this.currentPage == 0
		}
	}
}
export default attrIp
