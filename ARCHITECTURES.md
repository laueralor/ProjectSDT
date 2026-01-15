# Software Architecture Analysis - University Library System

This document provides a detailed investigation and evaluation of three different architectural styles for the University Library Management System.

---

## 1. Monolithic Architecture

### Description
In this architectural style, the entire application is built as a single, unified unit. All the components we implemented in Milestone 2—such as the **LibraryInventory** (Singleton), **MaterialFactory** (Factory), and the notification and penalty logic—reside within the same codebase and run as a single process. 

Communication between components happens through direct method calls in the Java Virtual Machine (JVM). Data is stored in a single, centralized database, and the user interface (CLI or GUI) is bundled together with the business logic.

### Architectural Diagrams

#### Component and Deployment View
The following diagram illustrates how the components are integrated within a single execution unit and deployed on a server.

![Monolithic Architecture](./docs/monolith_architecture.png)

### Pros and Cons

| Pros | Cons |
| :--- | :--- |
| **Simplicity:** Easier to develop, test, and debug since everything is in one place. | **Scaling Issues:** You cannot scale specific parts (e.g., just the notification service) independently; you must scale the whole app. |
| **Performance:** Low latency because there is no network overhead between components. | **Low Fault Tolerance:** If a bug crashes the penalty logic, the entire library system goes offline. |
| **Deployment:** Simple deployment process (usually a single JAR file). | **Technology Lock-in:** The entire system must use the same technology stack (Java). |

### Relevance to the Project
The current state of our University Library project follows this style. It is highly effective for the current proof-of-concept scope, as it allows for rapid development and straightforward implementation of design patterns without the complexity of network communication.