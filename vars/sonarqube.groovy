def call()
{
environment{
      sonarscanner = tool 'sonars'
          }
    withSonarQubeEnv('sonar'){
      sh '${sonarscanner}/bin/sonar-scanner -Dproject.settings=/var/lib/jenkins/workspace/sonar-project.properties'
		       //sh "${scannerHome}/bin/sonar-scanner"
              // sh 'mvn sonar:sonar' 
    }

}
