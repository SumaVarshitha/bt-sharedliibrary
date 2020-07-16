def call(urllink,dockerimage,mavenBuild,sonarorganization,sonarprojectKey,sonarprojectName){
        pipeline {
            agent any
            tools {
                   maven 'Maven_Home'
            }
            stages {
               
                stage('Code Checkout'){
                    steps{
                           clonerepo(branchName,urllink)
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
