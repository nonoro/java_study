package ch09.javaLangPackage;

final class Card03 {
    String kind;
    int num;

    Card03() {
        this("SPADE", 1);
    }

    Card03(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }

    @Override
    public String toString() {
        return kind + ":" + num;
    }
}

class ClassEx01 {
    public static void main(String[] args) throws Exception {
        Card03 card01 = new Card03("HEART", 3);   //  new연산자로 객체 생성
        Card03 card02 = Card03.class.newInstance();           //  Class객체를 통해서 객체 생성

        Class card01Obj = card01.getClass();

        System.out.println(card01);
        System.out.println(card02);
        System.out.println(card01Obj.getName());
        System.out.println(card01Obj.toGenericString());
        System.out.println(card01Obj.toString());


    }
}