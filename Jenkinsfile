pipeline {
    agent any
  
    stages {
		 
        stage('build') {
            
		 
		steps {
	        docker.image("subhasanket/alpine-jar").inside(){
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
