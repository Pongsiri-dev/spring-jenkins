pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -v' // ตรวจสอบว่า Maven ติดตั้งแล้ว
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
