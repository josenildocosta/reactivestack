pipeline {
  agent {
    docker {
      image 'maven'
    }

  }
  stages {
    stage('Server') {
      steps {
        sh '''echo "Biulding"
mvn clean install '''
      }
    }
  }
}