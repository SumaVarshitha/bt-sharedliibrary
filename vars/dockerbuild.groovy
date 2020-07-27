//import groovy.json.*
//import groovy.json.JsonSlurper
def call(dockerimage,mavenBuild) 
{
        echo dockerimage
        echo mavenBuild
        def dimage = dockerimage
        def mBuild = mavenBuild
        docker.image("${dockerimage}").inside(){
          sh "${mBuild}"
        }
        /* def jsonSlurper = new JsonSlurper()
 def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/result.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
        echo resultJson*/
}
            
