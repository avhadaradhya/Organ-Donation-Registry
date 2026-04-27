# 🏥 Organ Donation Registry & Matching System
[cite_start]**Enterprise Application Development (Advanced Java) Mini Project** [cite: 1, 2]
**SY B.Tech | Course Code: 2304269 | [cite_start]Academic Year 2025-26** [cite: 4]

---

## 👨‍💻 Project Metadata
* **Lead Developer:** Aradhya Uday Avhad
* **PRN:** 202401040039
* **Teammate:** Abhishek Patil
* **College:** MIT Academy of Engineering (MITAOE), Alandi, Pune
* **Problem Statement:** Topic 25 — Organ Donation Registry & Matching [cite: 36]

---

## 🌍 SDG Mapping & Impact
* [cite_start]**Primary Goal:** **SDG 3 — Good Health and Well-being** [cite: 36]
* [cite_start]**Impact Metric:** The platform utilizes a multithreaded matching engine to reduce the manual search time for organ compatibility, directly improving healthcare delivery speed for critical patients[cite: 15, 36].
* **Justification:** By digitizing donor pledges and recipient needs, we ensure a transparent, automated registry that facilitates life-saving transplants[cite: 36, 43].

---

## 🛠 Technology Stack
* [cite_start]**Framework:** Spring Boot 3.x (Embedded Tomcat) [cite: 18, 31]
* [cite_start]**ORM:** Hibernate 6.x with JPA Annotations [cite: 19]
* **Database:** MySQL (5 Normalized Tables with FK constraints) [cite: 30]
* [cite_start]**Security:** Spring Security (Role-based access: ROLE_ADMIN, ROLE_USER) [cite: 25]
* [cite_start]**Front-end:** Thymeleaf Templates [cite: 23]
* **Networking:** JDBC PreparedStatement for raw SQL fallback [cite: 21]
* [cite_start]**Concurrency:** Spring `@Scheduled` and `@Async` for background matching tasks [cite: 27]

---

## 🚀 Key Features (CO Mapping)
* [cite_start]**[CO1] Concurrency:** Implements a multithreaded matching engine to evaluate donor-recipient compatibility in real-time[cite: 7, 36].
* **[CO2] Web Layer:** Utilizes Spring MVC controllers and Thymeleaf for enterprise-grade web deployment and session management[cite: 7, 23].
* [cite_start]**[CO3] Full-Stack Data:** Employs Hibernate CRUD with HQL/Criteria API and @Transactional management for robust data integrity[cite: 7, 43].
* [cite_start]**[CO4] Persistence:** Incorporates JDBC PreparedStatement for high-performance bulk operations where standard ORM is insufficient[cite: 7, 21].

---

## 📂 Database Architecture
[cite_start]The system consists of 5 normalized tables as per project requirements[cite: 30]:
1.  **AppUser:** Stores encrypted credentials and roles for Spring Security.
2.  **Donor:** Records donor health data, blood group, and pledged organs.
3.  **Recipient:** Tracks patients waiting for transplants and urgency levels.
4.  **Hospital:** Manage clinical facilities participating in the registry.
5.  **OrganMatch:** Logs successful connections identified by the matching engine.

---

## 🔧 Installation & Setup
1. **Database:** Create a MySQL schema named `organ_registry_db`.
2. **Properties:** Configure `src/main/resources/application.properties` with your local MySQL username and password.
3. **Build:** Run `mvn clean install` to resolve dependencies.
4. **Execution:** Run `RegistryApplication.java`. [cite_start]The system starts on `http://localhost:8081`[cite: 31].
5. **Login:** Use default credentials `admin` / `admin123`.
