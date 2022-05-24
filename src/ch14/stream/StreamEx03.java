package ch14.stream;

import java.util.Random;
import java.util.stream.IntStream;

class StreamEx03 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints();      //  무한 스트림
        intStream.limit(5).forEach(System.out::println);        //  여기서 limits이 없으면 무한스트림 으로 무한으로 출력됨


        //  난수말고 갯수를 준 유한스트림
        IntStream intStream2 = new Random().ints(5);      //  유한 스트림
        intStream2.forEach(System.out::println);

        IntStream intStream3 = new Random().ints(5, 10);      //  5~9까지의 숫자를 랜덤으로 생성
        intStream3.limit(5).forEach(System.out::println);                                       //  5개 만 출력

        IntStream intStream4 = new Random().ints(5, 5, 10);      //  크기를 5개로 정하고 5~9까지의 숫자를 랜덤으로 생성
        intStream4.forEach(System.out::println);                                       //  5개 만 출력

    }
}
