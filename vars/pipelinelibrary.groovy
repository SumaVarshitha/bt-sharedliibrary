def call(body) {    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
//def call(urllink,dockerimage,mavenBuild,sonarorganization,sonarprojectKey,sonarprojectName){
def urllink = config.urllink ?: ''
def dockerimage = config.dockerimage ?: ''
def mavenBuild = config.mavenBuild ?: ''
def sonarorganization = config.sonarorganization ?: ''
def sonarprojectKey = config.sonarprojectKey ?: ''
def sonarprojectName = config.sonarprojectName ?: ''
def sonarHostUrl = config.sonarHostUrl ?: ''
def sonarprojectVersion = config.sonarprojectVersion ?: ''
def sonarSources = config.sonarSources ?: ''
def sonarLanguage = config.sonarLanguage ?: ''
def sonarBinaries = config.sonarBinaries ?: ''
def sonarjavacoveragePlugin = config.sonarjavacoveragePlugin ?: ''
def sonarcoveragejacocoxmlReportPaths = config.sonarcoveragejacocoxmlReportPaths ?: ''
def sonarExclusions = config.sonarExclusions ?: ''
def sonarsourceEncoding = config.sonarsourceEncoding ?: ''
    def url_link = ''

    

        pipeline {
            agent any
            
            stages {
               
                stage('Code Checkout'){
                    steps{
                        //clonerepo(urllink)
                        clonerepo{
                            url_link = "${urllink}"
                        }
                    }
                }
               
                stage('Build_In_Container'){
                    steps{
                            dockerbuild(dockerimage,mavenBuild)
                       /* script {
                           def logContent = Jenkins.getInstance()
                            .getItemByFullName(env.JOB_NAME)
                              .getBuildByNumber(
                              Integer.parseInt(env.BUILD_NUMBER))
                              .logFile.text
                        // copy the log in the job's own workspace
                      writeFile file: "buildlog.txt", text: logContent
                      }
                         version = readFile "${WORKSPACE}/buildlog.txt"
                        echo version*/
                    }
                    
                }
                /*stage('stoer'){
                    steps{
                       def version = readFile "${WORKSPACE}/buildlog.txt"
                        echo version
                    }}*/
              /*  stage('SonarStage'){
                    steps{
                       sonarqube(sonarorganization,sonarprojectKey,sonarprojectName,sonarHostUrl,sonarprojectVersion,sonarSources,sonarLanguage,sonarBinaries,sonarjavacoveragePlugin,sonarcoveragejacocoxmlReportPaths,sonarExclusions,sonarsourceEncoding)
                    }
                }
                stage('QualityGate'){
                    steps{
                       qualitygate()
                    }
                }*/
            }
      }
}
