pipeline {
    agent any
    tools {
        maven 'Maven3' // ตั้งค่า Maven ที่เพิ่มใน Global Tool
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -v' // ตรวจสอบ Maven
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                 sh 'mvn test'
            }
            post {
                 always {
                    junit 'target/surefire-reports/*.xml'
                 }
            }
        }
        stage('Fix Permissions') {
            steps {
                sh 'chmod +x jenkins/scripts/deliver.sh'
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
