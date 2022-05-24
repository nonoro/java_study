package ch14.stream;

import java.util.stream.Stream;

class StreamEx04 {
    public static void main(String[] args) {

        //  iterate(T seed, UnaryOperator f) : 단항 연산자
        //          초기값    단항연산자           하나 넣으면 결과 하나나오는것 (이항연산자 : 두개넣으면 결과 하나 나오는것)
        Stream<Integer> intStream = Stream.iterate(1, n -> n + 2);
        intStream.limit(10).forEach(System.out::println);


        //  generate(Supplier s) : 주기만 하는것 입력x, 출력o
        Stream<Integer> oneStream = Stream.generate((() -> 1));
        oneStream.limit(5).forEach(System.out::println);
    }
}
