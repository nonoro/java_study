package ch14.lambda;

import java.util.function.*;
import java.util.*;

class LambdaEx05 {
    public static void main(String[] args) {
        Supplier<Integer>  s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer>  c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;     //  짝수인지 검사
        Function<Integer, Integer> f = i -> i / 10 * 10;        //  i의 일의 자리를 없앤다.
        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);       //  짝수를 출력
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }

    static <T> void printEvenNum (Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {    //  짝수인지 검사
                c.accept(i);
            }
        }
        System.out.println("]");
    }

        static <T> void makeRandomList(Supplier<T> s, List<T> list) {
            for (int i = 0; i < 10; i++) {
                list.add(s.get());
            }
        }
    }

