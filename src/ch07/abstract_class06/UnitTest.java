package ch07.abstract_class06;

abstract class Unit {
    int x;
    int y;

    abstract void move(int x,int y);

    void stop() {
        /* 현재 위치에 정지 */
    }
}

class Marine extends Unit {        //  보병
    void move(int x, int y) {  /* 지정된 위치로 이동 */
        System.out.println("Marine[x=" + x + ",y=" + y + "]");
    }
    void stimPack() {
        /* 스팀팩을 사용한다. */
    }
}

class Tank extends Unit {           // 탱크
    void move(int x, int y) {  /* 지정된 위치로 이동 */
        System.out.println("Tank[x=" + x + ",y=" + y + "]");
    }
    void changeMode() {
        /* 공격모드를 변환한다 */
    }
}

class Dropship extends Unit {      //  수송선
    void move(int x, int y) {  /* 지정된 위치로 이동 */
        System.out.println("Dropship[x=" + x + ",y=" + y + "]");
    }
    void load() {
        /* 선택된 대상을 태운다 */
    }
    void unload () {
        /* 선택된 대상을 내린다 */
    }
}

public class UnitTest {
    public static void main(String[] args) {
        Unit[] group = new Unit[3];     //  Unit[] group = { new Marine(), new Tank(), new Dropship() };
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new Dropship();

        for (int i = 0; i < group.length; i++) {
            group[i].move(100, 200);
        }
    }
}
