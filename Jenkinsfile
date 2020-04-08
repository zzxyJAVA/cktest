pipeline {
    agent any
    stages { 
        stage('获取代码') {
            steps {
                //echo 'github is ok'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/zzxyJAVA/cktest.git']]])
            }
        }
        stage('代码质检') {
            steps {
                //with(sonar-scanner2){
               bat label: '', script: ' sonar-scanner.bat -Dsonar.projectKey=${JOB_NAME} -Dsonar.sources=. '
               //}
            }
        }
        stage('mvn test'){
        withMaven(maven: 'maven3.5.2') {
                bat label: '', script: 'mvn test'
        }
    }
    stage('mvn build'){
        withMaven(maven: 'maven3.5.2') {
                bat label: '', script: 'mvn clean install -Dmaven.test.skip=true'
        }
    }

        stage('代码部署') {
            steps {
                echo 'deploy is ok'
            }
        }
    }
}