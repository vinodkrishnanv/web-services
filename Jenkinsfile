node {
	stage("Docker test") {
		sh "docker version"
	}
    stage('Initialize'){
        def mvnHome = tool 'M3'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
    }

    stage('Checkout') {
        git 'https://github.com/vinodkrishnanv/web-services.git'
    }

	stage("Compile") {
		sh "mvn clean compile"
	}
	stage("Unit test") {
				sh "mvn test"
	}
	stage("Integration test") {
		sh "mvn verify"
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