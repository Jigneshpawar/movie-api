pipeline {
    agent any
    tools{
        maven 'Maven Home'
    }
    stages{
        stage('Build Maven Project'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Jigneshpawar/movie-api']]])
                bat "mvn clean install -Dmaven.test.skip=true"
            }
        }

        stage('Docker image build'){
            steps{
                script{
                    bat 'docker build -t jigneshpawar/movie-api .'
                }
            }
        }

        stage('Docker image push'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpass')]) {
                        bat "docker login -u jigneshpawar -p ${dockerhubpass}"
                        bat 'docker push jigneshpawar/movie-api'
                    }
                }
            }
        }
    }
}