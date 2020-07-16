def call(urllink) {
     
	 sh 'rm -rf assessmentdocker' 
	sh 'git clone ${urllink}'
          
  }
