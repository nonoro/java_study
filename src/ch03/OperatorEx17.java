package ch03;

public class OperatorEx17 {
    public static void main(String[] args) {
        double pi = 3.141592;
        double shortpi = (int) (pi * 1000 + 0.5) / 1000.0; // 1000.0 이 아니라 1000이면  int 끼리의 계산이기 때문에 소수점은 버림이 되어서 3이된다 / 1000.0 = 1000d

        System.out.println(shortpi);

    }
}
