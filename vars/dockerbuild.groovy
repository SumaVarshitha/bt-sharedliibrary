
def call(dockerimage,mavenBuild) 
{
        echo dockerimage
        echo mavenBuild
        def dimage = dockerimage
        def mBuild = mavenBuild
        
        docker.image("${dockerimage}").inside(){
        //  sh "${mBuild} > output.txt"
                test = sh (script: "${mBuild} show -s --format=\'%ae\'",returnStdout: true).trim()
                
                 
                
        }
        echo test
              
        //def buildlog = readFile "${WORKSPACE}/output.txt"
     // echo buildlog
       
        
                
        
      /*  def logContent = Jenkins.getInstance()
                            .getItemByFullName(env.JOB_NAME)
                              .getBuildByNumber(
                              Integer.parseInt(env.BUILD_NUMBER))
                              .getStageByName(stage)
                              .logFile.text
                        // copy the log in the job's own workspace
                      writeFile file: "buildlog.txt", text: logContent
      //  def version = readFile "${WORKSPACE}/buildlog.json"
       // echo version*/
        
}
            
