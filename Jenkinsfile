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
                script {
                    scannerHome = tool 'sonar-scanner2'
                }
               withSonarQubeEnv('sonarqube'){
                   bat label: '', script: '${scannerHome}/bin/sonar-scanner.bat -Dsonar.projectKey=pipeline -Dsonar.sources=. -Dsonar.java.binaries=.'
               }
            }
        }
        stage('mvn test'){
            steps {
               bat label: '', script: 'mvn test'
       
            }
    }
    stage('mvn build'){
        steps {
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
