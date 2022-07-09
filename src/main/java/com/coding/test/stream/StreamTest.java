package com.coding.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        list.stream()
                .filter("b"::equals)
                .forEach(System.out::println);

        String[] arr = new String[]{"a", "b", "c"};
        java.util.stream.Stream<String> stream = Arrays.stream(arr);
        java.util.stream.Stream<String> streamOfArrayPart =
                Arrays.stream(arr, 1, 3); // 1~2 요소 [b, c]
        List<String> test = stream.map(x -> x + "다").collect(Collectors.toList());
        test.forEach(System.out::println);

        Stream<String> names = Stream.<String>builder().add("keesun").add("whiteship").build();
        names.forEach(System.out::println);

        IntStream ramInt = new Random().ints();

        String[][] namesArray = new String[][]{
                {"kim", "taeng"}, {"mad", "play"},
                {"kim", "mad"}, {"taeng", "play"}};

        List<String> namesWithFlatMap = Arrays.stream(namesArray)
                .flatMap(Arrays::stream)
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        namesWithFlatMap.stream().forEach(System.out::println);
    }

}
