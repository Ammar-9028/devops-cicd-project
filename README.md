# Java DevOps CI/CD Pipeline Project

A complete end-to-end CI/CD project using Jenkins, Maven, Docker, Docker Hub, GitHub Webhooks, and AWS EC2.

## Project Overview

This project automates the process of building, testing, containerizing, and deploying a Java application using Jenkins Declarative Pipeline.

Whenever code is pushed to GitHub, a webhook automatically triggers the Jenkins pipeline.

## Architecture

GitHub → GitHub Webhook → Jenkins → Maven Build → Docker Build → Docker Hub → AWS EC2 Deployment

## Technologies Used

- Java 21
- Apache Maven 3.9.12
- Jenkins
- Git and GitHub
- GitHub Webhooks
- Docker
- Docker Compose
- Docker Hub
- AWS EC2 (Ubuntu)

## CI/CD Pipeline Stages

1. **Checkout:** Pull source code from GitHub.
2. **Build and Test:** Build the Java application using Maven.
3. **Build Docker Image:** Create a Docker image.
4. **Push to Docker Hub:** Upload the image to Docker Hub.
5. **Deploy:** Pull the latest image and deploy the application using Docker Compose on EC2.

## Application Access

The application runs on port `8081`.

## Automation

GitHub Webhook triggers Jenkins automatically whenever new code is pushed to the main branch.

## Key Learning Outcomes

- Configuring Jenkins and Declarative Pipelines
- Automating Java builds with Maven
- Building and publishing Docker images
- Deploying containerized applications on AWS EC2
- Configuring GitHub Webhooks for automated CI/CD

## Author

**Mohammed Ammar**

GitHub: [Ammar-9028](https://github.com/Ammar-9028)
