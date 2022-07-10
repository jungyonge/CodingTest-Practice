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

        int[] intArr = new int[]{1, 2, 3, 4, 5};

        long a = Arrays.stream(intArr).filter(x -> x % 2 == 0).count();

        System.out.println(a);

        List<String> list1 = Arrays.asList("A군", "B군", "C군", "D군", "E군", "F군");

        // 순차처리
        Stream<String> stream1 = list1.stream();
        stream1.forEach(StreamTest :: print);

        System.out.println();

        // 병렬처리
        Stream<String> parallelStream = list1.parallelStream();
        parallelStream.forEach(StreamTest :: print);
    }

    public static void print(String str){
        System.out.println(str + " : " + Thread.currentThread().getName());
    }


}
