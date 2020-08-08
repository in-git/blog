<template>
	<div>
		<v-app v-if="!pageA">
			<v-alert class="my-0 py-0 border-0">
				<!--
					
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
									  导航
						-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
					
					-->
				<v-row>
					<v-col>
						<h3>留言管理</h3>
					</v-col>
					<v-col cols=4 class="text-right d-flex ">
						<v-text-field v-model="searchName" label="根据名字查询" dense></v-text-field>
						<v-btn @click="searchMessage" color="blue" class="ml-2">查询</v-btn>
					</v-col>
				</v-row>

				<!--
				
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  留言表格
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				
				-->
				<v-row>
					<v-col>
						<template>
							<v-simple-table dense>
								<template v-slot:default>
									<thead>
										<tr class="text-truncate text-center">
											<th>ID</th>
											<th>名字</th>
											<th>留言内容</th>
											<th>喜欢</th>
											<th>VIP</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<tr v-for="item in messages" :key="item.id" class="text-center">
											<td>{{ item.id }}</td>
											<td>{{ item.name }}</td>
											<td class="text-truncate ">{{ item.content }}</td>
											<td>{{ item.love }}</td>
											<td :class="{'pink--text':item.isVip === 1}">{{ item.isVip === 1 ? '是':'否' }}</td>
											<td><template>
													<div class="text-center">
														<v-menu offset-y>
															<template v-slot:activator="{ on, attrs }">
																<v-btn color="pink" dark v-bind="attrs" v-on="on">
																	操作
																</v-btn>
															</template>
															<v-list>
																<v-list-item>
																	<v-list-item-title>
																		<v-btn color="blue" @click="change(item.id)">更新</v-btn>
																	</v-list-item-title>
																</v-list-item>
																<v-list-item>
																	<v-list-item-title>
																		<v-btn color="pink" @click="deleteMessage(item.id)">删除</v-btn>
																	</v-list-item-title>
																</v-list-item>
															</v-list>
														</v-menu>
													</div>
												</template>
											</td>

										</tr>
									</tbody>
								</template>
							</v-simple-table>
						</template>
					</v-col>
				</v-row>
				<v-row>


					<!--
				
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  底部分页追加
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				
				-->
					<v-col>
						<template>
							<div class="text-center">
								<v-pagination v-model="page" value="page" prev-icon="mdi-menu-left" next-icon="mdi-menu-right" :length="total">
								</v-pagination>
							</div>
						</template>
					</v-col>


				</v-row>


			</v-alert>
		</v-app>


		<!--
				
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
								  修改内容
					-*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
				
				-->
		<v-app v-if="pageA">
			<v-alert>
				<el-page-header content="修改页面" @back="goBackHome">
				</el-page-header>
			</v-alert>
			<v-row justify="center">
				<v-col cols=4>
					<v-text-field v-model="message.id" label="修改ID"></v-text-field>
					<v-text-field v-model="message.name" label="修改名字"></v-text-field>

					<v-text-field v-model="message.love" label="修改点赞"></v-text-field>
					<v-text-field v-model="message.isVip" label="修改SVIP"></v-text-field>
					<v-textarea name="message" clearable label="修改留言内容" v-model="message.content"
					  counter=80 no-resize>
					</v-textarea>
					<v-btn block color="purple" @click="updateMessage" outlined>更新</v-btn>
				</v-col>
			</v-row>
		</v-app>
	</div>
</template>

<script>
	import attr from './attr/website.js'
	export default attr
</script>

<style scoped>
	@import url("css/website.css");
</style>
