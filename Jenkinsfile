pipeline {
     agent any
     stages {
		 stage('Initialize'){
			 steps {
						def mvnHome = tool 'M3'
						env.PATH = "${mvnHome}/bin:${env.PATH}"
				   }
		}
		stage('Checkout') {
			 steps {
				git 'https://github.com/vinodkrishnanv/web-services.git'
			}
		}
		stage("Compile") {
		   steps {
				sh "mvn clean compile"
		   }
		}
	  stage("Unit test") {
		   steps {
				sh "mvn test"
		   }
	  }
	stage("Unit test") {
		   steps {
				sh "mvn verify"
		   }
    }
	  
    
stage("Package") {
     steps {
          sh "mvn build"
     }
}
stage("Docker build") {
     steps {
          sh "docker build -t v1dock/web-services ."
     }
}
stage("Docker push") {
     steps {
   sh "docker login -u username -p password"
sh "docker push v1dock/web-services"
     }
}
stage("Deploy to staging") {
     steps {
          sh "docker run -d --rm -p 8765:8080 --name web-services v1dock/web-services"
     }
}
     }
  post {
     always {
          sh "docker stop web-services"
     }
}
}