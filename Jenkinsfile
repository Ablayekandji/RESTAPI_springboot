node {
  stage("Clone the project") {
    git branch: 'main', url: 'https://github.com/Ablayekandji/RESTAPI_springboot.git'
  }

  stage("Compilation") {
    sh "./mvnw clean install "
  }
}
