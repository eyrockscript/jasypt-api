pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "./gradlew build"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "./gradlew test"
            }
        }
        stage('Upload') {
            steps {
                echo 'Uploading....'
                sh "./gradlew build docker"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh "docker run -p 3350:3349  -t eyrockscript/jasypt-api"
            }
        }
    }
}
