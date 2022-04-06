node{
  stage('SCM Checkout'){
    git 'https://github.com/Rittick-1234/BookRestClient'
  }

  stage('Compile-Package'){
     def mvnHome = tool name: 'maven 3.8.4', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
}
