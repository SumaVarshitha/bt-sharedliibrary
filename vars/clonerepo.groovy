/*def call(urllink) {
	echo urllink
	def url = urllink
     
	sh 'rm -rf assessmentdocker' 
	sh "git clone ${url}"
          
  }*/
def call(body) {    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
def url = config.url ?: ''
	sh 'rm -rf assessmentdocker' 
	sh "git clone ${url}"
}
	
