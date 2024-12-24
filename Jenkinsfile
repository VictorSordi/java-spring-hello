pipeline {
    agent any

    environment {
        TAG = sh(script: 'git describe --abbrev=0',,returnStdout: true).trim()
    }

    stages {
        stage('Build with Maven') { 
            steps { 
                script { 
                    sh 'mvn clean package'
                    sh 'mvn test'
                } 
            } 
        }   

        stage('build docker image'){
        steps{
            sh 'docker build -t java-spring-hello/app:${TAG} .'
            }
        }

        stage('sleep for container deploy'){
        steps{
            sh 'sleep 10'
            }
        }

        stage('Sonarqube validation'){
            steps{
                script{
                    scannerHome = tool 'sonar-scanner';
                }
                withSonarQubeEnv('sonar-server'){
                    sh "mvn clean install sonar:sonar -Dsonar.projectKey=java-spring-hello -Dsonar.sources=src/main/java/ -Dsonar.java.binaries=target/classes  -Dsonar.host.url=${env.SONAR_HOST_URL} -Dsonar.token=${env.SONAR_AUTH_TOKEN} -X"
                }
                sh 'sleep 10'
            }
        }

        stage("Quality Gate"){
            steps{
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }


        stage('Upload docker image'){
            steps{
                script {
                    withCredentials([usernamePassword(credentialsId: 'nexus-user', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh 'docker login -u $USERNAME -p $PASSWORD ${NEXUS_URL}'
                        sh 'docker tag java-spring-hello/app:${TAG} ${NEXUS_URL}/java-spring-hello/app:${TAG}'
                        sh 'docker push ${NEXUS_URL}/java-spring-hello/app:${TAG}'
                    }
                }
            }
        }

        stage("Apply kubernetes files"){
            steps{
                sh '/usr/local/bin/kubectl apply -f ./kubernetes/java-spring-hello.yaml'
            }
        }
    }
}