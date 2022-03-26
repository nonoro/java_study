package ch03;

public class OperatorEx6 {
    public static void main (String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte)(a + b); // 여기에 (byte)를 추가하지 않으면 오류가남
        System.out.println(c);

    }
}
