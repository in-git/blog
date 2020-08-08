<template>
	<div>
		<v-container>
			<!-- 选项卡 -->
			<v-tabs v-model="tab" grow>
				<v-tab>导航列表管理</v-tab>
				<v-tab>非关系信息管理</v-tab>
				<v-tab>轮播图管理</v-tab>
				<v-tab @click="initGithub">Github管理</v-tab>

			</v-tabs>

			<v-tabs-items v-model="tab">

				<!--======================================
								  修改导航列表
					======================================-->
				<v-tab-item>
					<v-card flat>

						<v-row>
							<v-col md=10 lg=12 xl=12>
								<v-card elevation=0>
									<weblist></weblist>
								</v-card>
							</v-col>
						</v-row>
					</v-card>
				</v-tab-item>

				<!--======================================
								  座右铭管理
					======================================-->
				<v-tab-item>
					<v-card flat>
						<v-row justify="center">
							<v-col md=10 lg=6>
								<template>
									<v-card elevation=0>
										<v-img class="white--text align-end" height="150px" src="@/assets/home/docks.jpg">
											<v-card-title>总访问人数{{redis.view}}</v-card-title>
										</v-img>

										<v-card-subtitle class="pb-0">座右铭管理</v-card-subtitle>


										<v-row>
											<v-col>
												<div class="d-flex flex-column">
													<v-card class="pa-4" elevation=0>
														<div class="d-flex ">
															<v-text-field prepend-icon="mdi-flower-poppy" flat messages="座右铭1" dense v-model="redis.motto1" label="请输入座右铭"
															 solo-inverted></v-text-field>
															<v-btn class="ml-2" outlined color="purple" @click="updateMotto(1,redis.motto1)">修改</v-btn>
														</div>
													</v-card>
												</div>

												<div class="d-flex flex-column">
													<v-card class="pa-4" elevation=0>
														<div class="d-flex">
															<v-text-field prepend-icon="mdi-card-text" flat messages="座右铭2" dense v-model="redis.motto2" label="请输入座右铭"
															 solo-inverted></v-text-field>
															<v-btn class="ml-2" outlined color="purple" @click="updateMotto(2,redis.motto2)">修改</v-btn>
														</div>
													</v-card>
												</div>

												<div class="d-flex flex-column">
													<v-card class="pa-4" elevation=0>
														<div class="d-flex">
															<v-text-field prepend-icon="mdi-flower-tulip-outline" flat messages="座右铭3" dense v-model="redis.motto3"
															 label="请输入座右铭" solo-inverted></v-text-field>
															<v-btn class="ml-2" outlined color="purple" @click="updateMotto(3,redis.motto3)">修改</v-btn>
														</div>
													</v-card>
												</div>

												<div class="d-flex flex-column">
													<v-card class="pa-4" elevation=0>
														<div class="d-flex">
															<v-text-field prepend-icon="mdi-flower-tulip-outline" counter="30" flat messages="3天以内都是新通知" dense
															 v-model="redis.notice" label="更新通知" solo-inverted></v-text-field>
															<v-btn class="ml-2" outlined color="purple" @click="updateNotice">修改</v-btn>
														</div>
													</v-card>
												</div>

												<div class="d-flex flex-column">
													<v-card class="pa-4" elevation=0>
														<div class="d-flex">
															<v-text-field prepend-icon="mdi-flower-tulip-outline" counter="50" flat messages="查看工作经历的密钥" dense
															 v-model="redis.signal" label="设置密钥" solo-inverted></v-text-field>
															<v-btn class="ml-2" outlined color="purple" @click="updateNotice">修改</v-btn>
														</div>
													</v-card>
												</div>
											</v-col>
										</v-row>

									</v-card>
								</template>
							</v-col>

						</v-row>
					</v-card>
				</v-tab-item>
		<!-- ======================================
						修改轮播图
			====================================== -->
				<v-tab-item>
					<v-card elevation=0 flat>
						<v-row>
							<v-col class="mx-auto" xl=8>
								<!-- -*-*-*-*- 扩展面板 -*-*-*-*- -->
								<template>
									<v-expansion-panels v-model="carouselPanel">
										<v-expansion-panel>
											<v-expansion-panel-header>
												<v-card-title class="pa-0">轮播图管理</v-card-title>
											</v-expansion-panel-header>
											<v-expansion-panel-content>
												<v-row class="text-center">
													<v-col cols=4>
														<v-select v-model="selectCarousel" :items="carouselIndex" no-data-text="好像出了点错" rounded solo label="选择"
														 dense></v-select>
													</v-col>
													<v-col>
														<v-text-field v-model="currentImgPath" label="图片路径" dense></v-text-field>
													</v-col>

												</v-row>
												<v-col>
													<v-btn @click="changeCarousel" block>确定</v-btn>
												</v-col>
											</v-expansion-panel-content>
										</v-expansion-panel>
									</v-expansion-panels>
								</template>


								<!-- -*-*-*-*- 图片列表 -*-*-*-*- -->
								<template>
									<v-row>
										<v-col v-for="n in page_arrs" :key="n" class="d-flex child-flex" cols=3>
											<v-card flat tile class="d-flex elevation-0 border-0">
												<v-img @click="copy(n)" :src="n" aspect-ratio="1" class="grey rounded cursor-point">
													<template v-slot:placeholder>
														<div></div>
														<v-row class="fill-height ma-0" align="center" justify="center">
															<v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
														</v-row>
													</template>
												</v-img>
											</v-card>
										</v-col>
									</v-row>
								</template>
								<div>
									<template>
										<div class="text-right">
											<v-pagination v-model="currentPage" :length="arrLength" :total-visible="7" prev-icon="mdi-menu-left"
											 next-icon="mdi-menu-right"></v-pagination>
										</div>
									</template>
								</div>


							</v-col>

						</v-row>

					</v-card>
				</v-tab-item>


				<!--
					======================================
								  Github管理
					======================================
				-->
				<v-tab-item>

					<!--追加，修改-->
					<template>
						<div>
							<v-app-bar color="white black--text accent-4" elevation=0 dense>

								<v-toolbar-title>Github管理</v-toolbar-title>
								<v-spacer></v-spacer>
								<v-btn icon>
									<v-icon color="pink">mdi-heart</v-icon>
								</v-btn>
								<v-btn icon @click="githubVar.alt = !githubVar.alt">
									<v-icon>{{githubVar.alt?'mdi-plus':'mdi-undo-variant'}}</v-icon>
								</v-btn>
							</v-app-bar>
						</div>
					</template>
					<v-row v-if="githubVar.alt">
						<v-col>
							<template>
								<v-data-table hide-default-footer :headers="githubHeads" :items="githubs" :items-per-page="3">
									<template v-slot:item.img="{ item }">
										<v-chip>
											<el-link target="_blank" :href="`${item.img}`">点击访问</el-link>
										</v-chip>
									</template>

									<template v-slot:item.url="{ item }">
										<v-chip>
											<el-link target="_blank" :href="`${item.url}`">点击访问</el-link>
										</v-chip>
									</template>

									<template v-slot:item.address="{ item }">
										<v-chip>
											<el-link target="_blank" :href="`${item.address}`">点击访问</el-link>
										</v-chip>
									</template>

									<template v-slot:item.download="{ item }">
										<v-chip>
											<el-link target="_blank" :href="`${item.download}`">点击访问</el-link>
										</v-chip>
									</template>

									<template v-slot:item.description="{ item }">
										<el-button slot="reference">查看描述</el-button>
										</el-popover>

									</template>


									<template v-slot:item.action="{ item }">
										<div class="text-center">
											<v-menu offset-y>

												<template v-slot:activator="{ on, attrs }">
													<v-btn color="primary" dark v-bind="attrs" v-on="on">
														操作
													</v-btn>
												</template>

												<v-list>

													<v-list-item>
														<v-list-item-title>
															<v-btn color="blue" @click="openGithub(item)">更新</v-btn>
														</v-list-item-title>
													</v-list-item>

													<v-list-item>
														<v-list-item-title>
															<v-btn color="pink" @click="deleteGithub(item)">删除</v-btn>
														</v-list-item-title>
													</v-list-item>

												</v-list>
											</v-menu>
										</div>
									</template>
								</v-data-table>
							</template>

						</v-col>
					</v-row>

					<!--追加，修改-->
					<v-row v-if="!githubVar.alt">
						<v-col cols=4 class="mx-auto">

							<v-form ref="form" v-model="githubRules.valid" :lazy-validation="false">
								<v-text-field outlined v-model="github.title" :counter="10" :rules="githubRules.rules" label="标题" required></v-text-field>

								<v-text-field outlined v-model="github.img" :rules="githubRules.rules" label="图片地址" required></v-text-field>

								<v-text-field outlined v-model="github.download" :rules="githubRules.rules" label="下载压缩包" required></v-text-field>

								<v-text-field outlined v-model="github.address" :rules="githubRules.rules" label="克隆地址" required></v-text-field>

								<v-text-field outlined v-model="github.url" :rules="githubRules.rules" label="Github主页" required></v-text-field>

								<v-textarea outlined :counter="120" no-resize v-model="github.description" label="描述信息" hint="对Git作品进行描述"></v-textarea>

								<v-btn @click="addGithub" block color="pink" v-if="githubVar.alt">添加</v-btn>
								<v-btn @click="updateGithub" block color="pink" v-if="!githubVar.alt">更新</v-btn>
							</v-form>
						</v-col>
					</v-row>
				</v-tab-item>
			</v-tabs-items>
		</v-container>

	</div>
</template>

<script>
	import homejs from '@/module/index/home/attr/homeJs.js'
	export default homejs
</script>

<style scoped>
	.cursor-point {
		cursor: pointer;
	}
</style>
