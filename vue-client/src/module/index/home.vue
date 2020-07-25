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

			<div class="row no-gutters " v-loading.fullscreen.lock="fullscreenLoading">
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
										天意怜幽草，人间重晚情
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
											<b-alert show variant="light" class="m-0 py-2 text-center">
												<el-link :underline="false" target="_blank" type="primary" href="http://jym56.cn/">加运美有限公司</el-link>
											</b-alert>
										</div>
									</b-col>
									<b-col>
										<!--
											-----------
												开源组织
											-----------
										 -->
										<div class="card text-black ">
											<b-alert show variant="light" class="m-0 py-2 text-center d-flex justify-content-around">
												<el-link :underline="false" type="primary" href="https://cn.vuejs.org/">Vue</el-link>
												<el-link :underline="false" type="primary" href="https://bootstrap-vue.org/docs/icons">bootstrapVue</el-link>
												<el-link :underline="false" type="primary" href="https://element.eleme.cn/#/zh-CN/component/link">ElementUi</el-link>
												<el-link :underline="false" type="primary" href="https://spring.io/">Spring</el-link>
											</b-alert>
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
				<b-jumbotron bg-variant="dark" text-variant="white" fluid class="m-0 py-2  mx-auto rounded">
					<div class="text-center">
						<span>天意怜幽草，人间重晚情</span>
					</div>
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
