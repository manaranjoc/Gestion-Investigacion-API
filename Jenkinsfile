pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				bat set M2_HOME=C:\Users\Miguel\Documents\Universidades\UDEA\Semestre 6\Proyecto Integrador II\apache-maven-3.6.3
				bat path=C:\Users\Miguel\Documents\Universidades\UDEA\Semestre 6\Proyecto Integrador II\apache-maven-3.6.3\bin:%path%
                bat 'mvn --version'
            }
        }
    }
}