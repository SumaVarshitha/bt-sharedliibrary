def call()
{
environment{
      sonarscanner = tool 'sonars'
          }
    withSonarQubeEnv('sonar'){
      sh '${sonarscanner}/var/lib/jenkins/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarQube_Scanner/bin/sonar-scanner -Dproject.settings=./sonar-project.properties'
		       //sh "${scannerHome}/bin/sonar-scanner"
              // sh 'mvn sonar:sonar' 
    }

}
