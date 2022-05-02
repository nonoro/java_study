package ch09.utilClasses;

import java.util.*;

class StringTokenizerEx05 {
    public static void main(String[] args) {
        String data = "100,,,200,300";

        String[] result = data.split(",");
        StringTokenizer st = new StringTokenizer(data, ",");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "|");      //  split는 빈 문자열도 토큰으로 인식한다.
        }

        System.out.println("개수:" + result.length);

        int i = 0;
        for (;st.hasMoreTokens();i++) {                 //  hasMoreTokens() 남은 토큰이 있는지 확인해주는 boolean메서드
            System.out.print(st.nextToken() + "|");     //  StringTokenizer 는 빈 문자열은 토큰으로 인식하지 않는다
        }                                               //  nextToken() 첫번째부터 토큰을 차례로 반환해주는 메서드
        System.out.println("개수:" + i);
    }
}
