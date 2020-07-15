<template>
	<div>
		个人简历
	</div>
</template>

<script>
	export default {
		beforeRouteEnter(to, from, next) {

			next(vm => {
				
				vm.$confirm('请联系本人查看', {
					confirmButtonText: '好的',
					cancelButtonText: '不了',
					type: 'warning',
					center: true
				}).then(() => {
					vm.$message({
						type: 'success',
						message: '删除成功!'
					});
				}).catch(() => {
					vm.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
				return false
			}
			
			)
		}
	}
</script>

<style scoped>

</style>
