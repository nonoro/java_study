package ch14.lambda;

import java.util.function.*;
import java.util.*;

class LambdaEx06 {
    public static void main(String[] args) {
        IntSupplier s = () -> (int) (Math.random() * 100) + 1;      //  1부터 100까지 랜덤값 출력
        IntConsumer c = i -> System.out.print(i + ", ");
        IntPredicate p = i -> i % 2 == 0;       //  짝수만 출력
        IntUnaryOperator op = i -> i / 10 * 10; //  i의 일의 자리를 없앤다

        int[] arr = new int[10];

        makeRandomList(s, arr);
        System.out.println(Arrays.toString(arr));
        printEvenNum(p, c, arr);
        int[] newArr = doSomething(op, arr);
        System.out.println(Arrays.toString(newArr));
    }

//    IntSupplier s = () -> (int) (Math.random() * 100) + 1;    0 ~ 100의 숫자를 랜덤으로 10개 뽑아서 arr에 넣는다
//    int[] arr = new int[10];
    static void makeRandomList(IntSupplier s, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.getAsInt();      //  get()이 아니라 getAsInt()임에 주의
        }
    }

//    IntPredicate p = i -> i % 2 == 0;                        int[] arr의 리스트에서 2의 배수만 넣는다
//    IntConsumer c = i -> System.out.print(i + ", ");
    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            if (p.test(i)) {
                c.accept(i);
            }
            System.out.println("]");
        }
    }

//    IntUnaryOperator op = i -> i / 10 * 10; //  int[] arr의 리스트에서 일의 자리를 없앤다
    static int[] doSomething(IntUnaryOperator op, int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = op.applyAsInt(arr[i]);  //  apply()가 아님에 주의
        }
        return newArr;
    }
}

