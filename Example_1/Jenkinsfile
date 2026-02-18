pipeline {
    agent any
    
    tools {
        maven 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                // Git checkout is automatic when using Pipeline from SCM
                echo "Building project for Taiga User Story: Integration Demo"
            }
        }
        
        stage('Build') {
            steps {
                echo 'Compiling Java code...'
                echo 'Taiga Task: TG-5 - Configure Jenkins Build Pipeline'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running JUnit tests...'
                echo 'Taiga Tasks: TG-3 (Calculator Tests) and TG-4 (StringUtils Tests)'
                sh 'mvn test'
            }
            post {
                always {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Packaging application...'
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Archive') {
            steps {
                echo 'Archiving artifacts...'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
    
    post {
        success {
            echo 'Build completed successfully!'
            echo 'All tests passed. Ready for deployment.'
            echo 'Taiga tasks can be updated manually or via API integration'
            cleanWs()
        }
        failure {
            echo 'Build failed!'
            echo 'Please check the test results and fix failing tests.'
            cleanWs()
        }
    }
}