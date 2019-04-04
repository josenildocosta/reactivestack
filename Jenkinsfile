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
mvn clean package'''
      }
    }
    stage('deploy') {
      steps {
        sh 'java -jar /var/jenkins_home/workspace/reactivestack_master/target/reactivestack-0.0.1-SNAPSHOT.jar to /root/.m2/repository/br/com/reactivestack/reactivestack/0.0.1-SNAPSHOT/reactivestack-0.0.1-SNAPSHOT.jar'
      }
    }
  }
}