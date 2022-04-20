package ch07.interface07;

abstract class Unit02 {
    int x;
    int y;
    abstract void move02(int x, int y);
    void stop02() {
        System.out.println("멈춥니다.");
    }
}

interface Fightable02 {   //  인터페이스의 모든 메서드는 public abstract. 예외없이!
    void move02(int x, int y);   // public abstract가 생략됨
    void attack02(Fightable02 fighter02);  // public abstract가 생략됨
}

class Fighter02 extends Unit02 implements Fightable02 {
    public void move02(int x, int y) {       //  오버라이딩 규칙 : 조상(public)보다 접근제어자의 범위가 좁으면 안된다.
        System.out.println("[" + x + "," + y + "]로 이동");
    }
    public void attack02(Fightable02 fighter02) {
        System.out.println(fighter02 + "를 공격");
    }
}

public class FighterTest02 {
    public static void main(String[] args) {

//        Fighter02 fighter02 = new Fighter02();
        Fightable02 fighter02 = new Fighter02();
        fighter02.move02(100, 200);
//        fighter02.attack02(new Fighter02());
        Fightable02 fighter03 = new Fighter02();
        fighter03.attack02(fighter03);
    }
}
