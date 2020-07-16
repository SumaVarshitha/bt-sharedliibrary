def call(urllink) {
	def url = ${urllink}
     
	 sh 'rm -rf assessmentdocker' 
	sh 'git clone ${url}'
          
  }
