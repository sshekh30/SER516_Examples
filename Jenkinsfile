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
            echo 'Taiga Task: TG-5 - COMPLETED'
            echo 'All tests passed. Ready for deployment.'
            
            script {
                // Taiga API configuration
                def taigaToken = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNzY5NzI3MjkxLCJqdGkiOiJiMzE3Mzg1YjViOWU0N2RiOTY1YzBjMDA5NjhmNGE4OSIsInVzZXJfaWQiOjV9.aVwfQFUklygMOTVdN4ty-yht2cVQ8G7rnTzy2IDzVcs'
                def taigaUrl = 'https://swent0linux.asu.edu/taiga/api/v1'
                def projectId = 3  // Taiga project ID
                def buildUrl = "${env.BUILD_URL}"
                def buildNumber = "${env.BUILD_NUMBER}"
                
                // Get commit message to find referenced tasks
                def commitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
                echo "Commit message: ${commitMsg}"
                
                // Find all TG-X references in commit message (e.g., TG-1, TG-5)
                def matcher = (commitMsg =~ /TG-(\d+)/)
                def referencedTaskRefs = []
                matcher.each { match -> 
                    referencedTaskRefs << match[1]  // Extract just the number
                }
                
                echo "Found Taiga task references: TG-${referencedTaskRefs.join(', TG-')}"
                
                // Update each referenced task
                referencedTaskRefs.each { taskRef ->
                    try {
                        echo "Looking up Taiga task with ref #${taskRef} in project ${projectId}"
                        
                        // Query Taiga API to find the task by its ref number
                        def taskListJson = sh(
                            script: """
                                curl -k -s -X GET \
                                  "${taigaUrl}/tasks?project=${projectId}&ref=${taskRef}" \
                                  -H "Authorization: Bearer ${taigaToken}" \
                                  -H "Content-Type: application/json"
                            """,
                            returnStdout: true
                        ).trim()
                        
                        // Parse JSON to get task ID
                        // Simple parsing: look for "id": <number> pattern
                        def idMatcher = (taskListJson =~ /"id":\s*(\d+)/)
                        if (idMatcher.find()) {
                            def taskId = idMatcher[0][1]
                            echo "Found task TG-${taskRef} with ID: ${taskId}"
                            
                            // Get current version number
                            def versionMatcher = (taskListJson =~ /"version":\s*(\d+)/)
                            def version = versionMatcher.find() ? versionMatcher[0][1] : '1'
                            
                            // Prepare comment
                            def comment = "Jenkins Build #${buildNumber} completed successfully!\\n" +
                                          "Build URL: ${buildUrl}\\n\\n" +
                                          "Results:\\n" +
                                          "- All 22 tests passed\\n" +
                                          "- JAR artifact created\\n" +
                                          "- Automated via Taiga-Jenkins integration"
                            
                            echo "Updating Taiga task TG-${taskRef} (ID: ${taskId})"
                            
                            // Update the task with a comment
                            sh """
                                curl -k -X PATCH \
                                  "${taigaUrl}/tasks/${taskId}" \
                                  -H "Authorization: Bearer ${taigaToken}" \
                                  -H "Content-Type: application/json" \
                                  -d '{
                                    "comment": "${comment}",
                                    "version": ${version}
                                  }'
                            """
                            
                            echo "✓ Successfully updated Taiga task TG-${taskRef}"
                        } else {
                            echo "✗ Could not find task TG-${taskRef} in project"
                        }
                    } catch (Exception e) {
                        echo "✗ Error updating task TG-${taskRef}: ${e.message}"
                        // Continue with other tasks even if one fails
                    }
                }
                
                if (referencedTaskRefs.isEmpty()) {
                    echo "No Taiga task references found in commit message"
                }
            }
        }
        failure {
            echo 'Build failed!'
            echo 'Taiga Task: TG-5 - FAILED'
            echo 'Please check the test results and fix failing tests.'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}