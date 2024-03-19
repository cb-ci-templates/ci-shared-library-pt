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
                    echo 'Hello World!'
                    sleep 10
                    checkpoint 'Hello'
                }
            }
            stage('Say Good By') {
                steps {
                    echo 'Say Good By'
                    checkpoint 'ByBy'
                }
            }
        }
    }
}