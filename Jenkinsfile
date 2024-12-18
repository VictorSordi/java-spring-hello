pipeline {
    agent any

    environment {
        TAG = sh(script: 'git describe --abbrev=0',,returnStdout: true).trim()

        //NEXUS_URL = 'http://192.168.56.3:8123'
        //NEXUS_REPO = 'maven-releases'
        //NEXUS_CREDENTIALS_ID = 'nexus-user'
        //DOCKER_IMAGE_NAME = 'java-hello/app'
        //DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('build docker image'){
        steps{
            sh 'docker build -t java-hello/app:${TAG} .'
            }
        }
    
        stage ('deploy docker compose'){
        steps{
            sh 'docker compose up --build -d'
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
                    //sh "${scannerHome}/bin/sonar-scanner mvn clean install sonar:sonar -Dsonar.projectKey=java-hello -Dsonar.sources=src/main/java/ -Dsonar.java.binaries=target/classes  -Dsonar.host.url=${env.SONAR_HOST_URL} -Dsonar.token=${env.SONAR_AUTH_TOKEN} -X"
                    sh "mvn clean install sonar:sonar -Dsonar.projectKey=java-quarkus-hello -Dsonar.sources=src/main/java/ -Dsonar.java.binaries=target/classes  -Dsonar.host.url=${env.SONAR_HOST_URL} -Dsonar.token=${env.SONAR_AUTH_TOKEN} -X"
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

        stage('Shutdown docker containers') {
            steps{
                sh 'docker compose down'
            }
        }

        stage('Upload docker image'){
            steps{
                script {
                    withCredentials([usernamePassword(credentialsId: 'nexus-user', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh 'docker login -u $USERNAME -p $PASSWORD ${NEXUS_URL}'
                        sh 'docker tag java-hello/app:${TAG} ${NEXUS_URL}/java-hello/app:${TAG}'
                        sh 'docker push ${NEXUS_URL}/java-hello/app:${TAG}'
                        //sh 'docker tag $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG $NEXUS_URL/repository/$NEXUS_REPO/$DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG' 
                        //sh 'docker push $NEXUS_URL/repository/$NEXUS_REPO/$DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG' 
                    }
                }
            }
        }

        stage("Apply kubernetes files"){
            steps{
                sh '/usr/local/bin/kubectl apply -f ./kubernetes/app.yaml'
            }
        }
    }
}