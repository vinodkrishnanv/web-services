node {
	checkout scm
    stage('Initialize'){
        def mvnHome = tool 'M3'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
    }
	environment {
		DOCKER_COMMON_CREDS = credentials(${DOCKER-CREDENTIALS})
	}
//    stage('Checkout') {
//        git 'https://github.com/vinodkrishnanv/web-services.git'
//    }

	stage("Compile") {
		sh "mvn clean compile"
	}
//	stage("Unit test") {
//		sh "mvn test -DskipTests"
//	}
//	stage("Integration test") {
//		sh "mvn verify -DskipTests -Dunit-tests.skip=true"
//	}
	stage("Package") {
		  sh "mvn package -DskipTests"
	}
	stage("Docker build") {
		  sh "docker build -t v1dock/web-services ."
	}
	stage("Docker push") {
	   sh "docker login -u $DOCKER_COMMON_CREDS_USR -p $DOCKER_COMMON_CREDS_PSW"
	   sh "docker push v1dock/web-services"
	}
//	stage("Deploy to staging") {
//		  sh "docker run -d --rm -p 8765:8080 --name web-services v1dock/web-services"
//	}
}
//pipeline {
//	agent {
//		label 'master'
//	}
//	stages {
//		stage('Build') {
//			agent {
//				docker {
//					image 'maven:3-alpine'
//					label 'master'
//					args  '-v /tmp:/tmp'
//				}
//			}
//			steps {
//				echo 'Building..'
//				sh 'node --version'
//			}
//		}
//		stage('Test') {
//			steps {
//				echo 'Testing..'
//			}
//		}
//		stage('Deploy') {
//			steps {
//				echo 'Deploying....'
//			}
//		}
//	}
//}