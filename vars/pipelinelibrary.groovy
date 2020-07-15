def call(){
pipeline {
	

    agent any
  
    stages {
	    stage('clonestage'){
		    steps{
		  
		    clonerepo(giturl)
		    }}
		 
        stage('build') {
            steps {
			  
       
		    dockerbuild()
                }
			
            
	    }
        
        stage('SonarQube Analysis'){
		
		 
          steps{
         
		    sonarqube()
	       
            }
       }

    
        
      stage("Quality Gate") {
            steps {
		    qualitygate()
             
           }
        }
    }
}
}
