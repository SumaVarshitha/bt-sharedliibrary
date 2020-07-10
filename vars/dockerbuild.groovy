def call()
{
        docker.image("sumavarshitha/java-maven-node").inside(){
          sh "mvn clean package"
        }}
            
