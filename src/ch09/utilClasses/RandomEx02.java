package ch09.utilClasses;

import java.util.*;

public class RandomEx02 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] number = new int[100];
        int[] counter = new int[10];

        for (int i = 0; i < number.length; i++) {
//            System.out.print(number[i] = (int) (Math.random() * 10));
//            0 <= x < 10 범위의 정수 x를 반환한다
            System.out.print(number[i] = rand.nextInt(10));
        }
        System.out.println();

        for (int i = 0; i < number.length; i++) {           //  counter원리 만약 counter[number[0]] 에서 number[0] = 9 이면 counter[9]가 되고 여기서 ++ 이 붙어있으니까 counter[9]번자리에 +1 을 한다는 말이다
            counter[number[i]]++;                           //  그래서 counter는 지금 0~9 까지 10개의 칸이있고 number는 0~9가 랜덤으로 들어간 100개의 배열이 있으므로 100개의 배열안에 숫자들을 해당 숫자가 나올때마다 counter의 10개의 칸중
        }                                                   //  해당되는 칸에다가 +1을 해서 각 숫자의 갯수를 셀 수 있다.

        for (int i = 0; i < counter.length; i++) {
            System.out.println( i +"의 개수 : " + printGraph('#', counter[i]) + " " + counter[i]);
        }
    }

    public static String printGraph(char ch, int value) {
        char[] bar = new char[value];

        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
        return new String(bar);
    }
}
