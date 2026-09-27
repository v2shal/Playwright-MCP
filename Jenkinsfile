pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'echo "Building project..."'
                sh 'mvn test'
            }
        }
    }
}