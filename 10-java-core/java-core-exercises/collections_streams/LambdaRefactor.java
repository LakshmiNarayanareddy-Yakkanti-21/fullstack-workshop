package collections_streams;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaRefactor {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Java", "Python", "C");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        // 1. Sort by length
        names.sort(Comparator.comparingInt(String::length));

        // 2. Filter evens
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // 3. Print
        names.forEach(System.out::println);

        // 4. Thread
        Thread t = new Thread(() -> System.out.println("Running"));
        t.start();

        // 5. Uppercase
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upper);
    }
}
