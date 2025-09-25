pipeline{
    agent any
    tools{
        maven 'MAVEN_HOME'
    }

        environment {
                PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"

                // Define Docker Hub credentials ID
                DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
                // Define Docker Hub repository name
                DOCKERHUB_REPO = 'oonnea/otp1_timecalculation'
                // Define Docker image tag
                DOCKER_IMAGE_TAG = 'latest'
            }


    stages{
        stage('checking'){
            steps{
                git branch:'main', url:'https://github.com/nealukumies/otp1_timecalculation.git'
            }
        }

        stage ('build'){
            steps {
                bat 'mvn clean install'
            }
        }

  stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} ."
                }
            }
            }
            stage('Push Docker Image to Docker Hub'){
            steps {
            withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {}
                script {
                    bat "docker login -u %DOCKERHUB_USERNAME% -p %DOCKERHUB_PASSWORD%"
                    bat "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                }
            }
        }
    }
}