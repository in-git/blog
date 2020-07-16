/* 
	文件功能:公共方法 
 */
let f = {
	/* 
		功能:url跳转
		参数:目标url
		注意:需要传全路径
	 */
	push: (url, that) => {
		if (that.$route.path != url)
			that.$router.push(url)
	},

	/* 
		功能：点击复制
	 */
	copy: content => {
		var input = document.createElement("input");
		input.value = content;
		document.body.appendChild(input);
		input.select();
		document.execCommand("Copy");
		document.body.removeChild(input);
	}
}
export default f
