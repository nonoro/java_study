package ch14.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class StreamEx01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();      //  list를 Stream으로 변환
        intStream.forEach(System.out::print);
//        intStream.forEach(System.out::print);           //  최종연산을 한번해서 스트림을 다 소모했기 때문에 이건 에러뜸
        // 따라서 IntStream.forEach(System.out::print); 를 한번 더 쓰고싶으면 List에서 Stream을 다시 생성하면됨
        intStream = list.stream();
        intStream.forEach(System.out::print);
    }
}
