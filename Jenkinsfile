node {
	checkout scm

	stage("Docker test") {
		println(isUnix())
//		sh "eval \$(\"C:\\Program Files\\Docker Toolbox\\docker-machine.exe\" env default)"
		bat "@FOR /f \"tokens=*\" %i IN ('docker-machine env default') DO @%i"
		sh "docker version"
		docker.image('maven:3.3.3-jdk-8').inside {
			git 'https://github.com/vinodkrishnanv/web-services.git'
			sh 'mvn -B clean install'
		}
//		sh "eval \$(\"C:\\Program Files\\Docker Toolbox\\docker-machine.exe\" env default)"
//		sh "docker version"
	}
    stage('Initialize'){
        def mvnHome = tool 'M3'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
    }

//    stage('Checkout') {
//        git 'https://github.com/vinodkrishnanv/web-services.git'
//    }

	stage("Compile") {
		sh "mvn clean compile"
	}
	stage("Unit test") {
				sh "mvn test"
	}
	stage("Integration test") {
		sh "mvn verify -Dunit-tests.skip=true"
	}
	stage("Package") {
		  sh "mvn package"
	}
	stage("Docker build") {
		  sh "docker build -t v1dock/web-services ."
	}
	stage("Docker push") {
	   sh "docker login -u username -p password"
		sh "docker push v1dock/web-services"
	}
	stage("Deploy to staging") {
		  sh "docker run -d --rm -p 8765:8080 --name web-services v1dock/web-services"
	}
}
//pipeline {
//	agent any
//
//	stages {
//		stage('Build') {
//			steps {
//				echo 'Building..'
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