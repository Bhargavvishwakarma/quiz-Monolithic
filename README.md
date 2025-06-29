# 🧠 Monolithic Quiz Application

A full-stack monolithic application built using **Spring Boot**, combining both **Quiz** and **Question** services into a single deployable project. The application allows users to manage quizzes and their associated questions.

---

## 📌 Features

- ✅ Single Spring Boot application for all logic
- 📚 Create and manage **quizzes**
- ❓ Add and retrieve **questions** per quiz
- 🔁 Simple REST APIs using Spring Web
- 💾 JPA and Hibernate integration for persistence
- 📦 Maven-based project structure

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (configurable)
- Maven
- Swagger (optional)

---

## 📁 Project Structure

quiz-monolithic-app/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/bhargav/quizapp/
│ │ │ ├── controller/
│ │ │ ├── service/
│ │ │ ├── model/
│ │ │ ├── dao/
│ │ │ └── QuizApplicatio.java
│ │ └── resources/
│ │ ├── application.properties
│ 
│
└── pom.xml
