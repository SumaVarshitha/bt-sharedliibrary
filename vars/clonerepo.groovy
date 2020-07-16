def call(url) {
     
	 sh 'rm -rf assessmentdocker' 
	sh 'git clone ${urllink}'
          
  }
