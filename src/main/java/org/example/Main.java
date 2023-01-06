package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person(43, 19000, 5.9, "Ashu", Department.HR),
                new Person(25, 24000, 5.6, "Xhsui", Department.ACCOUNT),
                new Person(56, 30000, 4.6, "Sujan", Department.HR),
                new Person(61, 40000, 8.6, "Alexs", Department.ADMIN),
                new Person(25, 32000, 3.6, "Uert", Department.HR),
                new Person(13, 21000, 1.6, "Qwera", Department.ADMIN));
        //System.out.println(people.stream().collect(Collectors.toMap(p -> new PersonKey(p.getAge(),p.getSalary(),p.getDepartment()), Function.identity())));
        String letters = "ashutosh";

        //Map<Character,Long> res =
                letters.chars().mapToObj(a->(char)a).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k,v) -> System.out.println(k+ "  " +v));
        System.out.println(people.stream().collect(Collectors.toMap(Person::getAge, Function.identity(),(oldValue,newValue) -> newValue)));
        //System.out.println(res);
    }
}