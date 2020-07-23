<template>
	<div>

		<div class="row text-center text-truncate no-gutters ">
			<!--
				*-*-*-*-*-* 
					左区
				*-*-*-*-*-* 
			 -->
			<div class="col col-12 col-xl-6 col-lg-12 ">

				<div class="row ">
					<div class="col ">
						<b-alert show variant="primary" class="m-0 py-2">结构概览</b-alert>
					</div>
				</div>

				<div class="row my-bgcolor-1 no-gutters">
					<div class="col ">
						<!--
							*-*-*-*-*-* 
								数据库
							*-*-*-*-*-* 
						 -->
						<div class="d-flex flex-column">

							<div>
								<el-popover placement="left" width="200" trigger="hover" title="" content="Mysql">
									<el-button slot="reference" type="text"><img src="@/global/img/website/mysql.svg"></el-button>
								</el-popover>

								<img src="@/global/img/website/alter.svg" class="mx-4">

								<el-popover placement="right" width="200" trigger="hover" content="Redis">
									<el-button slot="reference" type="text"><img src="@/global/img/website/redis.svg" alt=""></el-button>
								</el-popover>
							</div>


							<div>
								<img src="@/global/img/website/db-arrow.svg">
								<img src="@/global/img/website/db-arrow.svg">
							</div>

						</div>
					</div>
				</div>

				<!--
					*-*-*-*-*-* 
						服务器端
					*-*-*-*-*-* 
				 -->
				<div class="row my-bgcolor-2 no-gutters">
					<div class="col text-center">
						<el-popover placement="left" width="200" trigger="hover" title="后台管理服务器" content="负责整个网页的后台管理">
							<el-button slot="reference" type="text"><img src="@/global/img/website/serve-admin.svg"></el-button>
						</el-popover>
					</div>

					<div class="col text-center">
						<el-popover placement="right" title="内容服务器" width="200" trigger="hover" content="负责调度页面显示资源">
							<el-button slot="reference" type="text"><img src="@/global/img/website/serve-client.svg"></el-button>
						</el-popover>
					</div>
				</div>
				<!--
				*-*-*-*-*-* 
					静态页面
				*-*-*-*-*-* 
			 -->
				<div class="row my-bgcolor-1 no-gutters">

					<div class="col">
						<div class="d-flex justify-content-center">
							<img src="@/global/img/website/db-arrow.svg">
						</div>
						<div>
							<el-popover placement="left" title="后台管理页面" width="200" trigger="hover" content="使用Vue实现的单页面结构,前后端不分离,由于路由不可用,采用选项卡完成">
								<el-button slot="reference" type="text"><img src="@/global/img/website/page-admin.svg"></el-button>
							</el-popover>
						</div>
						<div>
							<img src="@/global/img/website/db-arrow.svg" class="pt-1">
						</div>
					</div>

					<!-- 前端展示页面 -->
					<div class="col text-center">
						<div class="d-flex justify-content-center ">
							<img src="@/global/img/website/db-arrow.svg">
						</div>
						<div class=" d-flex justify-content-around  pt-1">
							<el-popover placement="right" title="前端显示界面" width="200" trigger="hover" content="采用Docker容器部署Tomcat集群,前后端分离	">
								<el-button slot="reference">
									<img src="@/global/img/website/page-client.svg">
									<img src="@/global/img/website/page-client.svg">
								</el-button>
							</el-popover>

						</div>

						<!--
							 	*-*-*-*-*-* 
							 		Nginx
							 	*-*-*-*-*-* 
							 -->
						<div class="d-flex flex-column">
							<img src="@/global/img/website/db-arrow.svg" class="pt-1">
							<el-popover placement="right" title="减压服务器" width="200" trigger="hover" content="采用轮询算法实现流量减压">
								<el-button slot="reference" type="text"><img src="@/global/img/website/nginx.svg"></el-button>
							</el-popover>

							<img src="@/global/img/website/db-arrow.svg" class="pt-1">
						</div>
					</div>
				</div>

				<!--
						*-*-*-*-*-* 
							用户请求
						*-*-*-*-*-* 
					 -->
				<div class="row my-bgcolor-2 no-gutters">
					<div class="col">
						<!-- 指示箭头 -->
						<div class="d-flex justify-content-center ">
							<el-divider> 后台管理</el-divider>
							<el-divider>前端展示</el-divider>
						</div>
						<div class="col text-center">

							<img src="@/global/img/website/computer.svg" alt="">
						</div>
					</div>
				</div>

			</div>


			<!--
				*-*-*-*-*-* 
					右区
				*-*-*-*-*-* 
			 -->
			<div class="col col-12 col-xl-6 col-lg-12 text-center pl-2">

				<!--
					*-*-*-*-*-* 
						结构设计
					*-*-*-*-*-* 
				 -->
				<div class="row">
					<div class="col">
						<el-tabs stretch v-model="activeTab" @tab-click="handleClick">
							<el-tab-pane name="struct">
								<span slot="label"><span class="mdi mdi-diving-flippers mr-1"></span>本站信息</span>
								<div class="card border-0">
									<div class="card-body">
										
										<div>
											<b-alert class="my-bgcolor-3 bg-transparent border-top-5 py-1" show>
												<div class="m-2 d-flex justify-content-between">
													<span>IP访问量</span>
													<span>
														<el-tag>12</el-tag>
													</span>
												</div>
											</b-alert>
										</div>
										
										<div>
											<b-alert class="my-bgcolor-3 bg-transparent border-top-5 py-1" show>
												<div class="m-2 d-flex justify-content-between">
													<span>前端框架</span>
													<span>
														<el-tag>ElementUI+BootstrapVue</el-tag>
													</span>
												</div>
											</b-alert>
										</div>

										<div>
											<b-alert class="my-bgcolor-3 bg-transparent border-top-5 py-1" show>
												<div class="m-2 d-flex justify-content-between">
													<span>服务器</span>
													<span>
														<el-tag>腾讯云Linux</el-tag>
													</span></div>
											</b-alert>
										</div>

										<div>
											<b-alert class="my-bgcolor-3 bg-transparent border-top-5 py-1" show>
												<div class="text-left m-2">吴文龙负责</div>
												<div class="d-flex justify-content-around">

													<span class="my-pink" v-for="(v,k) in maker" :key="k">
														<el-tag v-text="v"></el-tag>
													</span>
												</div>
											</b-alert>
										</div>

										<div class="">
											<b-alert show class="my-bgcolor-3 border-top-5 bg-transparent d-flex justify-content-between">
												<span>本站评分</span>
												<el-rate v-model="star" class="pt-1"></el-rate>
												<el-button :disabled="isStar" size="mini" @click="setRate">确定</el-button>
											</b-alert>

										</div>

									</div>
								</div>
							</el-tab-pane>

							<!--
								*-*-*-*-*-* 
									在线留言
								*-*-*-*-*-* 
							 -->
							<el-tab-pane name="message">
								<span slot="label" v-loading.fullscreen.lock="isLocked"><span class="mdi mdi-dlna mr-1"></span>在线留言</span>
								<div class="row">
									<div class="col ">
										<div class="   mr-3">
											<b-row>
												<b-col cols="8" v-show="messageBorderShow">
													<el-pagination @current-change="handleCurrentChange" :current-page.sync="pages.currentPage" :page-size="5"
													 small layout="total, prev, pager, next" :total="pages.total">
													</el-pagination>
												</b-col>
												<b-col class="pr-0" cols="8" v-show="!messageBorderShow">
													<b-alert variant="light" class="m-0 text-left text-primary" show>在线留言</b-alert>
												</b-col>
												<b-col class="text-right my-auto">
													<el-button round @click="messageBorderShow = !messageBorderShow">
														{{messageBorderShow === false ? temp.msgText[1]:temp.msgText[0]}}
													</el-button>
												</b-col>
											</b-row>

										</div>
										<!--
									*-*-*-*-*-*展示留言面板*-*-*-*-*-* 
								 -->
										<div v-if="messageBorderShow">
											<b-row v-for="(e,i) in messages" :key="i">
												<b-col class="my-auto" cols=2>
													<img :src="e.imgSrc" class="rounded img-fluid">
												</b-col>
												<b-col class="pl-0">
													<div class="text-left ">
														<h6 v-if="!(e.isVip === 1)" :class='{"text-purple":e.isVip === 1}'><strong v-text="e.name"></strong></h6>
														<div v-if="e.isVip === 1">
															<el-badge value="vip" class="item ">
																<el-button type="text" size="small" v-text="e.name"></el-button>
															</el-badge>
														</div>
														<div :id="`content${e.id}`" class="text-truncate" v-text="e.content">
														</div>

														<div class="text-right 	mt-2">
															<el-badge :value="e.love" class="item mr-4 " type="primary">
																<el-button @click="addLove(e.id)" size="mini">
																	<span class="mdi mdi-flower-tulip-outline"></span>
																</el-button>
															</el-badge>

														</div>
													</div>
													<!-- 内容放大 -->
													<b-popover :target="`content${e.id}`" triggers="hover" placement="top">
														<span v-text="e.content"></span>
													</b-popover>
												</b-col>
											</b-row>

										</div>

										<!-- 留言 -->
										<div v-if="!messageBorderShow">
											<b-row>
												<b-col cols="12" class="mt-2">
													<b-alert variant="primary" show>
														<div class="d-flex justify-content-between">
															<b-img rounded :src="randomHeadImg" fluid width="40"> </b-img>
															<el-select v-model="sexValue" placeholder="请选择">
																<el-option v-for="item in sex" :key="item.value" :label="item.label" :value="item.value">
																</el-option>
															</el-select>
															<el-button round size="mini" @click="getRandomHeadImg">切换头像</el-button>
														</div>
													</b-alert>

													<b-alert variant="primary" show>
														<div class="d-flex justify-content-between">
															<el-button type="text" class="mr-4 text-dark">名字</el-button>
															<el-input maxlength="10" clearable show-word-limit v-model="randomName"></el-input>
															<el-button @click="getRandomName()" round size="mini" class="ml-4">随机生成</el-button>
														</div>
													</b-alert>
													<div>
														<b-form-textarea v-model="message" no-resize id="textarea-rows" placeholder="输入留言内容" rows="8"></b-form-textarea>
													</div>
													<div class="mt-2">
														<b-btn block variant="outline-primary" @click="sendMsg">提交</b-btn>
													</div>
												</b-col>
											</b-row>

										</div>
									</div>
								</div>
							</el-tab-pane>
						</el-tabs>
					</div>
				</div>

			</div>
		</div>

	</div>
</template>

<script>
	import attr from './attr/website.js'
	export default attr
</script>

<style scoped>
	@import url("./css/website.css");
</style>
