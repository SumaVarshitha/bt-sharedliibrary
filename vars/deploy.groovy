
def call(String msg = 'deploy') {
echo "${msg}"
   sh 'curl http://18.216.136.124:8080//manager/text/undeploy?path=/bunny -u admin:admin'
   sh 'curl -v -u admin:admin -T target/java-webapp.war http://18.216.136.124:8080//manager/text/deploy?path=/bunny'
		
		
}
