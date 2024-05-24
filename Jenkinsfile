pipeline{

    agent any

    stages{
        stage('Echo') {
            steps{
                bat """
                     sh -c "echo Je suis ici !"
                 """
                }
            }

        stage('Show Release') {
            steps {
                bat """
                sh -c "cat /etc/os-release"
                 """
            }
        }
        stage('Initialisation') {
            steps {
                bat """
                sh -c "echo Initialisation !!!"
                 """
            }
        }

        stage('Unit Test') {
            steps {
                bat """
                sh -c "echo Unit Test"
                 """
            }
        }

        stage('Build docker image') {
            steps {
                bat """
                sh -c "echo Build docker image Process"
                 """
            }
        }


        stage('Test docker image') { 
            steps {
                bat """
                sh -c " echo Test docker image !!!"
                 """
            }
        }

                
        stage('Cleanup ') {
            steps {
                bat """
                sh -c "echo CleanUp stage !!!"
                 """
            }
        }

        stage("Push image to Docker Hub"){
            steps{
                bat """
                sh -c "echo Push image to Docker Hub !!!"
                 """
                }
            }


     }
   
}
