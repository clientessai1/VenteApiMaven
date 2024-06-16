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
                sh -c "echo  mvn test"
                 """
            }
        }

        stage('Compile Application') {
            steps {
                sh """
                sh -c "mvn clean install"
                 """
            }
        }

        stage('Build docker image') {
            steps {
                sh """
                sh -c "echo Build docker image Process"
                sh -c "docker-compose up --build -d"
                 """
            }
        }


        stage('Test docker image') { 
            steps {
                sh """
                sh -c "echo TEST  DOCKER IMAGE"
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
