package ch07.interface07;

class Unit {
    int currentHP;  //  유닛의 체력
    int x;          //  유닛의 위치(x좌표)
    int y;          //  유닛의 위치(y좌표)
}

interface Movable {
    void move(int x, int y);        //  public abstract void move(int x, int y)
}

interface Attackable {
    void attack(Unit unit);        //  public abstract void attack(Unit unit)
}

interface Fightable extends Movable, Attackable {

}

class Fighter extends Unit implements Fightable {
    public void move(int x, int y) { /* 내용 생략 */
    }
    public void attack(Unit unit) {/* 내용 생략 */

    }
}

class FighterTest {
    public static void main(String[] args) {
        Fighter fighter = new Fighter();

        if (fighter instanceof Unit) {
            System.out.println("fighter는 Unit클래스의 자손입니다.");
        }

        if (fighter instanceof Fightable) {
            System.out.println("fighter는 Fightable 인터페이스를 구현했습니다.");
        }

        if (fighter instanceof Movable) {
            System.out.println("fighter는 Movable 인터페이스를 구현했습니다.");
        }

        if (fighter instanceof Attackable) {
            System.out.println("fighter는 Attackable 인터페이스를 구현했습니다.");
        }

        if (fighter instanceof Object) {
            System.out.println("fighter는 Object클래스의 자손입니다.");
        }
    }
}
