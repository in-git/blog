<template>
	<div>
		<!--
			===================
				a.日志操作
			=================== 
		 -->
		<div>
			<v-alert dense class="ma-0 ">
				<div class="d-flex justify-space-between">
					
					<div>
						<v-chip outlined class="mx-2" small label>{{'共'+totalPage+'条记录'}}</v-chip>
						<v-btn text small class="mx-2" color="blue" outlined @click="prePage">上一页</v-btn>
						<v-btn text small class="mx-2" color="blue" outlined @click="nextPage">下一页</v-btn>
					</div>
					
					<div>
						<v-btn text small color="pink" outlined @click="refleshLog">刷新日志</v-btn>
						<v-btn text small color="pink" class="mx-2" outlined @click="clearLog">清空日志</v-btn>
					</div>
					
				</div>

			</v-alert>
		</div>

		<!--
			===================
				a.日志内容
			=================== 
		 -->
		<v-simple-table>
			<template v-slot:default>
				
				<thead>
					<tr>
						<th class="text-center">日志内容</th>
					</tr>
				</thead>
				
				<tbody>
					<tr v-for="(e,i) in com_logs" :key="i">
						<td class="text-center">{{ e }}</td>
					</tr>
				</tbody>
				
			</template>
		</v-simple-table>
	</div>
</template>

<script>
	import attrLog from '../attr/attrLog.js'
	export default attrLog
</script>

<style scoped>

</style>
