package ch14.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

class LambdaEx09 {
    public static void main(String[] args) {
//        Supplier는 입력X, 출력O
//        Supplier<MyClass> s = () -> new MyClass();
//        Supplier<MyClass> s = MyClass::new;

//        Function<Integer, MyClass> f = (i) -> new MyClass(i);
        Function<Integer, MyClass> f = MyClass::new;

//        Supplier<MyClass> s = MyClass::new;


        MyClass mc = f.apply(100);           //  s.get()이 하는일은 MyClass객체 반환
        System.out.println(mc.iv);
        System.out.println(f.apply(100).iv);

//        Function<Integer, int[]> f2 = (i) -> new int[i];      - 람다식
        Function<Integer, int[]> f2 = int[]::new;          // - 메서드 참조

        int[] arr = f2.apply(100);

        System.out.println("arr.length=" + arr.length);
    }
}

class MyClass {
    int iv;

    MyClass(int iv) {
        this.iv = iv;
    }
}
