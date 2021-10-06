import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        List<String> list = Stream.of("Lonkey", "Lion", "Giraffe", "Lumur")
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(toList());
        System.out.println(list);
        Stream<String> st = list.stream();
        System.out.println(list.stream().count());
        st.count();
        list.stream().forEach(System.out::println);
        list.stream().forEach(s -> System.out.println(s));
        list.stream().filter(s -> {
                    return s.charAt(1) == 'O';
                })
                .forEach(System.out::println);

        IntStream oneTwoThree = IntStream.of(1, 2, 3);
        List<Integer> numeros;
        System.out.println(oneTwoThree.average()
                .orElseGet(() -> 0.0));
        list.stream().sorted((o1, o2) -> o1.compareTo(o2) * -1)
                .forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(s -> s.charAt(0)))
                .forEach(System.out::println);


        list.stream().map(s -> s.substring(1, 3))
                .filter(s -> s.length() > 2)
                .forEach(System.out::println);

        System.out.println(list.stream()
                .mapToInt(value -> value.length())
                .max().getAsInt());

        new Random().ints().parallel().limit(50).sorted()
                .forEachOrdered(System.out::println);

        list.stream().flatMap(s -> s.chars().mapToObj(i -> (char) i))
                .distinct().forEach(System.out::println);

        System.out.println(list.stream().collect(Collectors.joining(",")));

        int a[] = {1,2,3,4,5};
        System.out.println(Arrays.stream(a).max().orElse(10));
    }


}
