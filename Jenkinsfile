pipeline {
    agent {
        docker { image 'maven:3.9.9-jdk-11' }
    }
    tools {
            maven 'Maven3' // ตั้งค่า Maven ที่เพิ่มใน Global Tool
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -v'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
