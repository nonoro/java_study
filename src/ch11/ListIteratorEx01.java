package ch11;

import java.util.*;

class ListIteratorEx01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        ListIterator it = list.listIterator();      //  ListIterator는 List를 구현한 컬렉션에서만 사용가능 그래서 위에 객체만들때 참조변수의 타입을 Collection으로 못하고 List가 들어간 ArrayList로 해야된다.

        while(it.hasNext()) {
            System.out.println(it.next());  //  순방향으로 진행하면서 읽어온다.
        }
        System.out.println();

        while(it.hasPrevious()) {
            System.out.println(it.previous());      //  역방향으로 진행하면서 읽어온다.
        }
        System.out.println();
    }
}
