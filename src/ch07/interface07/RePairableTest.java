package ch07.interface07;

class RePairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Dropship dropship = new Dropship();

        Marine marine = new Marine();
        Scv scv = new Scv();

        scv.repair(tank);
        scv.repair(dropship);
//        scv.repair(marine);
    }
}

interface Repairable {
}

class Unit03 {
    int hitPoint;
    final int MAX_HP;
    Unit03(int hp) {
        MAX_HP = hp;
    }
}

class GroundUnit extends Unit03 {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit03 {
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150);             //  Tank의 HP는 150이다.
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Tank";
    }
}

class Dropship extends AirUnit implements Repairable {
    Dropship() {
        super(125);             //  Dropship의 HP는 125이다.
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Dropship";
    }
}

class Marine extends GroundUnit {
    Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
}

class Scv extends GroundUnit implements Repairable {
    Scv() {
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable repairable) {
        if (repairable instanceof Unit03) {
            Unit03 repairUnit = (Unit03) repairable;
            while(repairUnit.hitPoint != repairUnit.MAX_HP) {
                /* Unit의 HP를 증가시킨다. */
                repairUnit.hitPoint++;
            }
            System.out.println( repairUnit.toString() + "의 수리가 끝났습니다.");
        }
    }
}