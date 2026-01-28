# Taiga-Jenkins Integration Demo

This is a simple Java project with JUnit tests to demonstrate the integration between Taiga project management and Jenkins CI/CD.

## Project Structure
```
taiga-jenkins-demo/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── asu/
│   │               └── ser516/
│   │                   ├── Calculator.java
│   │                   └── StringUtils.java
│   └── test/
│       └── java/
│           └── com/
│               └── asu/
│                   └── ser516/
│                       ├── CalculatorTest.java
│                       └── StringUtilsTest.java
├── pom.xml
├── Jenkinsfile
└── README.md
```

## Components

### 1. Calculator.java
Simple calculator with basic arithmetic operations.

### 2. StringUtils.java
String manipulation utility class.

### 3. JUnit Tests
- CalculatorTest.java: Tests for calculator operations
- StringUtilsTest.java: Tests for string utilities

## Building the Project

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Build Commands
```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Package as JAR
mvn package
```

## Taiga Integration
This project includes references to Taiga issues in commit messages and code comments to demonstrate integration workflow.

## Jenkins Integration
The Jenkinsfile defines the CI/CD pipeline for automated testing and building.

## Webhook Test
Testing automatic build trigger via GitHub webhook.
