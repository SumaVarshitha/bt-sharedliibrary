/*def call(sonarorganization,sonarprojectKey,sonarprojectName)

  {
    
    def scannerHome = tool 'sonars'
    withSonarQubeEnv('sonar'){
      sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${sonarprojectKey} -Dsonar.organization=${sonarorganization} -Dsonar.projectName=${sonarprojectName} -Dsonar.projectVersion=1.0 -Dsonar.login=23c3c4a2d8cdc3f94ecc357df8d681a601cb48f6  -Dsonar.language=java -Dsonar.sources=. -Dsonar.java.binaries=. -Dsonar.host.url=https://sonarcloud.io/ -Dsonar.java.coveragePlugin=jacoco -Dsonar.sourceEncoding=UTF-8 -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml -Dsonar.exclusions=**/*.html,**/*.css,**/*.js,assessmentdocker/src/main/java/com/puppet/sample/*.java"
		    
	       }
            }*/
       

    
  def call(sonarorganization,sonarprojectKey,sonarprojectName) {
  echo "************************************Sonar***************qube***********************"
  def scannerHome = tool 'sonars'
  
  withSonarQubeEnv('sonar') {
    sh "${scannerHOME}/bin/sonar-scanner -Dsonar.organization=${sonarorganization} \
                -Dsonar.projectKey=${sonarprojectKey}  \
                -Dsonar.projectName=${sonarprojectName} \
	        -Dsonar.projectVersion=${sonarprojectVersion} \
	        -Dsonar.sources=${sonarSources}  \
	        -Dsonar.language=${sonarLanguage}\
	        -Dsonar.java.binaries=${sonarBinaries} \
	        -Dsonar.java.coveragePlugin=${sonarjavacoveragePlugin} \
	        -Dsonar.coverage.jacoco.xmlReportPaths=${sonarcoveragejacocoxmlReportPaths} \
	        -Dsonar.exclusions=${sonarExclusions} \
	        -Dsonar.sourceEncoding=${sonarsourceEncoding}
    }   
}     
     
