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
    }
}
