<template>
	<div>

		<div class="container  ">

			<!--
				
				   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				                 引导式风格
				   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				  
			 -->
			<div class="row ">
				<div class="col col-xl-6 col-lg-6 col-12 ">
					<el-divider><span class="font-weight-bold">探索作品</span></el-divider>
					<b-card-title class="pt-0">
						<strong>引导式风格</strong>
						<el-popover placement="top-start" title="说明" width="200" trigger="hover" content="引导式风格的最终效果是完全动态网页">
							<el-button type="text" slot="reference"><i class="el-icon-info pt-1"></i></el-button>
						</el-popover>

					</b-card-title>
					<el-tabs tab-position="left">
						<el-tab-pane label="概览">
							<b-alert show class="left-border-color-1">只要符合该风格，理论可以容纳任意个项目</b-alert>
							<b-alert show class="left-border-color-1">使用文件目录+界面划分业务逻辑</b-alert>
							<b-alert show class="left-border-color-1">使前端，后台，界面统一</b-alert>
						</el-tab-pane>
						<el-tab-pane label="特点">
							<b-alert variant="light" show class="left-border-color-2">适用于单页面或多页面结构</b-alert>
							<b-alert variant="light" show class="left-border-color-2">快速定位Bug</b-alert>
							<b-alert variant="light" show class="left-border-color-2">快速定位文件</b-alert>
							<b-alert variant="light" show class="left-border-color-2">弹性删减业务</b-alert>
							<b-alert variant="light" show class="left-border-color-2">使项目结构清晰，易于调整</b-alert>
						</el-tab-pane>
					</el-tabs>

				</div>



				<div class="col">
					<el-divider><span class="font-weight-bold">线上作品</span></el-divider>
					<template>
						<el-tabs stretch v-model="activeName" @tab-click="handleClick">

							<!--
								
								   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								                 2019时间线
								   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  
							 -->
							<el-tab-pane label="2019" name="first">
								<div class="block">
									<el-timeline class="p-0 mt-2">
										<el-timeline-item :timestamp="e.time" placement="top" v-for="( e , i) in timeline_2019" :key="i">
											<el-card class="border-0  ">
												<div>
													<div class=" text-center">
														<h6 class="my-color font-weight-bold" v-text="e.name"></h6>
													</div>
												</div>

												<div>
													<div>
														<span class="text-muted blockquote-footer" v-text="e.description"></span>
													</div>

												</div>
												<div class="mt-1">
													<el-tag class=" mx-2" type="info" size="mini" v-for="(e,i) in e.tag" :key="i" v-text="e">Vue</el-tag>
												</div>
												<div class="text-right ">
													<el-link target="_blank" class="text-success" type="primary" :underline="false" :href="e.href">前往查看</el-link>
												</div>
											</el-card>
										</el-timeline-item>

									</el-timeline>
								</div>

								<!--
									
									   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									                 2019展示图片轮播图
									   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									  
								 -->
								
							</el-tab-pane>
							<el-tab-pane label="2020" name="second">

								<!--
									
									   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									                 2020展示图片轮播图
									   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									  
								 -->
								<div class="block">
									<el-timeline class="p-0 mt-2">
										<el-timeline-item :timestamp="e.time" placement="top" v-for="( e , i) in timeline_2020" :key="i">
											<el-card class="border-0">
												<div>
													<div class=" text-center">
														<h6 class="my-color font-weight-bold" v-text="e.name"></h6>
													</div>
												</div>

												<div>
													<div>
														<span class="text-muted blockquote-footer" v-text="e.description"></span>
													</div>

												</div>
												<div class="mt-1">
													<el-tag class=" mx-2" type="info" size="mini" v-for="(e,i) in e.tag" :key="i" v-text="e">Vue</el-tag>
												</div>
												<div class="text-right ">
													<el-link target="_blank" class="text-success" type="primary" :underline="false" :href="e.href">前往查看</el-link>
												</div>
											</el-card>
										</el-timeline-item>

									</el-timeline>
								</div>
							</el-tab-pane>
						</el-tabs>
					</template>


				</div>
			</div>

		</div>
	</div>
</template>

<script>
	import attr from '@/module/index/works/attr/workAttr.js'
	export default attr
</script>

<style scoped>
	.el-timeline-item {
		padding-top: 0 !important;
		padding-bottom: 0 !important;
	}
	
	.my-bgcolor {
		background-color: #cbf9ff;
	}
	
	
	
	.left-border-color-1 {
		border: none;
		border-left: 10px solid #00aaff;
		background-color: #eefbff;
	
	}
	
	.left-border-color-2 {
		border: none;
		border-left: 10px solid #aaaaff;
		background-color: #efebff;
	}
	
	.left-border-color-3 {
		border: none;
		border-left: 10px solid #ffb3d0;
		background-color: #ffe6ec;
	}
</style>
