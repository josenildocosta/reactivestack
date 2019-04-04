pipeline {
  agent any
  stages {
    stage('Server') {
      steps {
        sh '''echo "Biulding"
./mvnw clean install '''
      }
    }
  }
}