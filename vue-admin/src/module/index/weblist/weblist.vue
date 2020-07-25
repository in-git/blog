<template>
	<div>
		<v-container >
			<v-row no-gutters>
				<v-col>
					<!--
					
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									  顶部增加查询
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
					
					-->
					<div class="d-flex justify-space-between px-4 rounded elevation-1 py-4">
						<div>
							<el-tooltip class="item " effect="light" content="管理网页导航" placement="right">
								<el-button class="black--text" type="text">网页导航</el-button>
							</el-tooltip>
						</div>


						<div>

							<template>
								<div class="text-center">
									<v-dialog persistent v-model="dialog.addDialog" width="500">
										<template v-slot:activator="{ on, attrs }">
											<v-btn small fab dark color="indigo" v-bind="attrs" v-on="on">
												<v-icon dark>mdi-plus</v-icon>
											</v-btn>
										</template>

										<v-card>
											<v-card-title class="headline grey lighten-2" primary-title>
												添加列表
											</v-card-title>
											<div>
												<v-container>
													<v-row no-gutters>
														<v-col cols=12>
															<v-text-field counter="10" v-model="weblist.name" label="网页名字"></v-text-field>
														</v-col>
														<v-col cols=12>
															<v-text-field disabled counter="10" v-model="weblist.tipsTitle" label="提示标题"></v-text-field>
														</v-col>
														<v-col cols=12>
															<v-text-field  counter="30" v-model="weblist.tips" label="提示内容"></v-text-field>
														</v-col>
														<v-col cols=12>
															<v-text-field counter="30" v-model="weblist.href" label="网址"></v-text-field>
														</v-col>
														<v-col cols=12>
															<v-text-field counter="10" v-model="weblist.icon" label="图标"></v-text-field>
														</v-col>

													</v-row>
													<v-row no-gutters>
														<v-col cols=8>
															<v-btn block color="green" @click="addWeblist()">提交</v-btn>
														</v-col>
														<v-col>
															<v-btn @click="dialog.addDialog = !dialog.addDialog" block color="red">关闭</v-btn>
														</v-col>
													</v-row>
												</v-container>
											</div>

										</v-card>
									</v-dialog>
								</div>
							</template>

						</div>
					</div>
				</v-col>
			</v-row>

			<!--
			
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  表格渲染
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			
			-->
			<v-row>
				<v-col>
					<v-simple-table>
						<template v-slot:default>
							<thead>
								<tr>
									<th class="text-center text-truncate">ID</th>
									<th class="text-center text-truncate">网页名称</th>
									<th class="text-center text-truncate">提示标题</th>
									<th class="text-center text-truncate">提示内容</th>
									<th class="text-center text-truncate">网页连接</th>
									<th class="text-center text-truncate">网页图标</th>
									<th class="text-center text-truncate">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr v-for="item in weblists" class="text-center" :key="item.id">
									<td>{{ item.id }}</td>
									<td>{{ item.name }}</td>
									<td>{{ item.tipsTitle }}</td>
									<td>{{ item.tips }}</td>
									<td>
										<el-link :href="item.href">{{ item.href }}</el-link>
									</td>
									<td><span>{{item.icon}}</span></td>

									<!--
										-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
													  对网页进行删除更新操作
										-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									-->
									<td>
										<v-menu open-on-hover bottom offset-y>
											<template v-slot:activator="{ on, attrs }">
												<v-btn color="orange" dark v-bind="attrs" v-on="on">
													操作
												</v-btn>
											</template>

											<v-list>

												<!--
												 -*-*-*-*-	  更新操作
											-->
												<v-list-item dense>

													<v-list-item-title>
														<div class="text-center">
															<el-button type="text" @click="openDialog(item.id)">更新</el-button>
														</div>
													</v-list-item-title>
												</v-list-item>

												<!--
												 -*-*-*-*-	 删除操作
											-->
												<v-list-item dense>

													<v-list-item-title>
														<v-btn text color="red" @click="deleteWeblist(item.id)">删除</v-btn>
													</v-list-item-title>

												</v-list-item>
											</v-list>
										</v-menu>
									</td>
								</tr>

							</tbody>
						</template>
					</v-simple-table>
				</v-col>
			</v-row>
		</v-container>
		<!--
			 -*-*-*-*-	  更新对话框
		-->
		<div>
			<el-dialog title="提示" :visible.sync="dialog.updateDialog" modal :before-close="handleClose">
				<div>
					<v-container>
						<v-row no-gutters>
							<v-col cols=12>
								<v-text-field v-model="com_weblist.name" label="网页名字"></v-text-field>
							</v-col>
							<v-col cols=12>
								<v-text-field v-model="com_weblist.tipsTitle" label="提示标题"></v-text-field>
							</v-col>
							<v-col cols=12>
								<v-text-field v-model="com_weblist.tips" label="提示内容"></v-text-field>
							</v-col>
							<v-col cols=12>
								<v-text-field v-model="com_weblist.href" label="网址"></v-text-field>
							</v-col>
							<v-col cols=12>
								<v-text-field v-model="com_weblist.icon" label="图标"></v-text-field>
							</v-col>

						</v-row>
						<v-row no-gutters>
							<v-col cols=8>
								<v-btn block color="green" @click="updateWeblist()">提交</v-btn>
							</v-col>
							<v-col>
								<v-btn @click="dialog.updateDialog = !dialog.updateDialog" block color="red">关闭</v-btn>
							</v-col>
						</v-row>
					</v-container>
				</div>
			</el-dialog>
		</div>
	</div>
</template>

<script>
	import weblist from '@/module/index/weblist/attr/weblistJs.js'
	export default weblist
</script>
<style scoped="scoped">
	.v-application .v-alert {
		margin-bottom: 0 !important;
	}

	.black--text {
		color: #000000 !important;
	}
</style>
