def call()
{
        docker.image("SumaVarshitha/java-maven-node").inside(){
          sh "mvn clean install"
        }}
            
