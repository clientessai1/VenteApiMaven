def conditionMet = false // Declared globally at the beginning of the script

pipeline{

    agent { label('ubuntu-dev-agent') } // The agent environment(linux, windows...) we want to use to run this pipeline
    
    tools{ //Specific tools that will be used in this pipeline
        maven 'Maven 3.9.3' 
    }

    environment{ //The varialbes that will be used in the pipeline usually more than once

        IMAGE01 = "aristidesama2/venteapimaven_1of3_mongodb:v1"
        IMAGE02 = "aristidesama2/venteapimaven_2of3_monitor-db:v1"
        IMAGE03 = "aristidesama2/venteapimaven_3of3_api:v1"

        CONTAINER01 = "venteapimaven_mongo_db_1"
        CONTAINER02 = "venteapimaven_monitor-db"
        CONTAINER03 = "venteapimaven_api"
    }

    stages{ // Here are the stages of the pipeline

        stage('Echo') { //This stage is just for a test purpose
            steps{
                sh """
                     sh -c "echo Je suis ici !"
                 """
                }
            }

        stage('Show Release') { //This stage is jus to test that linux command is working

            steps {
                sh """
                sh -c "ls /"
                 """
            }
        }

        stage('Unit Test') { //This stage is for running unit test using maven
            steps {
                sh """
                sh -c "mvn test"
                 """
            }
        }

        stage('Compile Application') {//This stage is used to compil our java application

            steps {
                sh """
                sh -c "mvn clean install"
                 """
            }
        }

        stage('Build docker images') { //On this stage we are building docker images
            steps {
                sh """
                sh -c "echo Build docker image Process"
                sh -c "docker-compose up --build -d"
                 """
            }
        }


        stage('Test docker image') { //On this stage we will test that the docker image is working
            
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

        stage("Push image to Docker Hub"){ //On this stage, we push the docker images to the docker hub

            steps{
                withCredentials([usernamePassword(credentialsId: 'DOCKER_CREDS_ARIS', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
                    sh """
                    docker logout  && \
                    docker login  --username $USERNAME --password $PASSWORD && \
                    docker push ${IMAGE03} && \
                    docker push ${IMAGE02} && \
                    docker push ${IMAGE01} 
                    """
                }
            }
        }

                
        stage('Cleanup ') { //On this stage, we clean the containers and images from our environment
            steps {
                sh """
                sh -c "echo Kill and delete containers !!!"
                docker kill ${CONTAINER01} ${CONTAINER02} ${CONTAINER03} && \
                docker rm ${CONTAINER01} ${CONTAINER02} ${CONTAINER03}
                sh -c "echo Delete images !!!"
                docker rmi ${IMAGE01} ${IMAGE02} ${IMAGE03}
                 """
            }
        }

     }
   
}
