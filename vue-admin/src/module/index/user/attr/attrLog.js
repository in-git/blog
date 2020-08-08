let attrLog = {
	name: 'log',
	
	data() {
		return {
			logs: [],
			// 属性：日志分页
			firstPage: 1,
			pageNum: 10,
			totalPage: null
		}
	},
	
	mounted() {
		// 获取日志
		this.getLogs()
	},
	
	methods: {
		/*
			===================
				功能：获取日志
			=================== 
		*/
		getLogs(){
			this.$get('/manager/getLog').then(data => {
				let log = []
				for (let v in data) {
					if (!!data[v]) {
						let str = data[v].trim().split('@')[0]
						if (!str.indexOf("at") == 0) {
							log.push(str)
						}
					}
				}
				this.logs = Array.from(new Set(log))
				this.totalPage = this.logs.length
				
			})
		},
		/*
			===================
				功能：刷新日志
			=================== 
		*/
	   refleshLog(){
		  try{
			  this.getLogs()
			  this.$message('成功获取日志')
		  }
		  catch(err){
			  this.$message('失败获取日志')
		  }
	   },
		/* 
			===================
				功能：清空日志
			=================== 
		*/
		clearLog() {
			this.$get('/manager/clearLog').then(data => {
				if (data.sys_status == 30) {
					this.$message(data.sys_msg)
					this.logs = []
				}
			}).catch(err => {
				this.$message("清空失败")
			})
		},
		/*
			===================
				功能:对日志进行分页
				函数:
					nextPage:下一页
					prePage:上一页
			=================== 
		*/
		nextPage() {
			let totalCount = Math.ceil(this.totalPage / this.pageNum)
			console.log(totalCount, this.firstPage);
			if (this.firstPage < totalCount) {
				this.firstPage += 1
			}
			// console.log(totalCount, this.firstPage);
		},
		prePage() {
			if (this.firstPage > 1) {
				this.firstPage -= 1
			}
		}
	},
	computed: {
		com_logs() {
			return this.logs.slice(this.pageNum * (this.firstPage - 1), this.pageNum * (this.firstPage))
		}
	}

}
export default attrLog
