pipeline {
    agent any
  
    stages {
	    stage('clone'){
		   sh 'rm -rf assessmentdocker' 
	        sh 'git clone https://github.com/SumaVarshitha/assessmentdocker.git'
	    }
		 
        stage('build') {
            
		 
		steps {
	        docker.image("SumaVarshitha/java-maven-node").inside(){
                    sh "mvn clean install"
                }
			
            
	    }
        }
        stage('SonarQube Analysis'){
		
		 environment{
               sonarscanner = tool 'sonars'
                   }
            steps{
               withSonarQubeEnv('sonar'){
                    sh '${sonarscanner}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties'
		       //sh "${scannerHome}/bin/sonar-scanner"
              // sh 'mvn sonar:sonar' 
	       }
            }
        }

    
        
      stage("Quality Gate") {
            steps {
              timeout(time: 3, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
              }
            }
        }
    }
}
