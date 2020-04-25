pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				withMaven(maven: 'apache-maven-3.6.3'){
					bat 'mvn --version'
				}
            }
        }
    }
}