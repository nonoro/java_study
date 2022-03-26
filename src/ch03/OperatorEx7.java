package ch03;

public class OperatorEx7 {
    public static void main (String[] args) {
        byte a = 10;
        byte b = 30;
        byte c = (byte)(a*b);
        System.out.println(c); // 10*30 = 300 이지만 큰int에서 작은byte로 변환하였기 때문에 손실이 발생하였다

    }
}
