package ch14.lambda;

import java.util.function.Function;

class LambdaEx08 {
    public static void main(String[] args) {
//        Function<String, Integer> f = (String s) -> Integer.parseInt(s);      - 람다식
        Function<String, Integer> f = Integer::parseInt;        //  - 메서드참조 클래스이름::메서드이름;
//        Function<String, Integer> f = (String s) ->  Integer.parseInt(s);       - 람다식
        System.out.println(f.apply("100") + 200);

    }
}
