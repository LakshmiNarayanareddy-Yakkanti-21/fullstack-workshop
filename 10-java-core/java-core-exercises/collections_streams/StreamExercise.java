package collections_streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise {

    record Employee(Long id, String name, String dept, double salary,
                    int years, List<String> skills) {}

    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee(1L,"Alice","Engineering",85000,5,List.of("Java","Python")),
            new Employee(2L,"Bob","Engineering",75000,3,List.of("Java","JS")),
            new Employee(3L,"Charlie","Sales",65000,7,List.of("CRM")),
            new Employee(4L,"Diana","Engineering",95000,8,List.of("Java","Go")),
            new Employee(5L,"Eve","HR",55000,2,List.of("Recruiting"))
        );

        // Engineering sorted by salary
        employees.stream()
                .filter(e -> e.dept().equals("Engineering"))
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .map(Employee::name)
                .forEach(System.out::println);

        // All names uppercase
        employees.stream()
                .map(e -> e.name().toUpperCase())
                .forEach(System.out::println);

        // Group by department
        System.out.println(
            employees.stream().collect(Collectors.groupingBy(Employee::dept))
        );

        // Total years
        int totalYears = employees.stream()
                .map(Employee::years)
                .reduce(0, Integer::sum);
        System.out.println(totalYears);
    }
}
