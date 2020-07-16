<template>
	<div>
		<v-container fluid>
			<v-row>
				<v-col md=10 lg=12 xl=12>
					<div class="pb-4">
						<el-card class="box-card border-0">
							<span>首页管理</span>
							<el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
						</el-card>
					</div>
				</v-col>
			</v-row>

			<!--
			
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  座右铭管理
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			
			-->
			<v-row>
				<v-col md=10 lg=6 xl=5>
					<template>
						<v-card>
							<v-img class="white--text align-end" height="150px" src="@/assets/home/docks.jpg">
								<v-card-title>总访问人数{{redis.view}}</v-card-title>
							</v-img>

							<v-card-subtitle class="pb-0">座右铭管理</v-card-subtitle>

							<v-card-text class="text--primary">
								<v-row>
									<v-col cols=9>
										<v-text-field prepend-icon="mdi-flower-poppy" counter="30" flat messages="座右铭1" dense v-model="redis.motto1"
										 label="请输入座右铭" solo-inverted></v-text-field>
									</v-col>
									<v-col>
										<v-btn @click="updateMotto(1,redis.motto1)">修改</v-btn>
									</v-col>
								</v-row>
								<v-row>
									<v-col cols=9>
										<v-text-field prepend-icon="mdi-card-text" counter="30" flat messages="座右铭2" dense v-model="redis.motto2"
										 label="请输入座右铭" solo-inverted></v-text-field>
									</v-col>
									<v-col>
										<v-btn @click="updateMotto(2,redis.motto2)">修改</v-btn>
									</v-col>
								</v-row>
								<v-row>
									<v-col cols=9>
										<v-text-field prepend-icon="mdi-flower-tulip-outline" counter="30" flat messages="座右铭3" dense v-model="redis.motto3"
										 label="请输入座右铭" solo-inverted></v-text-field>
									</v-col>
									<v-col>
										<v-btn @click="updateMotto(3,redis.motto3)">修改</v-btn>
									</v-col>
								</v-row>
							</v-card-text>

						</v-card>
					</template>
				</v-col>

				<!--
				
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  加载轮播图
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				
				-->
				<v-col>
					<!--
					
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									  修改轮播图
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
					
					-->

					<template>
						<v-expansion-panels>
							<v-expansion-panel>
								<v-expansion-panel-header>
										<v-card-title class="pa-0">轮播图管理</v-card-title>
								</v-expansion-panel-header>
								<v-expansion-panel-content>
									<v-row>
										<v-col v-for="(e,i) in carousel" :key="i" cols=5 xl=6 lg=12>
											<div class="d-flex justify-content-between">
												<el-input v-model="carousel[i]" placeholder="请输入内容">
													  <template slot="prepend">第{{i+1}}个轮播图</template>
												</el-input>
												<el-button round size="medium" class="ml-4">确定</el-button>
											</div>
										</v-col>
									</v-row>

								</v-expansion-panel-content>
							</v-expansion-panel>
						</v-expansion-panels>
					</template>

					<template>
						<v-row>
							<v-col cols="12">
								<v-container fluid>
									<v-row>
										<v-col v-for="n in page_arrs" :key="n" class="d-flex child-flex" cols=3>
											<v-card flat tile class="d-flex elevation-0 border-0">
												<v-img @click="copy(n)" :src="n" aspect-ratio="1" class="grey rounded ">
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
								</v-container>
							</v-col>
						</v-row>
					</template>
					<div>
						<template>
							<div class="text-right">
								<v-pagination v-model="currentPage" :length="arrLength" :total-visible="7" prev-icon="mdi-menu-left" next-icon="mdi-menu-right"></v-pagination>
							</div>
						</template>
					</div>


				</v-col>
			</v-row>

		</v-container>

	</div>
</template>

<script>
	import homejs from '@/module/index/attr/homeJs.js'
	export default homejs
</script>

<style scoped>

</style>
