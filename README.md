# Mini Hospital Emergency Management System

A Java-based Mini Hospital Emergency Management System that uses fundamental data structures to manage patient records, emergency queues, treatment history, and patient visit history.

## Data Structures Used

| Data Structure | Purpose | Implementation |
|---|---|---|
| Binary Search Tree (BST) | Patient Records | Insert, search, delete, in-order traversal by Patient ID |
| Queue | Emergency Patient Queue | FIFO enqueue/dequeue for waiting patients |
| Stack | Treatment History | LIFO push/pop for completed treatment records |
| Singly Linked List | Patient Visit History | Add, remove, search, display past visits per patient |

## Project Structure

```
src/
├── HospitalSystem.java      # Main class with menu-driven interface
├── Patient.java             # Patient data model
├── PatientBST.java          # BST for patient records
├── EmergencyQueue.java      # Queue for emergency patients
├── TreatmentStack.java      # Stack for treatment history
├── VisitNode.java           # Node for visit linked list
└── PatientVisitHistory.java # Singly Linked List for visit history
```

## How to Compile and Run

```bash
cd src
javac HospitalSystem.java
java HospitalSystem
```

## Features

### 1. Patient Records (BST) — 20 Marks
- Insert a new patient with ID, name, age, contact, and medical condition
- Search for a patient by Patient ID
- Delete a patient by Patient ID
- Display all patients in ascending order (in-order traversal)

### 2. Emergency Patient Queue (Queue) — 20 Marks
- Enqueue patients arriving at the emergency unit (FIFO)
- Dequeue the next patient for treatment
- Display all patients currently waiting
- Handles empty queue gracefully

### 3. Treatment History (Stack) — 20 Marks
- Push completed treatment records onto the stack (LIFO)
- Pop the most recent treatment record
- Peek at the latest record without removing
- Display all treatment records (most recent first)
- Handles empty stack gracefully

### 4. Patient Visit History (Singly Linked List) — 20 Marks
- Each patient has their own linked list of previous visits
- Add a new visit with date, doctor, diagnosis, and treatment
- Remove a visit by Visit ID
- Search for a visit by Visit ID
- Display full visit history for a patient

### 5. GitHub Repository — 10 Marks
- Complete Java source code with proper project structure
- Progressive commit history showing development stages
- README file with documentation
