import f from '@/global/utils/commjs.js'
let attr = {
	mounted(){
		this.$get('/index/weblist').then(data=>{
			console.log(data);
			data.forEach(e=>{
				this.nav.push(e)
			})
			
		})
	},
	data() {
		return {
			github: [{
				url: 'https://github.com/6byte/Note.git',
				title: '全栈笔记',
				description: '内容包含JS,VUE,MYSQL,LINUX,JAVA各大主流框架,内容经规范精简优化,通俗易懂',
				img: 'https://picsum.photos/300/150/?image=41',
				download: 'https://github.com/6byte/Note/archive/master.zip',
				address: 'https://github.com/6byte/Note'
			}, {
				url: 'https://github.com/6byte/init',
				title: '高集成框架',
				description: '集成AOP,SHIRO,REDIS,DRUID等框架，下载即用',
				img: 'https://picsum.photos/300/150/?image=41',
				download: 'https://github.com/6byte/init/archive/master.zip',
				address: 'https://github.com/6byte/init',
			}, ],
			nav: []
		};
	},
	methods: {
		gitCopy(content) {
			f.copy(content)
			this.$message('复制成功')
		},
		push(url) {
			if (!!url) {
				console.log(!!url);
				window.location.href = url
			}
		}
	},
}
export default attr
