def call(Map pipelineParams) {
    pipeline {
        agent none
        stages {
            stage('Say Hello') {
                agent {
                    kubernetes {
                        yaml libraryResource("podtemplates/${pipelineParams.k8_agent_yaml}")
                    }
                }
                steps {
                    pt_helloWorld(pipelineParams.firstName,pipelineParams.lastName)
                    sleep 10
                }
                checkpoint 'hello'
            }
            stage('Say By') {
                agent {
                    kubernetes {
                        yaml libraryResource("podtemplates/${pipelineParams.k8_agent_yaml}")
                    }
                }
                steps {
                    echo "By: ${pipelineParams.firstName}, ${pipelineParams.lastName}"
                 }
                checkpoint 'By'
            }

        }
    }
}

