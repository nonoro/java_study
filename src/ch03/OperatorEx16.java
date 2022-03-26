package ch03;

public class OperatorEx16 {
    public static void main (String[] args) {
        float pi = 3.141592f;
        float shortPi = (int)(pi * 1000) / 1000f; // pi * 1000은 = > 3.141592f * 1000이다 이 값은 = 3141.592f 인데 int로 변환하면 소수점은 버려지기 때문에 3141이 되고 결국 3141/1000f 가 된다
        System.out.println(shortPi);
    }
}
