# University Library Management System

**Student:** Laura Eraso Lorenzo ERASMUS

## Project Description
This project focuses on developing a management system for a university library. The primary goal is to efficiently manage a diverse inventory of resources (books, digital magazines, audiobooks), user records, and the workflow for loans and returns.

The system will allow:
* Management of a comprehensive catalog of library materials.
* User registration with different access levels (e.g., Students and Professors).
* Monitoring loan deadlines and calculating penalties for late returns.
* Automating notifications for users when a reserved resource becomes available.

This solution aims to automate administrative tasks, ensuring data integrity and providing a seamless user experience.

## Design Patterns

### 1. Singleton (Creational)
**Use in project:** To manage the single instance of the library catalog (central database handler).
**Justification:** In a library system, it is critical that all modules access the same data source to avoid inventory inconsistencies. The Singleton pattern ensures that only one instance of the catalog exists, saving memory and ensuring that if a book is marked as "loaned" in one part of the app, it reflects immediately across the entire system. It provides stricter control over global state compared to simple global variables.

### 2. Factory Method (Creational)
**Use in project:** To handle the creation of different types of library materials (objects like `PhysicalBook`, `DigitalMagazine`, or `Audiobook`).
**Justification:** This pattern decouples the object creation logic from the code that uses them. If the library decides to add new formats in the future, we only need to update the Factory without modifying the existing management logic. It offers better scalability than manual instantiation via direct constructors.

### 3. Observer (Behavioral)
**Use in project:** Implemented within the reservation and availability alert system.
**Justification:** When a highly requested book is currently on loan, users can subscribe to a waiting list. The Observer pattern allows the "Book" object to automatically notify all subscribed users as soon as its status changes to "Available." This eliminates the need for constant polling, optimizing system performance and improving user experience.

### 4. Strategy (Behavioral)
**Use in project:** To calculate fine rates for overdue returns based on user types.
**Justification:** Library policies often differ; for instance, students might have a standard daily fee, while professors might have a grace period or a reduced rate. The Strategy pattern encapsulates these calculation algorithms independently. This results in cleaner, more maintainable code, as business rule changes do not require modifications to the core "Loan" class.

## System Testing
To verify the microservices functionality, a Postman collection has been included:
1. Import the file `tests/Postman_Tests.json` into Postman.
2. Ensure all three services are running on ports 8080 (Inventory), 8081 (Loan), and 8082 (Notification).
3. Run the requests included in the collection to test the system.

## Milestone 5: Message Queue Integration (RabbitMQ)

In this milestone, I integrated **RabbitMQ** to enable asynchronous communication between the `Loan Service` and the `Notification Service`.

### How it works:
1. When a penalty is calculated in the `Loan Service`, it doesn't call the `Notification Service` directly.
2. Instead, it sends a message to a RabbitMQ queue named `libraryQueue`.
3. The `Notification Service` listens to this queue and processes the message as soon as it's available.

### Architecture Benefits :
* **Decoupling:** The Loan Service doesn't need to know if the Notification Service is online or reachable. It only cares about the message broker.
* **Fault Tolerance:** If the Notification Service goes down, messages stay safely in the queue. They are processed automatically once the service restarts.
* **Scalability:** We can easily add more instances of the Notification Service to handle high traffic without affecting the Loan Service performance.