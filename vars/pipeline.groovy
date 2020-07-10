def call( String msg = 'pipelinelib'){
pipeline {
	

    agent any
  
    stages {
	    stage('clonestage'){
		    steps{
		  
		    clonerepo()
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
