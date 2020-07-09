@Library('shlib')_
pipeline {
    agent any
  
    stages {
	    stage('clonestage'){
		    steps{
		   //sh 'rm -rf assessmentdocker' 
	       // sh 'git clone https://github.com/SumaVarshitha/assessmentdocker.git'
		    clonerepo()
		    }}
		 
        stage('build') {
            
		 
		steps {
	           dockerbuild()
                }
			
            
	    }
        
        stage('SonarQube Analysis'){
		
		// environment{
               //sonarscanner = tool 'sonars'
                  // }
            steps{
              // withSonarQubeEnv('sonar'){
                   // sh '${sonarscanner}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties'
		       //sh "${scannerHome}/bin/sonar-scanner"
              // sh 'mvn sonar:sonar'
		    sonarqube()
	       }
            }
       // }

    
        
      stage("Quality Gate") {
            steps {
             // timeout(time: 3, unit: 'MINUTES') {
               // waitForQualityGate abortPipeline: true
		    qualitygate()
              }
            }
        //}
    }
}
