def call(dockerimage,mavenBuild) 
{
        echo dockerimage
        echo mavenBuild
        def dimage = dockerimage
        def mBuild = maveenBuild
        docker.image("${dockerimage}").inside(){
          sh "${mBuild}"
        }}
            
