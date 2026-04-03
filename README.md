# 🛒 DemoWebShop Automation Framework

🚀 A robust **Selenium Test Automation Framework** built using **Java, TestNG, and Maven**, designed to automate real-world e-commerce workflows.

🔗 Target Application: https://demowebshop.tricentis.com/

---

## 📌 Project Overview

| Property        | Value |
|----------------|------|
| Project Name   | DemoWebShop |
| Group ID       | com.project |
| Artifact ID    | DemoWebShop |
| Version        | 0.0.1-SNAPSHOT |
| Packaging      | JAR |
| Type           | Selenium + TestNG Automation Framework |

---

## 🏗️ Architecture & Design

### ✅ Page Object Model (POM)
- Separates page elements from test logic
- Improves maintainability and scalability
- Reduces code duplication

### ✅ Data-Driven Testing
- Uses Excel (.xlsx) files via Apache POI
- Enables multiple test scenarios without code changes

### ✅ Modular Framework
- Base classes for setup/teardown
- Utility classes for reusable logic
- Organized test structure

---

## 📂 Project Structure

DemoWebShop/

├── pom.xml

├── src/

│ ├── main/

│ │ ├── java/

│ │ │ ├── pages/ # Page Object classes

│ │ │ └── utils/ # Utilities

│ │ └── resources/

│ │

│ └── test/

│ ├── java/

│ │ ├── base/ # Base test setup

│ │ └── tests/ # Test classes

│ └── resources/

│ └── testdata/ # Excel test data

│
└── target/


---

## ⚙️ Tech Stack

- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **IDE:** Eclipse  

---

## 📦 Dependencies

| Dependency | Version | Purpose |
|-----------|--------|--------|
| Selenium WebDriver | 4.34.0 | Browser automation |
| TestNG | 7.10.2 | Test execution |
| Apache POI | 5.4.1 | Excel handling |
| POI OOXML | 5.4.1 | XLSX support |

---

## 🔧 Core Components

### 🔹 BaseTest (base/BaseTest.java)
- Initializes ChromeDriver
- Runs browser in incognito mode
- Disables notifications, autofill, and password prompts
- Maximizes browser window
- Launches application URL
- Uses `@BeforeSuite` and `@AfterSuite`

---

### 🔹 Page Object Classes (pages/)

| Class | Purpose |
|------|--------|
| HomePage | Home page interactions |
| LoginPage | Login functionality |
| RegisterPage | User registration |
| ProductPage | Product interaction |
| ShoppingCart | Cart operations |
| CheckoutPage | Checkout process |
| OrderInfo | Order details |
| PdfInvoicePage | Invoice handling |
| CategoryPage | Category browsing |

---

### 🔹 Utility Classes (utils/)

| Class | Purpose |
|------|--------|
| ExcelUtil | Read Excel test data |
| ScreenshotUtil | Capture screenshots |

---

## 🧪 Test Classes

| Test Class | Purpose |
|-----------|--------|
| LoginTest | Login validation |
| RegisterTest | User registration |
| ProductPageAddCart | Add to cart |
| CategoryTest | Category browsing |
| CartPageTest | Cart validation |
| E2EFullFlow | End-to-end workflow |
| ScreenshotTest | Screenshot testing |

---

## 📊 Test Data

- Location: `src/test/resources/testdata/`
- File: `LoginData.xlsx`
- Format: XLSX
- Used for data-driven testing

---

## 🧠 Key Features

- ✅ Page Object Model (POM)
- ✅ Data-driven testing using Excel
- ✅ Explicit waits (WebDriverWait)
- ✅ Screenshot capture
- ✅ Modular framework design
- ✅ Reusable utilities
- ✅ End-to-end automation

---

## 🔄 Test Scenarios Covered

1. User Registration  
2. User Login (valid & invalid)  
3. Product browsing  
4. Add to Cart  
5. Checkout process  
6. Order management  
7. End-to-End flow  

---

## ▶️ How to Run

### 🔹 Prerequisites
- Java 8+
- Maven
- Chrome browser

---

### 🔹 Run using Maven
mvn clean test
mvn test -Dtest=LoginTest
mvn clean package


---

### 🔹 Run using TestNG

- Right-click `testng.xml`
- Select **Run As → TestNG Suite**

---

## 📈 Reports

- Location: `test-output/`
- HTML Report: `emailable-report.html`
- JUnit Reports: `junitreports/`

---

## 🚀 Project Capabilities

- ✔ Automated UI Testing  
- ✔ Data-driven testing  
- ✔ Screenshot capture  
- ✔ Multiple test scenarios  
- ✔ End-to-end automation  
- ✔ Reporting support  
- ✔ Scalable architecture  

---

## 🔮 Future Enhancements

- Add Extent Reports  
- Integrate Cucumber (BDD)  
- CI/CD using GitHub Actions / Jenkins  
- Cross-browser testing (Selenium Grid)  
- Docker integration  

---

## 👨‍💻 Author

**Mohan**  
- Automation Testing | Full Stack | Cybersecurity  
- Aspiring Software Engineer  

---

## ⭐ Project Highlights

- Industry-level automation framework  
- Real-world e-commerce testing scenarios  
- Clean and scalable architecture  
- Ready for CI/CD integration  

---
