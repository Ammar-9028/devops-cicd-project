# DevOps CI/CD Project

A small Java 21 HTTP application for practicing an end-to-end Jenkins Declarative CI/CD pipeline.

## Technology
- Java 21
- Maven 3.9+
- Git and GitHub
- Jenkins Declarative Pipeline
- Docker and Docker Hub
- Docker Compose
- GitHub webhook

## Application
The app listens on container port `8080`. Docker Compose publishes it on EC2 port `8081` so it does not conflict with Jenkins on port `8080`.

After deployment, open:

`http://EC2_PUBLIC_IP:8081`

## Jenkins prerequisites
Configure these tools in **Manage Jenkins → Tools**:
- JDK name: `Java21`; JAVA_HOME: `/usr/lib/jvm/java-21-openjdk-amd64`
- Maven name: `Maven3`; MAVEN_HOME: `/usr/share/maven`

Add a Jenkins username/password credential:
- ID: `dockerHub`
- Username: your Docker Hub username
- Password: Docker Hub access token (recommended)

The Jenkins agent user must be able to run Docker and Docker Compose.

## Jenkins job
Create a Pipeline job and select **Pipeline script from SCM**:
- SCM: Git
- Repository URL: `https://github.com/Ammar-9028/devops-cicd-project.git`
- Branch: `*/main`
- Script Path: `Jenkinsfile`

Do not configure or add a Shared Library. This repository does not use one.

## GitHub webhook
In GitHub repository → Settings → Webhooks → Add webhook:
- Payload URL: `http://EC2_PUBLIC_IP:8080/github-webhook/`
- Content type: `application/json`
- Events: Just the push event

For a real production deployment, use HTTPS and restrict Jenkins access rather than exposing the Jenkins UI publicly.

## AWS security group
For this learning lab, allow:
- TCP 22 from My IP
- TCP 8080 from My IP (Jenkins)
- TCP 8081 from your IP (deployed application)

Do not open Docker's remote API or MySQL ports.

## Local build
```bash
mvn clean test package
docker build -t devops-cicd-app:latest .
```

## Notes
- The pipeline pushes `DOCKERHUB_USERNAME/devops-cicd-app:latest`.
- The deployed app is managed by Docker Compose.
- The Compose file uses `DOCKERHUB_USERNAME` from the Jenkins deploy stage.
- This is a learning project, not a production-hardened deployment.
