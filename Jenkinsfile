node {
    stage('Initialize'){
        def mvnHome = tool 'M3'
        env.PATH = "${mavenHome}/bin:${env.PATH}"
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
			   steps {
					sh "mvn verify"
			   }
		}
	stage("Package") {
			  sh "mvn build"
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