pipeline{

    agent any

    stages{
        stage('Echo') {
            steps{
                sh -c "echo Je suis ici !"
                }
            }
        stage('Show Release') {
            steps {
                sh -c "cat /etc/os-release"
            }
        }
        stage('Initialisation') {
            steps {
                sh -c "echo Initialisation !!!"
            }
        }

        stage('Unit Test') {
            steps {
                sh -c "echo Unit Test"
            }
        }

        stage('Build docker image') {
            steps {
                sh -c "echo Build docker image Process"
            }
        }


        stage('Test docker image') { 
            steps {
                sh -c " echo Test docker image !!!"
            }
        }

                
        stage('Cleanup ') {
            steps {
                sh -c "echo CleanUp stage !!!"
            }
        }

        stage("Push image to Docker Hub"){
            steps{
                sh -c "echo Push image to Docker Hub !!!"
                }
            }
        }
   
}
