pipeline {
  agent any
  stages {
    stage('Server') {
      steps {
        sh '''echo "Biulding"
sudo ./mvnw clean install '''
      }
    }
  }
}