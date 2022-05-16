package ch12.gnerics;

import java.util.ArrayList;
import java.util.Stack;

class Fruit03 {
    public String toString() {
        return "Fruit03";
    }
}

class Apple03 extends Fruit03 {
    public String toString() {
        return "Apple03";
    }
}

class Grape03 extends Fruit03 {
    public String toString() {
        return "Grape03";
    }
}

class Juice {
    String name;

    Juice(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox03<? extends Fruit03> box03) {
        String tmp = "";
        //  향상된 for문
        for (Fruit03 f : box03.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp + "juice");
    }
}

class FruitBoxEx03 {
    public static void main(String[] args) {
        FruitBox03<Fruit03> fruitBox03 = new FruitBox03<Fruit03>();
        FruitBox03<Apple03> appleBox03 = new FruitBox03<Apple03>();
//        FruitBox03<Fruit03> appleBox03 = new FruitBox03<Apple03>();                 //  이렇게하면 오류남 참조변수 지네릭스타입과 생성자 지네릭스 타입이 같아야됨
//        FruitBox03<? extends Fruit03> appleBox03 = new FruitBox03<Apple03>();       //  만약 오류 안뜨게 하려면 이렇게하면됨


        fruitBox03.add(new Apple03());
        fruitBox03.add(new Grape03());
        appleBox03.add(new Apple03());
        appleBox03.add(new Apple03());

        System.out.println(Juicer.makeJuice(fruitBox03));
        System.out.println(Juicer.makeJuice(appleBox03));
    }       //  main
}

class FruitBox03<T extends Fruit03> extends Box03<T> {}

class Box03<T> {
    ArrayList<T> list = new ArrayList<T>();     //  item을 저장할 list

    void add(T item) {                          //  박스에 item을 추가
        list.add(item);
    }

    T get(int i) {                              //  박스에서 item을 꺼낼때
        return list.get(i);
    }

    ArrayList<T> getList() {
        return list;
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}


