pipeline {
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

  agent {
    docker {
      image 'timcurless/gradledocker'
      label 'DockerGradle'
    }
  }

  stages {

    stage('Clone Repo') {
      steps {
        git "https://github.com/timcurless/goblog.git"
      }
    }

    stage('Build') {

      steps {
        sh 'cd support/config-server && ./gradlew build'
        //archiveArtifacts artifacts: '**/config*.jar'
      }
    }

    stage('Distribute Binaries') {
      steps {
        script {
          def SERVER_ID = 'Ahead-Demo-Artifactory'
          def server = Artifactory.server SERVER_ID
          server.username = 'admin'
          server.password = 'Password1!'

          def uploadSpec =
          """
          {
            "files": [
              {
                "pattern": "**/config*.jar",
                "target": "libs-snapshots-local/se/callista/microservises/support/{1}/"
              }
            ]
          }
          """

          def buildInfo = Artifactory.newBuildInfo()
          buildInfo.env.capture = true
          buildInfo = server.upload(uploadSpec)
          server.publishBuildInfo(buildInfo)
        }
      }
    }
  }
}
