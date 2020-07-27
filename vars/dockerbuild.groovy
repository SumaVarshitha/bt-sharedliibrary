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
        def logContent = Jenkins.getInstance()
                            .getItemByFullName(env.JOB_NAME)
                              .getBuildByNumber(
                              Integer.parseInt(env.BUILD_NUMBER))
                              .logFile.text
                        // copy the log in the job's own workspace
                      writeFile file: "buildlog.txt", text: logContent
        def version = readFile "${WORKSPACE}/buildlog.txt"
        echo version
        /* def jsonSlurper = new JsonSlurper()
 def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/result.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
        echo resultJson*/
}
            
