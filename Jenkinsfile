pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
            stage('SonarQube analysis') {
                steps {
                    withSonarQubeEnv('SonarQube') {
                        sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.0.2131:sonar'
                    }
                }
            }
            stage("Quality gate") {
                steps {
                    waitForQualityGate abortPipeline: true
                }
            }
         stage('Build') {
                steps {
                   sh  "mvn clean compile"
                }
                }
         stage('Test') {
                 steps {
                   sh  "mvn test"
          }
          }
         stage('Deployment') {
                 steps {
                   sh  "mvn clean heroku:deploy"
          }

        }
    }
}
