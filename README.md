# Library API Test Suite

Professional API testing framework built with Java, REST Assured, and TestNG. This suite provides robust automated testing for RESTful services, focusing on data-driven scenarios and comprehensive reporting.

## 🚀 Features

* **REST Assured Integration**: Utilizes the powerful REST Assured DSL for clean and readable API tests.
* **Data-Driven Testing**: Externalized test data in JSON format for parameterized testing.
* **Modern Tech Stack**: Java 17, Maven, TestNG, and Allure Reporting.
* **Design Patterns**: Implements Builder pattern for POJOs and SpecBuilder for reusable request/response specifications.
* **Continuous Integration**: Ready for GitHub Actions with automated test execution and reporting.
* **Logging & Assertions**: Integrated Log4j2 for detailed logging and custom assertion utilities for reliable verification.

## 🛠 Tech Stack

* **Language**: Java 17
* **API Client**: REST Assured
* **Test Runner**: TestNG
* **Data Mocking**: Java Faker
* **Configuration**: Owner (Properties management)
* **Boilerplate Reduction**: Lombok
* **Reporting**: Allure Report
* **Static Analysis**: Checkstyle

## 📂 Project Structure

```text
├── src/
│   ├── main/
│   │   └── resources/          # Configuration and logging settings
│   └── test/
│       ├── java/               # Test source code (API, Models, Specs, Tests)
│       └── resources/          # Test data (JSON) and TestNG suites
├── pom.xml                     # Maven project configuration
└── .github/workflows/          # CI/CD pipelines
```

## ⚙️ Prerequisites

* **Java JDK 17** or higher
* **Apache Maven 3.9.0** or higher

## 🏃 Running Tests

To execute the entire test suite, run the following command in your terminal:

```bash
mvn clean test
```

The tests will run in parallel (if configured in `testng.xml`) and provide a summary of results in the console.

## 📊 Reporting

### Allure Reports

To generate and view the interactive Allure report:

1. Install Allure (if not already installed):
   - Windows (Scoop): `scoop install allure`
   - Mac (Homebrew): `brew install allure`

2. After running tests, execute:
   ```bash
   allure serve target/allure-results
   ```

## 🏗 CI/CD

This project includes a pre-configured GitHub Actions workflow that:
1. Runs tests on every push and pull request.
2. Captures test results and generates an Allure report.
3. Automatically deploys the report to GitHub Pages.

---
Developed and maintained by **Taniiie**.
