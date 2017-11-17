pipeline {
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

  agent {
      docker {
        image 'buildmystartup/custom-image-with-go'
        label 'docker'
      }
    }

  stages {
    stage('Build') {
      agent {
        docker {
          image "gradle:3.5-jdk8-alpine"
        }
      }
      steps {
        git "https://github.com/timcurless/goblog.git"
        sh 'gradle build'
      }
    }
  }
}