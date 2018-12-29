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
        archiveArtifacts 'target/*.war'
        sh '''aws --debug s3 cp /var/lib/jenkins/workspace/alexa-cicd_master/target/alexa-cicd-0.0.1-SNAPSHOT.war s3://elasticbeanstalk-us-east-1-593614531934/2018362ew4-alexa-cicd-0.0.1-SNAPSHOT.war 
'''
        sh 'aws --debug elasticbeanstalk create-application-version --application-name alexacicd --version-label "alexacicd-jenkins$BUILD_DISPLAY_NAME" --description "Created by $BUILD_TAG"  --source-bundle=S3Bucket=elasticbeanstalk-us-east-1-593614531934,S3Key=2018362ew4-alexa-cicd-0.0.1-SNAPSHOT.war'
        sh 'aws elasticbeanstalk update-environment --environment-name=Alexacicd-env --version-label "alexacicd-jenkins$BUILD_DISPLAY_NAME"'
      }
    }
  }
}