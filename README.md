# 🏛️ Distributed University Library Management System

A distributed, event-driven microservices platform designed to handle university library workflows, inventory cataloging, loan lifecycle tracking, automated late-return penalties, and asynchronous user notifications.

Developed as an individual engineering project during the **Erasmus Program**.

---

## 🏗️ Architecture & Microservices Overview

The platform is designed following a decoupled, service-oriented architecture with asynchronous event-driven messaging:

```
+-------------------+       +-------------------+       +-----------------------+
| Inventory Service |       |   Loan Service    | ----> | RabbitMQ Message Bus  |
|    (Port 8080)    |       |    (Port 8081)    |       |    (libraryQueue)     |
+-------------------+       +-------------------+       +-----------------------+
                                                                    |
                                                                    v
                                                        +-----------------------+
                                                        | Notification Service  |
                                                        |      (Port 8082)      |
                                                        +-----------------------+
```

* **Inventory Service (Port 8080):** Manages cataloging and real-time availability across diverse resource types (Physical Books, Digital Magazines, Audiobooks).
* **Loan Service (Port 8081):** Handles checkout/checkin transactions, due-date monitoring, and automated late penalty calculations.
* **Notification Service (Port 8082):** Consumes event messages asynchronously to process alerts and availability notifications.
* **Message Broker (RabbitMQ):** Enables reliable, decoupled queue-based communication via `libraryQueue`.

---

## 🧩 Software Design Patterns (GoF)

The core business logic leverages object-oriented design patterns to guarantee maintainability and extensibility:

1. **Singleton (Creational):** Encapsulates the centralized library catalog database handler, preventing concurrency conflicts and state inconsistencies across modules.
2. **Factory Method (Creational):** Decouples material creation logic (`PhysicalBook`, `DigitalMagazine`, `Audiobook`), enabling seamless addition of future media formats.
3. **Observer (Behavioral):** Implemented in the reservation alert pipeline; subscribed users are automatically notified when loaned resources transition back to `Available` without polling overhead.
4. **Strategy (Behavioral):** Encapsulates interchangeable fine-calculation algorithms based on user role hierarchies (e.g., student rates vs. faculty grace periods).

---

## ⚡ Asynchronous Integration & Resilience (RabbitMQ)

* **Loose Coupling:** The Loan Service dispatches penalty events to RabbitMQ without needing direct knowledge of Notification Service availability.
* **Fault Tolerance:** In the event of downstream service degradation, messages persist safely in `libraryQueue` until consumers reconnect.
* **Horizontal Scalability:** Allows spinning up multiple notification worker instances to absorb traffic spikes without degrading transactional throughput.

---

## 🛠️ Tech Stack & DevOps

* **Language & Build Tool:** Java 11, Apache Maven
* **Architecture:** Distributed Microservices, Event-Driven Architecture (EDA)
* **Message Broker:** RabbitMQ
* **Containerization:** Docker, Docker Compose
* **CI/CD Pipeline:** GitHub Actions (Automated Java 11 compilation and Docker multi-container build verification)
* **API Testing:** Postman Test Suite (`tests/Postman_Tests.json`)

---

## 🚀 Installation & Local Execution

### Prerequisites
* **Docker** and **Docker Compose** installed and running.
* **Git** installed.

### 1. Clone the repository and switch to the production branch
```bash
git clone [https://github.com/laueralor/university-library-microservices.git](https://github.com/laueralor/university-library-microservices.git)
cd university-library-microservices
git checkout 5-university-library-management
```

### 2. Launch the Microservices Cluster
```bash
docker compose up --build
```

The services will initialize on their respective ports:
* **Inventory Service:** `http://localhost:8080`
* **Loan Service:** `http://localhost:8081`
* **Notification Service:** `http://localhost:8082`

---

## 🧪 System & Integration Testing

Automated API and workflow validation is provided via Postman:

1. Import `tests/Postman_Tests.json` into Postman.
2. Ensure the Docker container cluster is healthy.
3. Execute the collection runner to validate inter-service endpoints, queue events, and error handling.

---

## 👤 Author

* **Laura Eraso Lorenzo** ([@laueralor](https://github.com/laueralor)) — Erasmus Student
