pipeline {
    agent none
  
    stages {
		 
        stage('build') {
            
		   agent {
			   docker { image 'sumavarshitha/java-maven-node' }}
		steps {
	        sh 'rm -rf assessmentdocker' 
	        sh 'git clone https://github.com/SumaVarshitha/assessmentdocker.git'
                sh "mvn clean package"
            
	    }
        }
        stage('SonarQube Analysis'){
		  agent { label 'master' }
		
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
