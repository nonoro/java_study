package ch02;
// 두 변수의 값 교환하기
public class VarEx2 {
    public static void main(String[] args) {
        int x = 10, y = 20;
        int tmp = 0; //변수의 초기화

        System.out.println("x:" + x + " y:" + y); // +는 두 값을 더하기도 하지만 문자열과 숫자를 하나로 결합하기도 한다 문자열은 큰따옴표로 묶은 연속된 문자이다

        tmp = x;
        x = y;
        y = tmp;

        System.out.println("x:" + x + " y:" + y);
    }
}
