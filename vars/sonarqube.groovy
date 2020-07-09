def call()
{
environment{
      sonarscanner = tool 'sonars'
          }
    withSonarQubeEnv('sonar'){
      sh '/var/lib/jenkins/tools/hudson.plugins.sonar.SonarRunnerInstallation/${sonarscanner}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties'
		       //sh "${scannerHome}/bin/sonar-scanner"
              // sh 'mvn sonar:sonar' 
    }

}
