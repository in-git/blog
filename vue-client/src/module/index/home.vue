<template>
	<div class="h-100">
		<!--
				*-*-*-*-*-* 
				  手机首页 
				*-*-*-*-*-*
		-->
		<div class="d-xl-none d-lg-none">
			<b-navbar toggleable="lg" class="my-bgcolor">
				<b-navbar-brand href="#">MyBlog</b-navbar-brand>

				<b-navbar-toggle class="border-0" target="nav-collapse">
					<b-icon icon="music-note-list" style="color: #7952b3;"></b-icon>
				</b-navbar-toggle>

				<b-collapse id="nav-collapse" is-nav>
					<b-navbar-nav fill small class="my-bgcolor-light my-color">
						<b-nav-item href="/">首页</b-nav-item>
						<b-nav-item href="/home/works">作品</b-nav-item>
						<b-nav-item href="/home/website">关于本页</b-nav-item>
						<b-nav-item href="/home/resume">关于我</b-nav-item>
					</b-navbar-nav>
				</b-collapse>
			</b-navbar>
		</div>
		<div class="container  position-absolute my-center p-0 bg-white h-100">

			<div class="row no-gutters ">
				<!--
					*-*-*-*-*-* PC首页 *-*-*-*-*-*
				 -->
				<div class="col  d-none d-xl-block d-lg-block">
					<img src="@/global/img/index/bgimg.png" class="img-fluid rounded-bottom">
				</div>
			</div>
			<!--
				*-*-*-*-*-* 公告框 *-*-*-*-*-*
			 -->
			<div class="row no-gutters">
				<div class="col">
					<div class="alert my-bgcolor-light my-2 py-2 alert-light text-center rounded">
						<div class="">
							<span class="mdi mdi-bell-outline  text-primary "></span>
							<span v-text="notice"></span>
						</div>
					</div>
				</div>
			</div>

			<!--
				*-*-*-*-*-* 侧边导航 *-*-*-*-*-*
			 -->
			<div class="row no-gutters ">
				<div class="col col-12 col-xl-3 col-lg-3 d-none d-xl-block d-lg-block">
					<ul class="list-group text-center mr-4  rounded h-100">
						<li class="list-group-item  border-0  p-0 my-color "><span class="mdi mdi-feather mdi-36px"></span></li>
						<li :class="[{'my-acitve':e === sidebarActive ?  true:false},`${sidebarClass}`] " @click="push(i.href,e)" v-for="(i,e) in sidebar"
						 :key="i.id">
							<span :class="i.icon"></span>
							<span v-text="i.title"></span>
						</li>
					</ul>
				</div>

				<div class="col ">
					<router-view></router-view>
				</div>

			</div>

			<!--
				*-*-*-*-*-* 
					底部jumbotron PC端
				*-*-*-*-*-* 
			 -->

			<div>
				<div class="jumbotron jumbotron-fluid m-0 fixed-bottom bg-dark  rounded-up py-0 d-none d-xl-block">
					<div class="container">
						<b-row>
							<b-col>
								<b-alert class="text-center my-pointer my-0 text-white" variant="white" show>
									<div @mouseenter="jumbotronShow = !jumbotronShow">
										感谢每一个信任过，帮助过我的人
									</div>
								</b-alert>
							</b-col>
						</b-row>

						<el-collapse-transition>
							<div v-show="jumbotronShow" class="mb-2">
								<b-row>
									<b-col>
										<!--
											-----------
												感谢的公司
											-----------
										 -->
										<div class="card text-black">
											<b-alert show variant="light" class="m-0 ">
												<div class="d-flex justify-content-around">
													加运美有限公司
												</div>
											</b-alert>
										</div>
									</b-col>
									<b-col>
										<!--
											-----------
												感谢的人
											-----------
										 -->
										<div class="card text-black">
											<blockquote class="blockquote m-0">
												<div>
													<b-alert show variant="light" class="m-0 ">
														<div>
															<el-tag class="ml-2">郑邦</el-tag>
															<el-tag class="ml-2">胡芳春</el-tag>
															<el-tag class="ml-2">马武亮</el-tag>
															<el-tag class="ml-2">刘芬芳</el-tag>
															<el-tag class="ml-2">蔡志华</el-tag>
														</div>
													</b-alert>

												</div>
											</blockquote>
										</div>
									</b-col>
								</b-row>
							</div>
						</el-collapse-transition>

					</div>
				</div>
			</div>


	<!--
				*-*-*-*-*-* 
					底部jumbotron 移动端
				*-*-*-*-*-* 
	-->
				<div class="d-lg-none d-md-inline-block d-sm-inline-block d-xl-none d-inline-block border-0 w-100 mt-4 ">
					<b-jumbotron bg-variant="dark"  text-variant="white" fluid class="m-0 py-2  mx-auto rounded">
						<p>
							It uses utility classes for typography and spacing to sp
						</p>
					</b-jumbotron>
				</div>
				
		</div>

	</div>
</template>

<script>
	import f from '@/global/utils/commjs.js'
	import attr from '@/module/index/home/homeJs.js'
	export default attr
</script>

<style scoped>
	@import url("../../global/interaction/bootstrap.css");
	@import url("home/homeCss.css");
</style>
