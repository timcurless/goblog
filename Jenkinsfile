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

    stage('Distribute Binaries') {
      def SERVER_ID = 'Ahead-Demo-Artifactory'
      def server = Artifactory.server SERVER_ID

      def uploadSpec =
      """
      {
        "files": [
          {
            "pattern": "build/libs/*.jar",
            "target": "libs-snapshots-local/se/callista/microservises/support/{1}/
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
