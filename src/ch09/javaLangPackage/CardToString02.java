package ch09.javaLangPackage;

import java.util.Objects;

class Card02 {
    String kind;
    int number;

    Card02() {
        this("SPADE", 1);       //  Card02(String kind, int number)를 호출
    }

    Card02(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override

    public int hashCode() {
        return Objects.hash(kind, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card02)) {
            return false;
        }

        Card02 c = (Card02)obj;
        return this.kind.equals(c.kind) && this.number == c.number;         //  kind는 String이라서 == 으로 하면 안되고 equals.()로 해야함
    }

    @Override
    public String toString() {
        return "kind : " + kind + ", number : " + number;    //  Card02 인스턴스와 kind의 number를 문자열로 반환한다.
    }
}

class CardToString02 {
    public static void main(String[] args) {
        Card02 c1 = new Card02();
        Card02 c2 = new Card02("HEART", 10);

        System.out.println(c1.equals(c2));
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
