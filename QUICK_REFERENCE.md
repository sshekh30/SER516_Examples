# Quick Reference Card 
---

## 📁 Project Structure
```
taiga-jenkins-demo/
├── src/
│   ├── main/java/com/asu/ser516/
│   │   ├── Calculator.java          (TG-1: Arithmetic operations)
│   │   └── StringUtils.java         (TG-2: String utilities)
│   └── test/java/com/asu/ser516/
│       ├── CalculatorTest.java      (TG-3: 10 test cases)
│       └── StringUtilsTest.java     (TG-4: 12 test cases)
├── pom.xml                           (Maven configuration)
├── Jenkinsfile                       (TG-5: CI/CD pipeline)
├── README.md                         (Project overview)
└── .gitignore                        (Git ignore rules)
```


## Test Coverage

### Calculator Tests (10 tests)
- Addition (positive numbers)
- Addition (negative numbers)
- Subtraction
- Multiplication
- Division
- Division by zero (exception)
- Power calculation
- Square root
- Square root negative (exception)
- Chained operations

### StringUtils Tests (12 tests)
- String reversal
- Reverse null input
- Palindrome detection
- Palindrome null input
- Vowel counting
- Vowel count null input
- Word capitalization
- Capitalize empty string
- Capitalize null input
- Word counting
- Word count null input
- Multiple spaces handling

**Total: 22 tests**

---

## Jenkins Pipeline Stages

1. **Checkout** - Pull code from GitHub
2. **Build** - Compile Java code (`mvn clean compile`)
3. **Test** - Run JUnit tests (`mvn test`)
4. **Package** - Create JAR file (`mvn package`)
5. **Archive** - Store artifacts for download

---

## Quick Commands

### Local Testing
```bash
# Compile code
mvn compile

# Run all tests
mvn test

# Run specific test
mvn test -Dtest=CalculatorTest

# Build JAR
mvn package

# Clean build
mvn clean
```

---

## Integration Flow

```
Developer → Taiga Task Created
              ↓
          Code Changes
              ↓
       Commit with TG-X reference
              ↓
          Push to GitHub
              ↓
       Jenkins detects change
              ↓
      Jenkins runs pipeline
              ↓
         Tests execute
              ↓
      Results reported
              ↓
    Update Taiga task status (Manual)
```

## Common Issues & Solutions

| Issue | Solution |
|-------|----------|
| Maven not found | Configure in Jenkins Global Tool Configuration |
| Tests fail | Run `mvn test` locally first to debug |
| Git repo not found | Check URL and credentials |
| Build hangs | Check Java version (needs 11+) |

---

## Expected Jenkins Output

```
Stages:
Checkout      [SUCCESS]
Build         [SUCCESS]
Test          [SUCCESS]
Package       [SUCCESS]
Archive       [SUCCESS]

Test Results:
CalculatorTest: 10/10 passed
StringUtilsTest: 12/12 passed
Total: 22 tests, 0 failures

Artifacts:
taiga-jenkins-demo-1.0-SNAPSHOT.jar (Created)
```


