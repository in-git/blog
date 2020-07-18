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
					<el-divider><span class="font-weight-bold">理论作品</span></el-divider>
					<v-card-title class="pt-0">
						<strong>引导式风格</strong>
						<el-popover placement="top-start" title="说明" width="200" trigger="hover" content="引导式风格的最终效果是完全动态网页">
							<el-button type="text" slot="reference"><i class="el-icon-info pt-1"></i></el-button>
						</el-popover>

					</v-card-title>
					<el-tabs tab-position="left">
						<el-tab-pane label="概览">
							<b-alert show class="left-border-color-1">一个超级MVC结构</b-alert>
							<b-alert show class="left-border-color-1">只要符合该规范，理论可以容纳任意个项目（待验证）</b-alert>
						</el-tab-pane>
						<el-tab-pane label="特点">
							<b-alert variant="light" show class="left-border-color-2">适用于B-S,C-S结构</b-alert>
							<b-alert variant="light" show class="left-border-color-2">快速定位Bug</b-alert>
							<b-alert variant="light" show class="left-border-color-2">弹性增删业务逻辑，任何业务逻辑的删改，不影响其他板块内容</b-alert>
						</el-tab-pane>
					</el-tabs>



					<!--
								
						   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
										 笔记规范
						   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  
					-->

					<v-card-title class="pt-0">
						<strong>笔记规范</strong>
						<el-popover placement="top-start" title="说明" width="200" trigger="hover" content="笔记规范说明">
							<el-button type="text" slot="reference"><i class="el-icon-info pt-1"></i></el-button>
						</el-popover>

					</v-card-title>
					<el-tabs tab-position="left">
						<el-tab-pane label="概览">
							<b-alert show class="left-border-color-1"> 这是一篇向传统学习方式发起挑战的体系，目前正在完善中</b-alert>
						</el-tab-pane>
						<el-tab-pane label="理念">
							<b-alert show class="left-border-color-1">
								
							</b-alert>
						</el-tab-pane>
						<el-tab-pane label="规范">
							<b-alert show class="left-border-color-2"><small>内容分条梳理，言简意赅</small></b-alert>
							<b-alert show class="left-border-color-2"><small>结构统一，便于搜索</small></b-alert>
							<b-alert variant="light" show class="left-border-color-2"><small>确保内容准确，有必要则牺牲严谨性，使文字易懂</small></b-alert>
							<b-alert variant="light" show class="left-border-color-2"><small>不使与关键内容无关的词汇，如形容词、副词等</small></b-alert>
							<b-alert variant="light" show class="left-border-color-2"><small>不使外语注释</small></b-alert>
						</el-tab-pane>
					</el-tabs>
				</div>



				<div class="col">
					<el-divider><span class="font-weight-bold">线上作品</span></el-divider>
					<template>
						<el-tabs v-model="activeName" @tab-click="handleClick">

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
								<el-divider content-position="left">小游戏</el-divider>
								<div class="row">
									<div class="col">
										<video src="http://134.175.79.33:15005/vue-blog/game.mp4" controls class="img-fluid rounded "></video>
									</div>
								</div>
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
	@import url("./css/works.css");
</style>
