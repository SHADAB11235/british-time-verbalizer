# 🕰️ British Time Verbalizer

British Time Verbalizer is a **Java application** that converts digital 24-hour time (`HH:mm`) into its corresponding **British spoken form**  
(e.g., `07:30` → _"half past seven"_). It includes clean architecture, JUnit 5 testing, and Java best practices.

---

## 📌 Problem Statement

In British English:
- `"half ten"` means **10:30** (_i.e., half past ten_)
- Expressions like **“quarter to”**, **“quarter past”**, and **“five to”** are commonly used
- Special cases:
  - `00:00` → _"midnight"_
  - `12:00` → _"noon"_

This application takes a time string in `HH:mm` format and returns its **spoken British form**.

---

## 🚀 Features

- 🗣️ Converts 24-hour time to British spoken format
- 🧪 Fully tested using **JUnit 5**
- ✅ Covers edge cases like `00:00`, `12:00`, `06:32`
- ♻️ Extensible via **Strategy Pattern**
- 🛠️ Built with clean, maintainable **OOP architecture**

---

## 🧰 Getting Started

### 🔧 Prerequisites

- Java 11 or higher
- Maven 3.6+

---

## ▶️ Run the App

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="org.time.spoken.BritishTimeVerbalizer"
```

**Example Input**

Enter time in HH:mm format: 07:30

**Example Output**

Spoken Time: half past seven

**Running Tests**

mvn test

### ✅ Test Cases Cover

- **Exact hours** (`01:00` → “one o’clock”)
- **Past times** (`04:15` → “quarter past four”)
- **To times** (`09:45` → “quarter to ten”)
- **Irregular spoken times** (`06:32` → “six thirty-two”)
- **Invalid input** (`99:99` → Exception thrown)


## 🧱 Design & Patterns

- **Strategy Pattern**: `TimeFormatter` interface allows for future expansion (e.g., `GermanTimeFormatter`)
- **Utility Class**: `NumberWordsMapper` handles word mapping for reusability
- **Modular & Scalable**: Clean separation of logic, test, and user interaction


👤 Author

Mohd Shadab
GitHub: @SHADAB11235
