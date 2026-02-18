# Example_2 — Java Unit Testing with JUnit 5

## Overview

This example demonstrates a basic CI pipeline using **Maven** and **JUnit 5** integrated with **Jenkins**.  
The goal is to understand how unit tests are written in Java and how Jenkins automatically runs them on every commit.

## Tools Used

| Tool    | Purpose                                         |
|---------|-------------------------------------------------|
| Maven   | Build automation and dependency management      |
| JUnit 5 | Unit testing framework for Java                 |
| Jenkins | CI server that runs the pipeline on each commit |

## Project Structure

```
Example_2/
├── Jenkinsfile                              # Jenkins pipeline configuration
├── pom.xml                                  # Maven project configuration
├── README.md                                # This file
└── src/
    ├── main/
    │   └── java/
    │       └── com/example/
    │           └── Greeter.java             # Main application code
    └── test/
        └── java/
            └── com/example/
                └── GreeterTest.java         # JUnit unit tests
```

## Step 1 — Prerequisites

Make sure you have the following installed:
- Java 11 or higher (`java -version`)
- Maven 3.6 or higher (`mvn -version`)

## Step 2 — Clone the Repository

```bash
git clone https://github.com/sshekh30/SER516_Examples.git
cd SER516_Examples/Example_2
```

## Step 3 — Build and Run the Tests Locally

First, compile the main source code:
```bash
mvn clean compile
```

You should see:
```
[INFO] BUILD SUCCESS
```

Then run the tests (this compiles the test code and runs them):
```bash
mvn test
```

You should see:
```
testGreet -> Expected: 'Hello, Alice!'  Got: 'Hello, Alice!'
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Step 4 — Understanding the Code

**Greeter.java** has three methods:
- `greet(name)` → returns `"Hello, <name>!"`
- `greetLoud(name)` → returns `"HELLO, <NAME>!"`
- `greetFormal(name)` → returns `"Good day, <name>."`

**GreeterTest.java** has one provided test for `greet()`. It prints the expected vs actual value so you can see what the test is doing. Open the file and read the comments for hints on adding your own test.

## Step 5 — Set Up the Jenkins Pipeline

1. Log in to Jenkins at `https://swent0linux.asu.edu/jenkins`
2. Navigate to your group folder
3. Click **New Item** → name it `Example_2` → select **Pipeline** → click OK
4. Under **Pipeline**, set **Definition** to `Pipeline script from SCM`
5. Set **SCM** to `Git` and enter the repository URL:  
   `https://github.com/sshekh30/SER516_Examples.git`
6. Under **Branches to build**, change `*/master` to `*/main`
7. Set **Script Path** to `Example_2/Jenkinsfile`
8. Under **Build Triggers**, check **Poll SCM** and set the schedule to `* * * * *` (polls every minute)
9. Click **Save** then click **Build Now** to trigger the first build

> **Important — Maven Installation Check:**
> Before pushing, go to **Manage Jenkins → Tools → Maven installations** and check the following:
> - **If no Maven installation exists** → Click **Add Maven**, give it a name (e.g. `Maven`), select a version, and click **Save**
> - **If a Maven installation already exists** → Note the exact name it is saved under
>
> Then open the `Jenkinsfile` and make sure the name matches exactly:
> ```groovy
> tools {
>     maven 'Maven'  // Replace 'Maven' with your exact installation name
> }
> ```
> If the name does not match, the pipeline will fail with `mvn: not found`.

## Step 6 — Trigger the Pipeline with a Commit

Make a small change (e.g., add a comment), commit, and push:

```bash
git add .
git commit -m "Trigger pipeline"
git push
```

Within a minute, Jenkins will detect the change and run the pipeline automatically.

## Step 7 — View Test Results

In Jenkins, navigate to your build and click **Console Output** to see the full output including:
```
testGreet -> Expected: 'Hello, Alice!'  Got: 'Hello, Alice!'
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

You can also click **Test Result** on the build page for a structured view of all tests run.

## Step 8 (Optional) — Add Your Own Test

Open `GreeterTest.java` and uncomment the optional section at the bottom.  
Try writing a test for `greetFormal()` or `greetLoud()` and push again to see the pipeline re-run with your new test.