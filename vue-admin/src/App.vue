<template>
	<v-app>
		<v-main>
			<v-container class="py-0" fluid="">
				<v-row>
					<v-col>
						<v-card elevation=0>
							<v-toolbar flat dark>
								<v-toolbar-title>后台管理</v-toolbar-title>
								<v-spacer></v-spacer>
								<v-btn href="/user/logout" text color="error">退出</v-btn>
							</v-toolbar>
							<v-tabs vertical>

								<v-tab>
									<v-icon right>mdi-gesture</v-icon>
									<span>首页管理</span>
								</v-tab>
								<v-tab>
									<v-icon right>mdi-gentoo</v-icon>
									<span>留言管理</span>
								</v-tab>
								<v-tab>
									<v-icon right> mdi-account</v-icon>
									<span>用户管理</span>
								</v-tab>
								<!--
									===================
										首页管理
									===================
								-->
								<v-tab-item>
									<v-card flat elevation=0>
										<home></home>
									</v-card>
								</v-tab-item>

								<!--
									===================
										关于本站管理
									===================
								-->
								<v-tab-item>
									<v-card flat elevation=0>
										<website></website>
									</v-card>
								</v-tab-item>

								<!--
									===================
										用户管理
									===================
								-->
								<v-tab-item>
									<v-card flat elevation=0>
										<manager></manager>
									</v-card>
								</v-tab-item>
							</v-tabs>
						</v-card>


					</v-col>
				</v-row>
			</v-container>
		</v-main>
	</v-app>
</template>
<script>
	import home from '@/module/index/home/home.vue'
	import website from '@/module/index/website/website.vue'
	import manager from '@/module/index/user/manager.vue'
	export default {
		components: {
			website,
			home,
			manager
		}
	}
</script>

<style scoped>

</style>
