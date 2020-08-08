<template>
	<div>
		<!--
			===================
				a.用户列表渲染
			=================== 
		 -->
		<v-row v-if="action">
			<v-col>
				<template>
					<v-data-table hide-default-footer :headers="usersHeaders" :items="usersList">
						<template v-slot:item.action="{ item }">
							<div class="text-center">
								<v-menu offset-y>
									<template v-slot:activator="{ on, attrs }">
										<v-btn color="primary" dark v-bind="attrs" v-on="on">
											操作
										</v-btn>
									</template>
									<v-list flat>
										<v-list-item>
											<el-button @click="beforeUpdateUser(item)" type="text">更新</el-button>
										</v-list-item>
										<v-list-item>
											<el-button @click="deleteUser(item.id)" type="text">删除</el-button>
										</v-list-item>
									</v-list>
								</v-menu>
							</div>
						</template>

						<template v-slot:item.black="{ item }">
							{{item.black == true ? '是':'否'}}
						</template>

						<template v-slot:item.ukey="{ item }">
							<v-alert dense text elevation=0 tile color="info" class="text-truncate ma-0">
								<div contenteditable>{{item.ukey}}</div>
							</v-alert>
						</template>
					</v-data-table>
				</template>
			</v-col>
		</v-row>
		<!-- 
			===================
					修改
			=================== 
		 -->
		<v-row justify='center' v-if="!action">
			<v-col cols=6>

				<div>
					<v-alert>
						修改用户账号密码
					</v-alert>
				</div>

				<div class="d-flex flex-column">
					<v-text-field v-model="userInfo.username"  dense label="登录账号" outlined></v-text-field>
					<v-text-field v-model="userInfo.passwd" dense type="password" label="登录密码" outlined></v-text-field>	
					<v-text-field v-model="userInfo.ukey" dense type="text" label="UKEY" outlined></v-text-field>
					<div><v-checkbox v-model="userInfo.black" dense class="ma-0" label="账户禁用"></v-checkbox></div>
					<v-btn @click="updateUser" outlined color="blue" block >修改</v-btn>
				</div>
			</v-col>
		</v-row>

	</div>
</template>

<script>
	import attrUser from '../attr/attrUser.js'
	export default attrUser
</script>

<style scoped>

</style>
