<template>
	<div>

		<div class="container  ">
			<div class="row ">
				<div class="col col-xl-6 col-lg-6 col-12 ">
					<div>
						<b-card overlay img-src="https://picsum.photos/900/250/?image=3" text-variant="white" title="在线作品">
							<b-card-text>
								所有作品均为纯手工打造，阶段性记录
							</b-card-text>
						</b-card>
					</div>
					<el-divider><i class="el-icon-mobile-phone"></i></el-divider>

					<el-button @click="next">下一步</el-button>
					<el-steps :active="active" finish-status="success">
						<el-step title="步骤 1"></el-step>
						<el-step title="步骤 2"></el-step>
						<el-step title="步骤 3"></el-step>
					</el-steps>



					<el-card class="border-0 shadow-none">
						<el-collapse v-model="activeNames" @change="handleChange">
							<el-collapse-item title="一致性 Consistency" name="1">
								<div>与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；</div>
								<div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>
							</el-collapse-item>
							<el-collapse-item title="反馈 Feedback" name="2">
								<div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
								<div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
							</el-collapse-item>
							<el-collapse-item title="效率 Efficiency" name="3">
								<div>简化流程：设计简洁直观的操作流程；</div>
								<div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
								<div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
							</el-collapse-item>
							<el-collapse-item title="可控 Controllability" name="4">
								<div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
								<div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
							</el-collapse-item>
						</el-collapse>
					</el-card>
				</div>

				<div class="col">
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

<style scoped lang="less">
		.el-timeline-item {
			padding-top: 0 !important;
			padding-bottom: 0 !important;
		}

	.my-bgcolor {
		background-color: #cbf9ff;
	}
</style>
