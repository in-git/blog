<template>
	<div>
		<v-container>
			<v-row no-gutters>
				<v-col cols=10 lg=10 class="mx-auto"	>
					<!--
					
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									  顶部增加
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
					
					-->
					<v-alert class="ma-0 ">
						<div class="d-flex justify-space-between ">
							<div>
								<el-tooltip class="item " effect="light" content="管理网页导航" placement="right">
									<el-button class="black--text" type="text">网页导航</el-button>
								</el-tooltip>
							</div>
							<div>
								<v-dialog max-width="500" persistent v-model="dialog.addDialog">
									<template v-slot:activator="{ on, attrs }">
										<v-btn small fab dark color="indigo" v-bind="attrs" v-on="on">
											<v-icon dark>mdi-plus</v-icon>
										</v-btn>
									</template>
									<v-card>
										<v-card-title class="headline grey lighten-2" primary-title>
											添加列表
										</v-card-title>
										<div class="pa-4">
												<v-row >
													<v-col cols=12>
														<v-text-field counter="20" v-model="weblist.name" label="网页名字"></v-text-field>
													</v-col>
													<v-col cols=12>
														<v-text-field disabled counter="10" v-model="weblist.tipsTitle" label="提示标题"></v-text-field>
													</v-col>
													<v-col cols=12>
														<v-text-field counter="30" v-model="weblist.tips" label="提示内容"></v-text-field>
													</v-col>
													<v-col cols=12>
														<v-text-field counter="100" v-model="weblist.href" label="网址"></v-text-field>
													</v-col>
													<v-col cols=12>
														<v-text-field counter="40" v-model="weblist.icon" label="图标"></v-text-field>
													</v-col>
								
												</v-row>
												<v-row no-gutters>
													<v-col cols=8>
														<v-btn outlined block color="green" @click="addWeblist()">提交</v-btn>
													</v-col>
													<v-col>
														<v-btn  @click="dialog.addDialog = !dialog.addDialog" block color="red">关闭</v-btn>
													</v-col>
												</v-row>
										</div>
								
									</v-card>
								</v-dialog>
																	

							</div>
						</div>

					</v-alert>

				</v-col>
			</v-row>

			<!--
			
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  表格渲染
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			
			-->
			<v-row>
				<v-col cols=10 lg=10 class="mx-auto">
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
								<tr v-for="item in weblists" class="text-center text-truncate" :key="item.id">
									<td>{{ item.id }}</td>
									<td>{{ item.name }}</td>
									<td>{{ item.tipsTitle }}</td>
									<td>{{ item.tips }}</td>
									<td class="text-truncate">
										<el-link target="_blank" :href="item.href">{{ item.href }}</el-link>
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
						<v-row >
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
								<v-btn outlined block color="green" @click="updateWeblist()">提交</v-btn>
							</v-col>
							<v-col>
								<v-btn outlined @click="dialog.updateDialog = !dialog.updateDialog" block color="red">关闭</v-btn>
							</v-col>
						</v-row>
				</div>
			</el-dialog>
		</div>
	</div>
</template>
<script>
	export default {
		name: 'weblist',
		methods: {
			/*
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  根据ID查询
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			 */
			selectById() {
				console.log(this.selectId);
				let tmp = this.weblists.find(e => {
					return e.id == this.selectId
				})
				console.log(tmp);
			},

			/* 
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  添加网页列表
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			 */
			addWeblist() {
				this.$get('/user/addWeblist', this.weblist).then(data => {

					switch (Number(data.sys_status)) {
						case 40:
							{
								this.$message("添加成功");
								this.weblists.push(this.weblist)
								break;
							}
						case -40:
							{
								this.$message("添加失败");
								break;
							}
					}
					window.location.reload()
				}).catch(err => {
					this.$message("添加失败");
				})
				this.dialog.addDialog = false
			},
			/*
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  删除网页列表
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			 */
			deleteWeblist(id) {

				this.$get('/user/deleteWeblistById/'.concat(id.toString())).then(data => {
					console.log(this.weblists);
					if (data.sys_status == 30) {
						this.weblists = this.weblists.filter(e => {
							return e.id != id
						})
						this.$message("删除成功");
					}
					if (data.sys_status == -30) {
						this.$message("删除失败");
					}
					this.dialog.deleteDialog = false
				})
			},
			/*
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  打开更新对话框
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			 */
			openDialog(id) {
				let tpmList = this.weblists.filter(e => {
					return e.id == id
				})
				this.weblist = tpmList[0]
				this.dialog.updateDialog = true

			},
			/*
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  更新网页列表
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			 */
			updateWeblist() {
				console.log(this.weblist);
				this.$get("/user/updateWebList", this.weblist).then(data => {
					this.$message("更新成功")
					this.dialog.updateDialog = false
					console.log(data);
				}).catch(err => {
					this.$message("更新失败")
					this.dialog.updateDialog = true
				})
			},

			/*
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
							  关闭对话框之前
				-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
			 */
			handleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						this.dialog.updateDialog = false
						done();
					})
					.catch(_ => {});
			}
		},
		mounted() {
			this.$get('/user/getWeblist').then(data => {
				this.weblists = data
			}).catch(err => {
				this.$alert('与服务器连接失败', '提示', {
					confirmButtonText: '确定'
				});
			})
		},
		computed: {
			com_weblist: {
				get() {
					return this.weblist
				},
				set(newVal) {
					this.weblist = newVal
				}
			}
		},

		data: () => ({
			dialog: {
				updateDialog: false,
				addDialog: false
			},
			weblist: {
				icon: '',
				tips: '',
				tipsTitle: '提示',
				name: '',
				href: ''
			},
			weblists: [],
			selectId: ''
		}),

	}
</script>
<style scoped="scoped">
	.v-application .v-alert {
		margin-bottom: 0 !important;
	}

	.black--text {
		color: #000000 !important;
	}

	th {
		text-align: center !important;
	}
</style>
