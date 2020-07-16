new Vue({
	el: '#app',
	vuetify: new Vuetify(),
	data: {
		drawer: false,
		dialog: false,
		rules: [
			value => !!value || '必须填写.',
		],
		user: {
			username: '',
			passwd: ''
		},
		valid: true
	},
	methods: {
		register() {

		},
		validate() {
			this.$refs.form.validate()

			console.log('执行', this.valid);
			axios.get('/public/mysql').then(data => {
				console.log(data);
			}).catch(err=>{
				console.log(err);
			})



		},
	},

})
