<template>
	<div>

		<div class="row text-center text-truncate">
			<!--
				*-*-*-*-*-* 
					左区
				*-*-*-*-*-* 
			 -->
			<div class="col col-12 col-xl-6 col-lg-12 ">

				<div class="row">
					<div class="col px-0">
						<b-alert show variant="primary" class="m-0">结构概览</b-alert>
					</div>
				</div>

				<div class="row my-bgcolor-1">
					<div class="col ">
						<!--
							*-*-*-*-*-* 
								数据库
							*-*-*-*-*-* 
						 -->
						<div class="d-flex flex-column">

							<div>
								<img src="@/global/img/website/mysql.svg">
								<img src="@/global/img/website/alter.svg" class="mx-4">
								<img src="@/global/img/website/redis.svg" alt="">
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
				<div class="row my-bgcolor-2">
					<div class="col text-center">
						<el-popover placement="left" title="服务器类型" width="200" trigger="hover" content="后台管理系统">
							<el-button slot="reference" type="text"><img src="@/global/img/website/serve-admin.svg"></el-button>
						</el-popover>
					</div>
					<div class="col text-center">
						<el-popover placement="right" title="服务器类型" width="200" trigger="hover" content="前端展示内容">
							<el-button slot="reference" type="text"><img src="@/global/img/website/serve-client.svg"></el-button>
						</el-popover>
					</div>
				</div>
				<!--
				*-*-*-*-*-* 
					静态页面
				*-*-*-*-*-* 
			 -->
				<div class="row my-bgcolor-1">

					<div class="col">
						<div class="d-flex justify-content-center">
							<img src="@/global/img/website/db-arrow.svg">
						</div>
						<div class="">
							<el-popover placement="left" title="网页类型" width="200" trigger="hover" content="后台管理页面">
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
							<el-popover placement="top-start" title="标题" width="200" trigger="hover" content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
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
							<img src="@/global/img/website/nginx.svg" class="pt-1">
							<img src="@/global/img/website/db-arrow.svg" class="pt-1">
						</div>
					</div>
				</div>

				<!--
						*-*-*-*-*-* 
							用户请求
						*-*-*-*-*-* 
					 -->
				<div class="row my-bgcolor-2">
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
			<div class="col col-12 col-xl-6 col-lg-12 text-center">
				<div class="row">
					<div class="col">
						<b-alert show variant="primary" class="m-0">设计过程</b-alert>
					</div>
				</div>
				<!--
					*-*-*-*-*-* 
						结构设计
					*-*-*-*-*-* 
				 -->
				<div class="row">
					<div class="col">
						<el-tabs type="">
							<el-tab-pane>
								<span slot="label"><i class="el-icon-date"></i> 结构设计</span>
								<div class="col">
									<div>
										<img src="@/global/img/website/struct.webp" class="img-fluid rounded">
									</div>
								</div>
							</el-tab-pane>
							<el-tab-pane label="UI设计">
								<b-alert show variant="light" class="m-0 text-left">UI设计</b-alert>
							</el-tab-pane>
						</el-tabs>
					</div>
				</div>
				<!--
					*-*-*-*-*-* 
						UI设计
					*-*-*-*-*-* 
				 -->
				<div class="row">
					<div class="col">


					</div>
				</div>
			</div>
		</div>

	</div>
</template>

<script>
	export default {

	}
</script>

<style lang="less" scoped>
	.display-5 {
		font-size: 24px;
	}

	.my-border-bottom {
		border-bottom: rgba(170, 255, 255, 1) 4px solid;
	}

	.el-button:focus {
		outline: none !important;
	}

	.my-bgcolor-1 {
		background-color: rgba(170, 255, 255, 0.05) !important;
	}

	.my-bgcolor-2 {
		background-color: rgba(148, 189, 255, 0.1) !important;
	}
</style>
