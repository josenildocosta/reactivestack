pipeline {
  agent any
  stages {
    stage('Server') {
      steps {
        sh '''echo "Biulding"
mvn clean install '''
      }
    }
  }
}