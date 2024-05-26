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
                sh -c "ls /"
                 """
            }
        }

        stage('Unit Test') {
            steps {
                bat """
                mvn test
                 """
            }
        }

        stage('Compile Application') {
            steps {
                bat """
				mvn clean install
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
