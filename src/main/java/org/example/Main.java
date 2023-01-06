package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person(43, 19000, 5.9, "Ashu", Department.HR),
                new Person(25, 24000, 5.6, "Xhsui", Department.ACCOUNT),
                new Person(56, 30000, 4.6, "Sujan", Department.HR),
                new Person(61, 40000, 8.6, "Alexs", Department.ADMIN),
                new Person(25, 32000, 3.6, "Uert", Department.HR),
                new Person(13, 21000, 1.6, "Qwera", Department.ADMIN));
        // System.out.println(people.stream().collect(Collectors.toMap(p -> new
        // PersonKey(p.getAge(),p.getSalary(),p.getDepartment()),
        // Function.identity())));
        String letters = "ashutosh";
        people.stream().collect(Collectors.toMap(p -> p.getAge(), Function.identity(), (o, n) -> n));
        // Map<Character,Long> res =
        letters.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "  " + v));
        System.out.println(people.stream()
                .collect(Collectors.toMap(Person::getAge, Function.identity(), (oldValue, newValue) -> newValue)));
        // System.out.println(res);
        // Accumulate names into a List
        List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(list);
        // Accumulate names into a TreeSet
        Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
        // Convert elements to strings and concatenate them, separated by commas
        String joined = Arrays.asList("ashu", "pandey").stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(joined);
        // Compute sum of salaries of employee
        long total = people.stream()
                .collect(Collectors.summingLong(Person::getSalary));
        System.out.println(total);
        // Group employees by department
        Map<Department, List<Person>> byDept = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment));
        System.out.println(byDept);
        // Compute sum of salaries by department
        Map<Department, Long> totalByDept = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.summingLong(Person::getSalary)));
        System.out.println(totalByDept);
        // Partition students into passing and failing
        Map<Boolean, List<Person>> passingFailing = people.stream()
                .collect(Collectors.partitioningBy(s -> s.getSalary() >= 20000));
        System.out.println(passingFailing);

        System.out.println(Arrays.asList(3,5,3,5,5,6,2,5,6,5).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

}