<template>
	<div>
		<b-container>
			<el-tabs stretch v-model="activeName" @tab-click="handleClick">
				<el-tab-pane label="学习耗时" name="first">
					<b-row class="row-cols-xl-3 row-cols-1 row-cols-md-3 row-lg-cols-3">
						<b-col v-for="(e,i) in skills" :key="i">
							<div class="text-center">
								<el-progress type="circle" :percentage="e.percent"></el-progress>
							</div>

							<div>
								<h4 class="m-0">
									<b-alert show variant="light" class="m-0 pb-0 text-center" v-text="e.language"></b-alert>
								</h4>
								<!--
									*-*-*-*-*-* 
										标签
									*-*-*-*-*-* 
								-->
								<div v-for="(m,n) in e.subject" :key="n">
									<div class="blockquote-footer mb-2">{{m.subtitle}}</div>
									<div class="d-flex  flex-wrap">
										<el-tag class="mx-2 mb-2 " v-for="(k,j) in m.tagName" :key="j" v-text="k"> </el-tag>
									</div>
								</div>
								<b-alert show variant="light" class="m-0 pb-0 ">自我评价</b-alert>
								<div>
									<small class="text-info" v-text="e.assessment"></small>
								</div>
							</div>

						</b-col>
					</b-row>
				</el-tab-pane>

				<!--
					*-*-*-*-*-* 
						学习历程
					*-*-*-*-*-* 
				-->
				<el-tab-pane label="学习历程" name="second">
					<!-- *-*-*-*-*-*  左侧 *-*-*-*-*-* -->
					<div class="row mt-2">
						<div class="col col-xl-6 col-12 ">

							<div>
								<el-timeline>
									<el-timeline-item v-for="(activity, index) in activities" :key="index" :timestamp="activity.timestamp">
										<b-alert class="m-0" :variant="`${index%2 == 0? 'primary' : 'info' }`" show>{{activity.content}}</b-alert>
									</el-timeline-item>
								</el-timeline>
							</div>

						</div>
						<!-- *-*-*-*-*-*  右侧  *-*-*-*-*-* -->
						<div class="col col-xl-6 col-12">
							<div class="col col-12">

								<div class="card">
									<div class="card-body">
										<div class="left-border-5 m-2 pl-2">知识储备</div>
										<el-carousel height="100px" indicator-position="outside" :interval="5000" arrow="hover">
											<el-carousel-item v-for="(e,i) in spares" :key="i" class="d-flex justify-content-center align-items-center">
												<div>
													<el-tag class="m-2" v-for="(v,k) in e.tags" :key="k" v-text="v">PHOTOSHOP</el-tag>
												</div>
											</el-carousel-item>

										</el-carousel>
									</div>
								</div>
							</div>
							<div class="col col-12 mt-2">

								<div class="card">

									<div class="card-body">
										<div class="left-border-5 m-2 pl-2">个人特点</div>

										<div class="row no-gutters">
											<div class="col col-2 text-muted"><small>创造力</small></div>
											<div class="col col-10 ">
												<el-progress status="success" :percentage="80" :format="format"></el-progress>
											</div>
										</div>

										<div class="row no-gutters">
											<div class="col col-2 text-muted"><small>学习力</small></div>
											<div class="col col-10 ">
												<el-progress status="success" :percentage="80" :format="format"></el-progress>
											</div>
										</div>
										
										<div class="row no-gutters">
											<div class="col col-2 text-muted"><small>逻辑力</small></div>
											<div class="col col-10 ">
												<el-progress status="success" :percentage="60" :format="format"></el-progress>
											</div>
										</div>
										
										<div class="row no-gutters">
											<div class="col col-2 text-muted"><small>算法</small></div>
											<div class="col col-10 ">
												<el-progress status="warning" :percentage="30" :format="format"></el-progress>
											</div>
										</div>
										
										<div class="row no-gutters">
											<div class="col col-2 text-muted"><small>临场发挥</small></div>
											<div class="col col-10 ">
												<el-progress status="exception" :percentage="5" :format="format"></el-progress>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</el-tab-pane>

				<!--
					*-*-*-*-*-* 
						学习历程
					*-*-*-*-*-* 
				-->
				<el-tab-pane v-b-modal.modal-center label="工作经历" name="third">

					<!-- 模态框 -->
					<b-modal no-close-on-backdrop v-if="workShow" id="confirm" hide-header hide-footer centered>
						<div class="pb-2">
							<h4>请输入暗号</h4>
							<div>
								<small>请联系本人</small>
								<b-button id="popover-button-event" @click="onOpen" size="sm" class="py-0 mx-2" variant="outline-primary"><small>获取</small></b-button>

								<b-popover placement="left" ref="popover" target="popover-button-event" title="微信号">
									<img src="@/global/img/resume/qrcode.jpg" class="img-fluid" width="100">
								</b-popover>
							</div>
						</div>
						<div class="d-block text-center">
							<b-input v-model="symbol"></b-input>
						</div>
						<div class="d-flex justify-content-end">
							<b-button class="mt-3 mx-4" variant="outline-danger" @click="back">返回 </b-button>
							<b-button class="mt-3" variant="outline-success" @click="confirm">确定 </b-button>

						</div>
					</b-modal>

					<!-- 避免访问的内容 -->
					<div v-if="workShow">
						<div class="text-center">
							<b-alert show variant="danger"><strong>你好像动了什么歪脑筋才看到这句话的。少你，回头是岸，回头是岸啊！</strong></b-alert>
						</div>
					</div>



					<!-- 实际内容 -->
					<div v-if="!workShow">
						内容
					</div>
				</el-tab-pane>
			</el-tabs>


		</b-container>
	</div>
</template>

<script>
	import attr from '@/module/index/resume/attr/resumeAttr.js'
	export default attr
</script>

<style scoped>
	.left-border-5 {
		border-left: 5px solid powderblue;
	}
	.el-timeline{
		padding-left: 5px !important;
	}
</style>
