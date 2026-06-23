def call(String project, String tag){
withCredentials([usernamePassword('credentialsId':"dockerhubcred",passwordVariable:"dockerhubpass",usernameVariable:"dockerhubuser")])
  {
    sh "docker login -u ${env.dockerhubuser} -p ${env.dockerhubpass}"
    sh "docker tag ${project}-${tag}  ${env.dockerhubuser}/wonderlust-${tag}"
    sh "docker push ${env.dockerhubuser}/wonderlust-${tag}"
  }
}
