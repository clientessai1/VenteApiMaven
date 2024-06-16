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
                script {
                   HTTP_CODE = sh (
                        script: 'curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/api/v1/categories',
                        returnStdout: true
                    ).trim()

                    sh """sh -c 'if [ ${HTTP_CODE} -eq 200 ]; then echo "Available"; else echo "Not available"; fi'"""
                }
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
