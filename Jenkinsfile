pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'Starting the pipeline'
        sh 'mvn clean'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn -Dtest=AlexaControllerTest test'
      }
    }
    stage('Deploy') {
      steps {
        sh 'mvn package'
      }
    }
  }
}