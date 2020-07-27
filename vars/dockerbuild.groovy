
def call(dockerimage,mavenBuild) 
{
        echo dockerimage
        echo mavenBuild
        def dimage = dockerimage
        def mBuild = mavenBuild
        def test = ''
        docker.image("${dockerimage}").inside(){
          test = sh "${mBuild}"
                writeFile file: "buildlog.txt", text: test
        }
                 def version = readFile "${WORKSPACE}/buildlog.txt"
       echo version
                
        
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
            
