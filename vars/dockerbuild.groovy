def call()
{
        docker.image("subhasanket/alpine-jar").inside(){
          sh "mvn clean install"
        }}
            
