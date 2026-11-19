
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + department + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "Ravi", "IT", 50000),
            new Employee(2, "Raj", "HR", 30000),
            new Employee(3, "Kiran", "IT", 70000),
            new Employee(4, "Arjun", "Finance", 45000),
            new Employee(5, "Sai", "HR", 60000)
        );

        // 1. MAP
        employees.stream()
            .map(e -> e.name.toUpperCase())
            .forEach(System.out::println);

        // 2. FILTER
        employees.stream()
            .filter(e -> e.salary > 40000)
            .forEach(System.out::println);

        // 3. DISTINCT
        employees.stream()
            .map(e -> e.department)
            .distinct()
            .forEach(System.out::println);

        // 4. SKIP
        employees.stream()
            .skip(2)
            .forEach(System.out::println);

        // 5. PEEK
        employees.stream()
            .peek(e -> System.out.println("Processing " + e.name))
            .forEach(System.out::println);

        // 6. ANYMATCH
        System.out.println(employees.stream()
            .anyMatch(e -> e.salary > 60000));

        // 7. ALLMATCH
        System.out.println(employees.stream()
            .allMatch(e -> e.salary > 20000));

        // 8. NONEMATCH
        System.out.println(employees.stream()
            .noneMatch(e -> e.salary < 10000));

        // 9. FINDFIRST
        System.out.println(employees.stream()
            .findFirst().orElse(null));

        // 10. FINDANY
        System.out.println(employees.stream()
            .findAny().orElse(null));

        // 11. TOARRAY
        String[] names = employees.stream()
            .map(e -> e.name)
            .toArray(String[]::new);

        System.out.println(Arrays.toString(names));

        // 12. GROUPINGBY
        Map<String, List<Employee>> groups =
            employees.stream()
            .collect(Collectors.groupingBy(e -> e.department));

        System.out.println(groups);

        // 13. PARTITIONINGBY
        Map<Boolean, List<Employee>> parts =
            employees.stream()
            .collect(Collectors.partitioningBy(e -> e.salary > 40000));

        System.out.println(parts);
    }
}
