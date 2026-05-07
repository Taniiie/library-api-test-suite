# Library API Test Suite

[![Java Version](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
[![Maven Central](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.8.0-brightgreen.svg)](https://testng.org/)
[![Allure](https://img.shields.io/badge/Allure-2.24.0-yellow.svg)](https://qameta.io/allure-report/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A professional, enterprise-grade API testing framework built for reliability, speed, and deep visibility. This suite provides advanced REST Assured techniques, including Custom Interceptors, Dynamic Mocking, and Data-Driven Architecture.

---

## Key Features

*   **Smart Mocking (MockFilter)**: Custom-built Rest Assured Filter that detects network blocks or Cloudflare protection and automatically switches to local mock data for 100% test reliability.
*   **Data-Driven Engine**: Decoupled test logic from data using externalized JSON providers for high-scale scenario testing.
*   **Spec-Driven Design**: Centralized Request and Response specifications to ensure consistency and eliminate code duplication.
*   **Interactive Reporting**: Rich, visual Allure reports with step-by-step execution details and automated CI/CD integration.
*   **Robust POJO Mapping**: Hand-crafted Model-driven architecture (replacing unstable annotations) for maximum compatibility across environments.
*   **Continuous Integration**: Fully automated pipelines for testing and report deployment via GitHub Actions.

---

## Tech Stack

| Category | Tool |
| :--- | :--- |
| **Language** | Java 17 |
| **API Framework** | REST Assured |
| **Test Runner** | TestNG |
| **Reporting** | Allure Report |
| **Data Generation** | Java Faker |
| **Logging** | Log4j2 |
| **Configuration** | Owner Library |

---

## Project Structure

```text
├── config/checkstyle/      # Static code analysis rules
├── .github/workflows/      # CI/CD Pipeline definitions
├── src/test/java/
│   ├── api/               # API endpoint definitions
│   ├── constants/         # Global constants and Enums
│   ├── factories/         # Data loaders and Faker factories
│   ├── models/            # POJO mapping for JSON responses
│   ├── specs/             # Reusable Req/Res Specifications
│   ├── tests/             # Functional & Regression test cases
│   └── utils/             # MockFilter, Assertions, and JSON Utils
└── src/test/resources/
    ├── test-data/         # JSON data for Mocking & DRL
    └── test-suites/       # TestNG XML configurations
```

---

## Getting Started

### Prerequisites
*   **Java JDK 17**
*   **Maven 3.9+**

### Execution
Run the full regression suite with a single command:
```bash
mvn clean test
```

### Smart Mocking (Experimental)
This project features a custom MockFilter. If the target API (service.verivox.de) is unreachable or protected by Cloudflare, the framework will automatically serve data from src/test/resources/test-data/ without any changes needed to your test code.

---

## Reporting and Insights

### Local Allure Report
Generate a stunning, interactive dashboard to analyze your test results:

1.  Run tests: `mvn test`
2.  Serve the report:
    ```bash
    allure serve target/allure-results
    ```

### GitHub Pages
Reports are automatically deployed to GitHub Pages on every successful run in the CI pipeline.

---

## Contribution and License
This project is open-source under the MIT License. Developed and maintained by Taniiie.

---
*Stay stable, stay automated.*
