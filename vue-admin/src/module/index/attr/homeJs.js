import f from '@/global/utils/commjs.js'
let homeJs = {

	mounted() {
		let remostHost = 'http://134.175.79.33:15005/img/1920x1080/'
		
		this.$get('/user/message').then(data => {
			data = data.data
			data.motto.forEach((e, i) => {
				this.redis[`motto${i+1}`] = e
			})
			/*
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  图片分页处理
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			*/
			data.fileList.map((e ,i)=> {
				this.arrs.push(remostHost + e)
			})
			this.arrLength = Number.parseInt(this.arrs.length/this.pagesize)
			console.log(this.arrs.length);
			this.redis.view = data.view
			
		}).catch(err => {})
	},
	methods: {
		copy(url){
			f.copy(url)
			this.$message("复制成功")
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
			this.redis['motto' + symbol] = null
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
		}
	},

	data: () => ({
		redis: {
			view: 0,
			motto1: "",
			motto2: "",
			motto3: ""
		},
		currentPage: 1, //当前页号
		pagesize: 4, //每页大小
		arrs: [],
		arrLength:10,
		
		carousel:['','','','']
	}),
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
}
export default homeJs
