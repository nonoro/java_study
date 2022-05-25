package ch14.stream;

import java.util.*;
import java.util.stream.*;

class StreamEx09 {
    public static void main(String[] args) {
        String[] strArr = { "Inheritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum" };     //   스트링 배열

        Stream.of(strArr).forEach(System.out::println);
        // 만약 print를 이용해서 단어마다 , 넣고 싶으면 forEach() 괄호안에 System.out::print 대신 str -> System.out.print(str + " ,") 이걸 넣기
//        System.out.println();
//        Stream.of(strArr).parallel().forEachOrdered(str -> System.out.print(str + ", "));       //  병렬일 때 순서 유지하고싶을때 parallel() : 병렬
//        System.out.println();
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);         //  문자열 길이가 0인게 하나도 없는지확인 없으면 true
        Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();     //  스트림 요소중에서 s로 시작하는 문자중 첫번째꺼 = Stream
        System.out.println("noEmptyStr=" + noEmptyStr);
        System.out.println("sWord=" + sWord.get());


        //  Stream<String>을 Stream<Integer>로 변환 (s) -> s.length() = String::length
        //  Stream<Integer> intStream1 = Stream.of(strArr).map.(String::length);  얘랑 아래 mapToInt는 같은것인데 성능의 차이가 있음

        //  Stream<String>을 IntStream으로 변환 IntStream은 기본형 스트림
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum = intStream2.reduce(0, (a,b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

//        아래와 같이 empty() 를 넣을 경우
//        OptionalInt max = IntStream.empty().reduce(Integer::max);
//        System.out.println("max=" + max.orElse(0));

        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
        System.out.println("max=" + max.getAsInt());
        System.out.println("min=" + min.getAsInt());
    }
}

