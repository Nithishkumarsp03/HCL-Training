# Employee Directory

A simple Java console application that manages employee information using Java Collections, Maps, Comparators, and Sets.

## Features

- **Employee Lookup:** Find employees quickly using a `HashMap` and employee ID.
- **Department Count:** Count employees in each department using `Map.merge()`.
- **Department Report:** Group employees by department and display departments alphabetically using `TreeMap`.
- **Sort by ID:** Sort employees by ID using `Comparable`.
- **Top Five Salaries:** Display the five highest-paid employees using `Comparator`.
- **Duplicate Detection:** Identify employees with the same ID using `equals()` and `hashCode()` with a `HashSet`.

## Technologies Used

- Java
- Java Collections Framework
- HashMap and TreeMap
- ArrayList and HashSet
- Comparable and Comparator
- Java Streams and Lambda Expressions

## Project Structure

```text
EmployeeDirectory/
├── EmployeeDirectory.java
└── README.md
```

## How to Run

**1. Compile the program**

```bash
javac EmployeeDirectory.java
```

**2. Run the application**

```bash
java EmployeeDirectory
```

## Concepts Practiced

| Concept | Purpose |
|---|---|
| `HashMap` | Store and retrieve employees by ID |
| `Map.merge()` | Count employees by department |
| `TreeMap` | Maintain departments in sorted order |
| `Comparable` | Define the default employee sorting order |
| `Comparator` | Sort by salary and then by name |
| `equals()` | Compare employees using their IDs |
| `hashCode()` | Support correct hash-based collection behavior |
| `HashSet` | Store unique employees |
| Streams | Sort, limit, and display employee records |

## Expected Behavior

The program displays an employee lookup, department counts, a department-wise report, employees sorted by ID, the top five salaries, and a demonstration of duplicate employee IDs.

## Learning Objective

The goal of this project is to understand how Java collections work together in a practical employee management scenario, with a focus on efficient lookups, sorting, grouping, and object equality.

## Future Improvements

- Add new employees dynamically.
- Implement employee update and delete operations.
- Add search by name or department.
- Accept employee details through console input.
- Store employee records in a database.
