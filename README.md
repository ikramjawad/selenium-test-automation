# Selenium Test Automation Framework

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-007396?style=flat)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)

A Selenium + Java UI automation framework for the [SauceDemo](https://www.saucedemo.com/) web application, built with the Page Object Model (POM), TestNG, and Maven. It provides a clean, scalable structure for maintainable UI regression and smoke testing.

## Overview

This project automates the core end-to-end user journeys of SauceDemo, including login, inventory browsing, cart management, checkout, and order confirmation. It is designed as a portfolio-quality reference for building robust, reusable test automation.

## Features

- Page Object Model (POM) design for clean separation of test logic and page interactions
- - End-to-end coverage of login, inventory, cart, checkout, and order confirmation flows
  - - Reusable utilities for common actions, waits, and assertions
    - - Centralized configuration management for URLs, credentials, and environment settings
      - - Data-driven and parameterized tests via TestNG
        - - Test reporting for clear pass/fail visibility
          - - Scalable, modular structure suitable for UI regression and smoke suites
           
            - ## Tech Stack
           
            - | Category | Technology |
            - | --- | --- |
            - | Language | Java |
            - | Automation | Selenium WebDriver |
            - | Test Runner | TestNG |
            - | Build Tool | Maven |
            - | Design Pattern | Page Object Model |
           
            - ## Prerequisites
           
            - - Java JDK 8 or higher
              - - Maven 3.6+
                - - A supported browser (e.g. Chrome) and matching WebDriver
                  - - Git
                   
                    - ## Getting Started
                   
                    - 1. Clone the repository:
                     
                      2. ```bash
                         git clone https://github.com/ikramjawad/selenium-test-automation.git
                         cd selenium-test-automation
                         ```

                         2. Install dependencies:
                        
                         3. ```bash
                            mvn clean install
                            ```

                            ## Running the Tests

                            Run the full suite:

                            ```bash
                            mvn test
                            ```

                            Run a specific TestNG suite:

                            ```bash
                            mvn test -DsuiteXmlFile=testng.xml
                            ```

                            ## Project Structure

                            ```
                            selenium-test-automation/
                            ├── src/
                            │   ├── main/java/       # Page objects, utilities, config
                            │   └── test/java/       # Test classes
                            ├── testng.xml           # TestNG suite configuration
                            ├── pom.xml              # Maven dependencies and build config
                            └── README.md
                            ```

                            ## Reporting

                            Test execution reports are generated automatically after each run and can be found in the `test-output/` directory (TestNG default) or the configured reports folder.

                            ## Contributing

                            Contributions, issues, and feature requests are welcome. Feel free to open an issue or submit a pull request.

                            ## Author

                            **ikramjawad** — [GitHub Profile](https://github.com/ikramjawad)
                            
