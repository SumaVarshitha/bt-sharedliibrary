
def call(dockerimage,mavenBuild) 
{
        echo dockerimage
        echo mavenBuild
        def dimage = dockerimage
        def mBuild = mavenBuild
        
        docker.image("${dockerimage}").inside(){
         sh "${mBuild} > output.txt"
               // test = sh (script: "${mBuild}",returnStdout: true).trim()
                
                 
                
        }
       // echo test
              
        def buildlog = readFile "${WORKSPACE}/output.txt"
     // echo buildlog
        if (buildlog.contains(Dependency-reduced)) {
    println "${job.name}: ${build.id}"
  }
       /* if(grep -w "Dependency-reduced" ${WORKSPACE}/output.txt)
        {
                echo yes
        }
        else
        {
                echo no
        }*/
        
                
        
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
            
