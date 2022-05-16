package ch12.gnerics;

import java.util.ArrayList;

class Fruit02 {
    public String toString() {
        return "Fruit02";
    }
}

class Apple02 extends Fruit02 {
    public String toString() {
        return "Apple02";
    }
}

class Grape02 extends Fruit02 {
    public String toString() {
        return "Grape02";
    }
}
class Toy02 {
    public String toString() {
        return "Toy02";
    }
}

interface Eatable {}

class FruitBoxEx02 {
    public static void main(String[] args) {
        Box02<Fruit02> fruitBox = new Box02<Fruit02>();
        Box02<Apple02> appleBox = new Box02<Apple02>();
        Box02<Toy02> toyBox = new Box02<Toy02>();
//        Box<Grape02> grapeBox = new Box<Apple02>();     //  에러. 타입 불일치

        fruitBox.add(new Fruit02());
        fruitBox.add(new Apple02());      // OK. void add(Fruit item)

        appleBox.add(new Apple02());
        appleBox.add(new Apple02());
//        appleBox.add(new Toy02());        //  에러. Box<Apple>에는 Apple만 담을 수 있음

        toyBox.add(new Toy02());
//        toyBox.add(new Apple02());        //  에러. Box<Toy>에는 Toy만 담을 수 있음

        System.out.println("fruitBox-" + fruitBox);
        System.out.println("appleBox-" + appleBox);
        System.out.println("toyBox-" + toyBox);
    }    //  main의 끝
}

class FruitBox<T extends Fruit02 & Eatable> extends Box02<T> {}

class Box02<T> {
    ArrayList<T> list = new ArrayList<T>();     //  item을 저장할 list

    void add(T item) {                          //  박스에 item을 추가
        list.add(item);
    }

    T get(int i) {                              //  박스에서 item을 꺼낼때
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}