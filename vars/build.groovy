def call(String msg = 'build') {
echo "${msg}"
   sh 'mvn clean install'
}
