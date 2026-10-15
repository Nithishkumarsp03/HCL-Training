
import java.util.*;

class Employee implements Comparable<Employee> {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}

public class EmployeeDirectory {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(103, "Arun", "IT", 65000),
                new Employee(101, "Bala", "HR", 50000),
                new Employee(102, "Divya", "IT", 80000),
                new Employee(104, "Meena", "Finance", 72000),
                new Employee(105, "Kiran", "IT", 80000),
                new Employee(106, "Sara", "HR", 60000)
        );

        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println("Employee details:");
        System.out.println(employeeMap.get(102));

        Map<String, Integer> departmentCounts = new HashMap<>();

        for (Employee employee : employees) {
            departmentCounts.merge(
                    employee.getDepartment(), 1, Integer::sum
            );
        }

        System.out.println("\nDepartment counts:");
        departmentCounts.forEach((department, count) ->
                System.out.println(department + ": " + count)
        );

        Map<String, List<Employee>> departmentReport = new TreeMap<>();

        for (Employee employee : employees) {
            departmentReport.computeIfAbsent(
                    employee.getDepartment(),
                    department -> new ArrayList<>()
            ).add(employee);
        }

        System.out.println("\nEmployees by department:");
        departmentReport.forEach((department, staff) -> {
            System.out.println(department + ":");

            for (Employee employee : staff) {
                System.out.println("  " + employee);
            }
        });

        List<Employee> employeesById = new ArrayList<>(employees);
        Collections.sort(employeesById);

        System.out.println("\nEmployees sorted by ID:");
        employeesById.forEach(System.out::println);

        Comparator<Employee> salaryComparator =
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName);

        System.out.println("\nTop five highest-paid employees:");

        employees.stream()
                .sorted(salaryComparator)
                .limit(5)
                .forEach(System.out::println);

        Employee first = new Employee(101, "Bala", "HR", 50000);
        Employee second = new Employee(101, "Different Name", "IT", 90000);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(first);
        employeeSet.add(second);

        System.out.println("\nAre both employees equal? "
                + first.equals(second));

        System.out.println("Unique employees in HashSet: "
                + employeeSet.size());
    }
}
