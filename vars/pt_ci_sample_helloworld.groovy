def call(Map pipelineParams) {
    pipeline {
        agent {
            kubernetes {
                yaml libraryResource("podtemplates/${pipelineParams.k8_agent_yaml}")
            }
        }
        stages {
            stage('Say Hello') {
                steps {
                    pt_helloWorld(pipelineParams.firstName,pipelineParams.lastName)
                    sleep 10
                }
            }
            stage("Checkpoint") {
                agent none //running outside of any node or workspace
                steps {
                    checkpoint 'Completed Build'
                }
            }
            stage('Say By') {
                steps {
                    echo "By: ${pipelineParams.firstName}, ${pipelineParams.lastName}"
                 }
            }

        }
    }
}

