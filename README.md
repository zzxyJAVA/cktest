pipeline {
    agent any
    stages { 
        stage('获取代码') {
            steps {
                echo 'github is ok'
            }
        }
        stage('代码质检') {
            steps {
                echo 'sonar is ok'
            }
        }
        stage('代码构建') {
            steps {
                echo 'build is ok'
            }
        }
        stage('代码部署') {
            steps {
                echo 'deploy is ok'
            }
        }
    }
}
