<template>
	<div>
		<template>
			<v-banner>
				<span v-text="nav"></span>
				<template v-slot:actions>
					<v-btn text color="primary" @click="view('ip')">IP管理</v-btn>
					<v-btn text color="primary" @click="view('user')">用户管理</v-btn>
					<v-btn text color="primary" @click="view('log')">log监控</v-btn>
				</template>
			</v-banner>
		</template>
		
		<div >
				<ip v-show="showList.ip"></ip>
				<log v-show="showList.log"></log>
				<user  v-if='showList.user'></user>
		</div>
	</div>
</template>


<script>
	import ip from './router/ip.vue'
	import log from './router/log.vue'
	import user from './router/user.vue'
	export default {
		name: 'manager',
		data() {
			return {
				showList:{
					ip:true,
					log:false,
					user:false
				},
				nav:'ip管理'
			}
		},
		methods:{
			view(uri){
				for (let k in this.showList) {
					this.showList[k] = false
				}
				this.nav = uri+'管理'
				this.showList[uri] = true
			}
		},
		computed:{
			
		},
		components:{
			ip,
			log,
			user
		}
	}
</script>

<style scoped>

</style>
