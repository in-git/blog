import f from '@/global/utils/commjs.js'
let attr = {

	mounted() {
		this.getGithubs()
		this.$get('/index/weblist').then(data => {
			console.log(data);
			data =data.data
			data.weblists.forEach(e => {
				this.nav.push(e)
			})
			data.carousel.forEach(e => {
				this.carousel.push(e)
			})

			data.motto.forEach(e => {
				this.motto.push(e)
			})
		})


	},
	data() {
		return {
			imgShow: true,
			github: [

			],
			nav: [],
			input: '',
			carousel: [],
			motto: [],
			md5: '',
			
		};
	},
	methods: {
		// 图片加载完成
		imgLoad(){
			this.imgShow = false
		},
		gitCopy(content) {
			f.copy(content)
			this.$message('复制成功')
		},
		push(url) {
			if (!!url) {
				window.location.href = url
			}
		},
		getMd5() {
			let data = {
				original: this.md5
			}
			if (!!this.md5) {
				this.$get('/index/md5', data).then(data => {
					this.$alert(data.data, '提示', {
						confirmButtonText: '确定',
					});
				})
			} else {
				this.$alert("出错了哦，再试一次吧", '提示', {
					confirmButtonText: '确定',
				});
			}

		},
		getGithubs() {
			this.$get('/website/githubs').then(data => {
				data = data.data
				data.forEach(e => {
					this.github.push(e)
				})

			})
		}
	},
}
export default attr
