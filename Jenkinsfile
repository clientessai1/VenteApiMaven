pipeline{

    agent { label('ubuntu-dev-agent') }
    
    tools{
        maven 'Maven 3.9.3'
    }

    stages{
        stage('Echo') {
            steps{
                sh """
                     sh -c "echo Je suis ici !"
                 """
                }
            }

        stage('Show Release') {
            steps {
                sh """
                sh -c "ls /"
                 """
            }
        }

        stage('Unit Test') {
            steps {
                sh """
                sh -c "mvn test"
                 """
            }
        }

        stage('Compile Application') {
            steps {
                sh """
                sh -c "echo mvn clean install"
                 """
            }
        }

        stage('Build docker image') {
            steps {
                sh """
                sh -c "echo Build docker image Process"
                sh -c "echo docker-compose up --build"
                 """
            }
        }


        stage('Test docker image') { 
            steps {
                sh """
                sh -c " echo Test docker image !!!"
                 """
            }
        }

                
        stage('Cleanup ') {
            steps {
                sh """
                sh -c "echo CleanUp stage !!!"
                 """
            }
        }

        stage("Push image to Docker Hub"){
            steps{
                sh """
                sh -c "echo Push image to Docker Hub !!!"
                 """
                }
            }


     }
   
}
