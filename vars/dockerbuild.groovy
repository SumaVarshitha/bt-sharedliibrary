defcall()
{
         sh 'rm -rf assessmentdocker' 
	        sh 'git clone https://github.com/SumaVarshitha/assessmentdocker.git'
          sh "mvn clean package"
                }
            
