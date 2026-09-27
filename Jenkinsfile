pipeline {
    agent any

    stages {
        stage('Build Image') {
            steps {
                sh 'podman build -t localhost/playwright-tests:${BUILD_NUMBER} .'
            }
        }
    }
}