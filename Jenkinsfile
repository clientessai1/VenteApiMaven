def conditionMet = false // Declared globally at the beginning of the script

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
            
            options{
                timeout(time:5, unit:'MINUTES')
            }

            steps {
                waitUntil(initialRecurrencePeriod: 5000) {

                 script {
                   HTTP_CODE = sh (
                        script: 'curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/api/v1/categories',
                        returnStdout: true
                    ).trim()
                    echo "Response httpcode: ${HTTP_CODE}"
                    sh """sh -c 'if [ ${HTTP_CODE} -eq 200 ]; then echo "Available"; else echo "Not available"; fi'"""
                    if(HTTP_CODE == '200')
                    {
                        conditionMet = true;
                        echo "+ + + COndition TRUE  ${HTTP_CODE}"
                        //return true;
                    }else{
                        echo "+ + + COndition FALSE  ${HTTP_CODE}"
                    }
                    //return (200 != HTTP_CODE)
                    return conditionMet;
                 }

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
