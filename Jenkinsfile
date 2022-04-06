node{
  stage('SCM Checkout'){
    git 'https://github.com/Rittick-1234/BookRestClient'
  }

  stage('Compile-Package'){
    sh 'mvn package'
  }
}
