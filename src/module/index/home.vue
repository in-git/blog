<template>
	<div class="h-100  ">
		<!--
				*-*-*-*-*-* 
				  手机首页 
				*-*-*-*-*-*
		-->
		<div class="d-xl-none d-lg-none">
			<b-navbar toggleable="lg" type="dark" variant="dark">
				<b-navbar-brand href="#">MyBlog</b-navbar-brand>

				<b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

				<b-collapse id="nav-collapse" is-nav>
					<b-navbar-nav>
						<b-nav-item href="#">Link</b-nav-item>
						<b-nav-item href="#" disabled>Disabled</b-nav-item>
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
					<div class="alert my-bgcolor-light my-2 alert-light d-flex justify-content-between mx-xl-4">
						<div>状态</div>
					</div>
				</div>
			</div>

			<!--
				*-*-*-*-*-* 侧边导航 *-*-*-*-*-*
			 -->
			<div class="row no-gutters">
				<div class="col col-12 col-xl-3 col-lg-3 d-none d-xl-block d-lg-block">
					<ul class="list-group text-center mr-4 rounded h-100">
						<li class="list-group-item border-0 p-0 my-color "><span class="mdi mdi-feather mdi-36px"></span></li>
						<li :class="[{'my-acitve':e === sidebarActive ?  true:false},`${sidebarClass}`] " @click="push(i.href,e)" v-for="(i,e) in sidebar"
						 :key="i.id">
							<span class="mdi mdi-gamepad-down"></span>
							<span v-text="i.title"></span>
						</li>
					</ul>
				</div>

				<div class="col">
					<router-view></router-view>
				</div>

			</div>

			<!--
				*-*-*-*-*-* 
					底部jumbotron
				*-*-*-*-*-* 
			 -->

			<div>
				<div class="jumbotron jumbotron-fluid m-0 fixed-bottom bg-dark text-white rounded-up py-0 d-none d-xl-block">
					<div class="container">
						<b-row>
							<b-col>
								<b-alert class="text-center my-pointer my-0" variant="white" show>
									<div @mouseenter="jumbotronShow = !jumbotronShow">
										只要你足够好,你想要的都会来找你
									</div>
								</b-alert>
							</b-col>
						</b-row>

						<el-collapse-transition>
							<div v-show="jumbotronShow">
								<b-row>
									<b-col v-for="n in 4" :key='n'>
										<div class="card">
											<div class="card-body py-0 ">
												<blockquote class="blockquote m-0">
													<footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>
												</blockquote>
											</div>
										</div>
									</b-col>
								</b-row>
							</div>
						</el-collapse-transition>

					</div>
				</div>


			</div>
		</div>

	</div>
</template>

<script>
	import f from '@/global/utils/commjs.js'
	export default {
		methods: {
			push(url, index) {
				this.sidebarActive = index
				f.push(url, this)
			}
		},
		data() {
			return {
			/* 
				 * - * - * - * - - * - * - * - * - - * - * - * - * - - * - * - * - * -
										  左侧导航列表 
				* - * - * - * - - * - * - * - * - - * - * - * - * - - * - * - * - * -
			 */
				sidebarActive: 0,
				sidebarClass: 'list-group-item my-index-side-nav border-0 rounded-30  my-3 my-bgcolor d-flex mx-4  justify-content-around',
				sidebar: [{
						id: 1,
						title: '主页',
						href: '/home/main'
					},
					{
						id: 2,
						title: '作品',
						href: '/home/works'
					},
					{
						id: 3,
						title: 'About',
						href: '/home/resume'
					},
				],
				jumbotronShow: false
			}
		}
	}
</script>

<style scoped>
	@import url("../../global/interaction/bootstrap.css");
</style>
<style scoped lang="less">
	.rounded-bottom {
		border-bottom-right-radius: 60px !important;
		border-bottom-left-radius: 60px !important;
	}

	.my-pointer {
		cursor: pointer;
	}

	.rounded-up {
		border-top-left-radius: 60px !important;
		border-top-right-radius: 60px !important;
	}

	.rounded-30 {
		border-radius: 30px;
	}

	.my-bgcolor {
		// background-color: #47d6d6;
		// background-color: #F8FFFF;
		background-color: #cbf9ff;
	}

	.my-bgcolor-light {
		background-color: #e6ffff;
	}

	.my-link-color {
		color: #008169;
	}

	.my-color {
		color: #47d6d6;
	}

	.my-index-side-nav:hover {
		cursor: pointer;
		background-color: rgba(170, 255, 255, 0.8);
		color: #aa55ff;
		transition: 0.5s;
	}

	.my-bottom-0 {
		bottom: 0px;
	}

	.my-center {
		left: 50%;
		transform: translateX(-50%);
	}

	.my-acitve {
		color: #7446ab;
	}
</style>
