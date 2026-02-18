# Example_3 — Python Unit Testing with pytest

## Overview

This example demonstrates a basic CI pipeline using **Poetry** and **pytest** integrated with **Jenkins**.  
The goal is to understand how unit tests are written in Python and how Jenkins automatically runs them on every commit.

## Tools Used

| Tool    | Purpose                                          |
|---------|--------------------------------------------------|
| Poetry  | Dependency management and virtual environments   |
| pytest  | Unit testing framework for Python                |
| Jenkins | CI server that runs the pipeline on each commit  |

## Project Structure

```
Example_3/
├── Jenkinsfile                  # Jenkins pipeline configuration
├── pyproject.toml               # Poetry project configuration
├── README.md                    # This file
├── src/
│   └── greeter/
│       ├── __init__.py
│       └── greeter.py           # Main application code
└── tests/
    ├── __init__.py
    └── test_greeter.py          # pytest unit tests
```

## Step 1 — Prerequisites

Make sure you have the following installed:
- Python 3.8 or higher (`python3 --version`)
- Poetry (`poetry --version`) — install via `pip3 install poetry` if missing

> **Note:** After installing Poetry via pip, it may not be on your PATH. If `poetry --version` returns command not found, run:
> ```bash
> export PATH="/Users/<your-username>/Library/Python/3.9/bin:$PATH"
> ```
> To make this permanent:
> ```bash
> echo 'export PATH="/Users/<your-username>/Library/Python/3.9/bin:$PATH"' >> ~/.bash_profile
> source ~/.bash_profile
> ```

## Step 2 — Clone the Repository

```bash
git clone <repo-url>
cd <repo-folder>/Example_3
```

## Step 3 — Install Dependencies and Run Tests Locally

Install dependencies:
```bash
poetry install
```

You should see:
```
Installing the current project: greeter (0.1.0)
```

Run the tests:
```bash
poetry run pytest tests/ -v -s
```

You should see:
```
tests/test_greeter.py::TestGreeter::test_greet test_greet -> Expected: 'Hello, Alice!'  Got: 'Hello, Alice!'
PASSED
1 passed in 0.00s
```

## Step 4 — Understanding the Code

**greeter.py** has three methods:
- `greet(name)` → returns `"Hello, <n>!"`
- `greet_loud(name)` → returns `"HELLO, <n>!"`
- `greet_formal(name)` → returns `"Good day, <n>."`

**test_greeter.py** has one provided test for `greet()`. It prints the expected vs actual value so you can see what the test is doing. Open the file and read the comments for hints on adding your own test.

## Step 5 — Set Up the Jenkins Pipeline

1. Log in to Jenkins at `https://swent0linux.asu.edu/jenkins`
2. Navigate to your group folder
3. Click **New Item** → name it `Example_3` → select **Pipeline** → click OK
4. Under **Pipeline**, set **Definition** to `Pipeline script from SCM`
5. Set **SCM** to `Git` and enter your repository URL
6. Under **Branches to build**, change `*/master` to `*/main`
7. Set **Script Path** to the path of the Jenkinsfile relative to the root of your repo.  
   For example, if your repo contains an `Example_3` folder, set it to `Example_3/Jenkinsfile`
8. Under **Build Triggers**, check **Poll SCM** and set the schedule to `* * * * *` (polls every minute)
9. Click **Save** then click **Build Now** to trigger the first build

> **Important — Docker Agent:**  
> The Jenkinsfile uses a Docker agent (`python:3`) to run the pipeline inside a Python container. This means Jenkins must have Docker available and running. If the build fails with a Docker-related error, Please reach out.  
> On the first run, Jenkins will pull the `python:3` image from Docker Hub which may take a minute or two. Subsequent builds will be faster.

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
test_greet -> Expected: 'Hello, Alice!'  Got: 'Hello, Alice!'
PASSED
1 passed in 0.00s
```

## Step 8 (Optional) — Add Your Own Test

Open `test_greeter.py` and uncomment the optional section at the bottom.  
Try writing a test for `greet_formal()` or `greet_loud()` and push again to see the pipeline re-run with your new test.