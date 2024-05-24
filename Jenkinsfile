pipeline{

    agent any

    stages{
        stage('Echo') {
            steps{
                sh "echo Je suis ici !"
                }
            }
        stage('Show Release') {
            steps {
                sh "cat /etc/os-release"
            }
        }
        stage('Initialisation') {
            steps {
                sh "echo Initialisation !!!"
            }
        }

        stage('Unit Test') {
            steps {
                sh "echo Unit Test"
            }
        }

        stage('Build docker image') {
            steps {
                sh "echo Build docker image Process"
            }
        }


        stage('Test docker image') { 
            steps {
                sh " echo Test docker image !!!"
            }
        }

                
        stage('Cleanup ') {
            steps {
                sh "echo CleanUp stage !!!"
            }
        }

        stage("Push image to Docker Hub"){
            steps{
                sh "echo Push image to Docker Hub !!!"
                }
            }
        }
   
}
