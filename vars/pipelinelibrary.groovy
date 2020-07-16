def call(body) {    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
}
//def call(urllink,dockerimage,mavenBuild,sonarorganization,sonarprojectKey,sonarprojectName){
def urllink = config.urllink ?: ''
def dockerimage = config.dockerimage ?: ''
def mavenBuild = config.mavenBuild ?: ''
def sonarorganization = config.sonarorganization ?: ''
def sonarprojectKey = config.sonarprojectKey ?: ''
def sonarprojectName = config.sonarprojectName ?: ''

        pipeline {
            agent any
            
            stages {
               
                stage('Code Checkout'){
                    steps{
                           clonerepo(urllink)
                    }
                }
               
                stage('Build_In_Container'){
                    steps{
                            dockerbuild(dockerimage,mavenBuild)
                    }
                }
                stage('SonarStage'){
                    steps{
                       sonarqube(sonarorganization,sonarprojectKey,sonarprojectName)
                    }
                }
                stage('QualityGate'){
                    steps{
                       qualitygate()
                    }
                }
            }
      }
}
