pipeline {
    agent any
        stage('Build') {
            steps {
                sh 'echo "Building project..."'
                sh 'mvn test'
            }
        }
    }
}