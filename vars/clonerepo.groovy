def call(url) {
     def urllink = url
	 sh 'rm -rf assessmentdocker' 
	sh 'git clone "${urllink}"'
          
  }
