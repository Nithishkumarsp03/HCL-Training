# Day 9 — Java Generics and Resource Management

A Java learning project focused on type-safe programming, reusable repository design, wildcard usage, and automatic resource management.

## Features

- Generic `Pair<K, V>` for storing two different types.
- Bounded `Box<T extends Number>` for numeric values.
- Generic `max()` method for comparing values.
- Wildcard methods using `?`, `? extends Number`, and `? super Integer`.
- Generic CRUD operations through `CrudRepository<T, ID>`.
- Reusable `InMemoryRepository<T, ID>` for different entity types.
- Product seed data loaded from a CSV file.
- Try-with-resources for automatic file closing.
- Custom `AutoCloseable` resources to demonstrate closing order.

## Project Structure

```text
Day9/
├── src/
│   ├── Pair.java
│   ├── Box.java
│   ├── GenericToolkit.java
│   ├── CrudRepository.java
│   ├── InMemoryRepository.java
│   ├── Product.java
│   ├── ProductCsvLoader.java
│   ├── ResourceDemo.java
│   └── Main.java
├── data/
│   └── products.csv
└── README.md
```

## How to Run

Use Java 11 or later.

Compile the Java files from the project root:

```bash
javac -d out src/*.java
```

Run the application:

```bash
java -cp out Main
```

Keep the `data/products.csv` file in the project root so the CSV loader can find it.

## Concepts Practiced

| Concept | Application |
|---|---|
| Generic classes | `Pair<K, V>` and `Box<T>` |
| Bounded types | Restricting `Box` to numeric types |
| Generic methods | Finding the maximum value |
| Wildcards | Reading and writing generic collections |
| PECS | Choosing `extends` for producers and `super` for consumers |
| Type erasure | Understanding generic runtime limitations |
| Generic interfaces | Defining reusable CRUD operations |
| Generic implementations | Storing different entity types in memory |
| Try-with-resources | Automatically closing the CSV reader |
| `AutoCloseable` | Demonstrating resource cleanup |
| CSV loading | Initializing repositories with seed data |

## Learning Objective

The objective is to understand how generics improve type safety and code reuse, and how resource management helps prevent resource leaks. The repository design separates CRUD operations from individual entity models, making the implementation easier to maintain and extend.

## Future Improvements

- Add update and duplicate-ID validation rules.
- Support CSV fields containing quoted commas.
- Add unit tests for repository operations.
- Replace in-memory storage with a database implementation.
