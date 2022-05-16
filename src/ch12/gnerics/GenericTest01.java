package ch12.gnerics;

import java.util.ArrayList;

class Tv{}
class Audio{}

class GenericTest01 {
    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
        ArrayList<Tv> list = new ArrayList<Tv>();  //  Tv타입의 객체만 저장가능
        list.add(new Tv());
//        list.add(new Audio());

//        Tv t = list.get(0);     //  list의 첫번째 요소를 꺼낸다 지네릭 클래스를 이용하지 않으면 list앞에 (Tv)로 형변환을 하지 않아서 에러가뜸
        Tv t = list.get(0);       //  근데 지네릭 클래스를 이용하면 형변환 하지 않아도됨


    }
}
