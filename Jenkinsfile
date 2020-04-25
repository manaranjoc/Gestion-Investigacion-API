pipeline {
    agent any
	tools{
		maven 'apache-maven-3.6.3'
	}
    stages {
        stage('Build') {
            steps {
				bat 'mvn -DskipTests clean install'
            }
        }
		stage('Test'){
			steps{
				bat 'mvn test'
			}
			post {
				always {
					junit 'target/surefire-reports/*.xml'
				}
			}
		}
		stage('SonarQube analysis'){
			steps{
				withSonarQubeEnv('My SonarQube Server'){
					bat 'mvn sonar:sonar'
				}
			}
		}
    }
}