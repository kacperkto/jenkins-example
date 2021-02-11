pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
         stage('Build') {
                steps {
                   sh  "mvn clean compile"
                }
         stage('Test') {
                 steps {
                   sh  "mvn test"
          }
         stage('Deployment') {
                 steps {
                   sh  "mvn clean heroku:deploy"
          }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/kacperkto/jenkins-example.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
