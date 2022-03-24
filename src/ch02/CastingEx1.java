package ch02;

public class CastingEx1 {
    public static void main(String[] args) {
        double d = 85.4;
        int score = (int)d;

        System.out.println("score="+score);
        System.out.println("d="+d); // 형변환 후에도 피연산자인 85.4 에는 아무런 변화도 없다
    }
}
