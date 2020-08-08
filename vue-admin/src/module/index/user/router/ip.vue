<template>
	<div>
		<!-- 
		===================
			a.对IP进行操作
		=================== 
		-->
		<div>
			<v-card elevation=0>
				<div class="d-flex justify-space-between">
					<v-card-text class="pb-0">
						
						<div>
							<v-btn outlined small color="pink">上一页</v-btn>
							<v-btn outlined small color="success" class="mx-2" @click="nextPage" disabled="com_nextPage">下一页</v-btn>
							<div class="d-inline">
								共<span class="pink--text mx-1">{{totalCount}}</span>条
							</div>
						</div>
						
					</v-card-text>
				</div>
			</v-card>
				
		</div>
		
		<!--
		===================
			a.IP列表渲染
		=================== 
		-->
		<div>
			<v-data-table :headers="headers"  hide-default-footer :items="com_ips">
				
				<template v-slot:item.action="{ item }">
					<v-btn color="pink" outlined @click="deleteIp(item.ip)" v-model="item.action">删除</v-btn>
				</template>
				
			</v-data-table>
		</div>
		
	</div>
</template>

<script>
	import attrIp from '../attr/attrIp.js'
	export default attrIp
	
</script>
