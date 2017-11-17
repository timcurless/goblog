pipeline {
    stages {
        stage('Build Config Server') {
            agent {
                docker {
                    image "gradle:3.5-jdk8-alpine"
                }
            }
            git "https://github.com/timcurless/goblog.git"
            steps {
                sh 'cd support/config-server && ./gradlew build'
            }
        }
    }
}
