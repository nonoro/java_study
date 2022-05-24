package ch14.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamEx02 {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("a", "b", "c", "d");
        strStream.forEach(System.out::print);

        System.out.println();

        Stream<String> strStream1 = Stream.of(new String[] {"a", "b", "c", "d"});
        strStream1.forEach(System.out::print);

        System.out.println();
        // 위에는 아래처럼도 가능
        String[] str1 = new String[] {"a", "b", "c", "d"};      //     String[] str1 = {"a", "b", "c", "d"};  얘랑 같음

        Stream<String> strStream2 = Stream.of(str1);
        strStream2.forEach(System.out::print);

        System.out.println();

        Stream<String> strStream3 = Arrays.stream(str1);
        strStream3.forEach(System.out::print);

        System.out.println();
        // int 배열
//      기본형스트림, 여기에는 sum, average, count등의 여러가지 함수가있음
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArr);
        intStream.forEach(System.out::print);
        intStream = Arrays.stream(intArr);
        System.out.println("sum=" +intStream.sum());
        intStream = Arrays.stream(intArr);
        System.out.println("avg=" +intStream.average());



        System.out.println();
//      Integer객체스트림, 여기에는 count()의 함수밖에없음 왜냐면 숫자말고도 여러타입의 스트림이 가능해야 하므로
        Integer[] intArr2 = {1, 2, 3, 4, 5};
        Stream<Integer> intStream2 = Arrays.stream(intArr2);
        intStream2.forEach(System.out::print);


        intStream2 = Arrays.stream(intArr2);
        System.out.println("count=" +intStream2.count());




    }
}
