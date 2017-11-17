pipeline {
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

  agent none

  stages {
    stage('Build') {
      agent {
        docker {
          image 'timcurless/gradledocker'
          label 'DockerGradle'
        }
      }
      steps {
        git "https://github.com/timcurless/goblog.git"
        sh 'cd support/config-server && ./gradlew build'
      }
    }
  }
}