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
               
               withSonarQubeEnv('sonarqube'){
                   bat label: '', script: 'sonar-scanner.bat -Dsonar.projectKey=pipeline -Dsonar.sources=. -Dsonar.java.binaries=.'
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
            sshPublisher(publishers: [sshPublisherDesc(configName: 'lemon_java', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sh /home/deploy/cktest.sh', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: 'target/', sourceFiles: 'target/cktest-0.0.1-SNAPSHOT.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
             }
        }
    }
}
