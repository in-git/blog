<template>
	<v-app >
		<v-main>
			<v-container  class="py-0">
				<v-row>
					<v-col>
						<v-card elevation=0>
							<v-toolbar flat dark>
								<v-toolbar-title>后台管理</v-toolbar-title>
								<v-spacer></v-spacer>
								<v-btn text color="error">退出</v-btn>
							</v-toolbar>
							<v-tabs vertical>

								<v-tab>
									<v-icon right>mdi-account</v-icon>
									首页管理
								</v-tab>
								<v-tab>
									<v-icon right>mdi-account</v-icon>
									导航管理
								</v-tab>
						<!--
						
							-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
										  首页管理
							-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						
						-->
								<v-tab-item>
									<v-card flat elevation=0>
										<home></home>
									</v-card>
								</v-tab-item>

						<!--
						
							-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
										  导航管理
							-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
						
						-->
								<v-tab-item>
									<v-card flat elevation=0>
										<weblist></weblist>
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
	import weblist from '@/module/index/weblist.vue'
	import home from '@/module/index/home.vue'
	export default {
		components: {
			weblist,
			home
		}
	}
</script>

<style scoped>

</style>
