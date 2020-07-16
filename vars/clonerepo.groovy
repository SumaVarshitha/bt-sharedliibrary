def call(urllink) {
	echo urllink
	def url = urllink
     
	 sh 'rm -rf assessmentdocker' 
	sh 'git clone "${url}"'
          
  }
