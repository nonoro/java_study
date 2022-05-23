package ch14.lambda;

import java.util.function.*;

class LambdaEx07 {
    public static void main(String[] args) {
        Function<String, Integer>       f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String>       g = (i) -> Integer.toBinaryString(i);

        Function<String, String>       h = f.andThen(g);
        Function<Integer, Integer>     h2 = f.compose(g);

        System.out.println(h.apply("FF"));      //  "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));        //  2 -> "10" -> 16

        Function<String, String> f2 = x -> x;       //  항등 함수(identity function)
        System.out.println(f2.apply("AAA"));      //  "AAA"가 그대로 출력됨

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();   //  i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));      //  true

        String str1 = "abc";
        String str2 = "abd";

        //  str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        // boolean result = str1.equal(str2)와 같음
        boolean result = p2.test(str2);
        System.out.println(result);

        //  "abc" == abc"   // true
        //  new String("abc") == "abc"      // false ==는 주소 비굔대 여기서 new를쓰면 새로운 주소를 만드는거라서 false가 뜸
    }
}
