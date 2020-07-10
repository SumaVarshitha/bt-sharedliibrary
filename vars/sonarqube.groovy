def call()

  {
	
environment{
      scannerHome = tool 'sonars'
          }
    withSonarQubeEnv('sonar'){
      sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=SumaVarshitha_assessmentdocker -Dsonar.organization=sumavarshitha -Dsonar.projectName=assessmentdocker -Dsonar.projectVersion=1.0  -Dsonar.language=java -Dsonar.sources=. -Dsonar.java.binaries=. -Dsonar.host.url=https://sonarcloud.io/ -Dsonar.login=23c3c4a2d8cdc3f94ecc357df8d681a601cb48f6 -Dsonar.java.coveragePlugin=jacoco -Dsonar.sourceEncoding=UTF-8 -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml -Dsonar.exclusions=**/*.html,**/*.css,**/*.js,**/*.xml,src/test/java/com/puppet/sample/PolyglotTest.java"
		    
	       }
            }
       

    
        
     
