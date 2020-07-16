<!--
	*-*-*-*-*-* 
		第一页:常用网页，本站简述 
	*-*-*-*-*-*
 -->

<template>
	<div class="h-100">
		<b-row no-gutters>
			<b-col cols=12 xl=5 class="mx-auto">
				<div>
					<b-carousel id="carousel-fade" fade indicators img-width="1024" img-height="480">
						<b-carousel-slide caption="First slide" img-src="https://picsum.photos/1024/480/?image=10"></b-carousel-slide>
						<b-carousel-slide caption="Second Slide" img-src="https://picsum.photos/1024/480/?image=12"></b-carousel-slide>
						<b-carousel-slide caption="Third Slide" img-src="https://picsum.photos/1024/480/?image=22"></b-carousel-slide>
					</b-carousel>
				</div>
				<div>
					<el-divider content-position="left">本站简述</el-divider>
					<b-alert class="border-left-5 border-left my-bgcolor p-2 mb-2" show v-for="n in 3" :key="n">弹指间丶千年逝 一袭广袖玄衣 一砚清绝酒辞</b-alert>
				</div>

				<div>
					<el-divider content-position="left">常用工具</el-divider>
					<div class="row">
						<div class="col d-flex">
							<el-input size="mini" placeholder="请输入内容" clearable v-model="input1">
								<template slot="prepend">md5加密</template>
							</el-input>
							<el-button size="mini">提交</el-button>
						</div>
					</div>
				</div>
			</b-col>

			<b-col cols=12 xl=6>
				<!--
					
					   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
					                 常用网页
					   -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
					  
				 -->
				<b-alert show variant="light" class="blockquote-footer m-0">
					<span class="mdi mdi-near-me mr-2"></span>
					<span>常用网页</span>
				</b-alert>

				<div>
					<b-row no-gutters cols=3>
						<b-col v-for="n in nav" :key="n.id" class="mb-3 text-center">

							<el-popover placement="top-start" :title="n.tipsTitle" trigger="hover" :content="n.tips">

								<el-button @click="push(`${n.href}`)" slot="reference" size=small class="my-button-link">
									<span :class="['mdi',`${n.icon}`,'mx-1', 'my-color']"></span>
									<small class="mx-1" v-text="n.name"></small>
								</el-button>

							</el-popover>

						</b-col>
					</b-row>
				</div>

				<!--
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  Github
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				 -->
				<b-alert show variant="light" class="blockquote-footer m-0">
					<span class="mdi mdi-gitlab mr-2"></span>
					<span>Github</span>
				</b-alert>

				<div>
					<div class="card border-0 mb-2" v-for="i in github" :key="i.url">
						<b-row no-gutters>
							<b-col cols="6" sm=3 md=5 xl=4 class="pr-2">
								<div class="d-flex justify-content-center">
									<b-img :src="i.img" fluid alt="Fluid image" rounded></b-img>
								</div>
							</b-col>

							<b-col>
								<div>
									<h6 class="font-weight-bold text-center m-0" v-text="i.title"></h6>
									<div class="px-2">
										<small v-text="i.description"></small>

										<!--
										 	-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
										 				  复制下载功能
										 	-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
										  -->
										<p>
											<span class="mx-2">
												<el-link slot="reference" :underline="false" type="primary" class="el-icon-view el-icon--right" :href="i.address">访问</el-link>
											</span>
											<span class="mr-2">
												<el-link type="primary" :href="i.download" :underline="false">下载</el-link>
											</span>
											<span class="mx-2">
												<el-tooltip class="item" effect="light" content="复制克隆" placement="right">
													<el-button @click="gitCopy(i.url)" class="no-outline" size="mini" type="primary" icon="el-icon-mobile"
													 circle>
													</el-button>
												</el-tooltip>
											</span>
										</p>

									</div>
								</div>

							</b-col>
						</b-row>
					</div>

				</div>
			</b-col>
		</b-row>

	</div>
</template>

<script>
	import attr from '@/module/index/main/attr/main.js'
	export default attr
</script>

<style scoped>
	@import url("./css/main.css");
</style>
