def call(dockerimage,mavenBuild) 
{
        echo dockerimage
        echo mavenBuild
        def dimage = dockerimage
        def mBuild = mavenBuild
        docker.image("${dockerimage}").inside(){
          sh "${mBuild} -o result.txt"
        }
         def jsonSlurper = new JsonSlurper()
 def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/result.txt"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
        echo resultJson
}
            
