def call(giturl)
{
	def url=giturl
                sh 'rm -rf assessmentdocker' 
	sh 'git clone ${url}'
          
  }
