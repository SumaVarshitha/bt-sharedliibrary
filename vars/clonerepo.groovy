def call(url) {
	def url=urllink
     
	 sh 'rm -rf assessmentdocker' 
	sh 'git clone ${url}'
          
  }
