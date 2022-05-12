package ch11;

import java.util.*;

class IteratorEx01 {
    public static void main(String[] args) {
        Collection list = new ArrayList();          //  여기서 참조변수의 타입을 ArrayList로 썻는데 이렇게 될 경우 오른족에 클래스가 ArrayList()에서 HashSet이나 TreeSet등으로 바뀌면 Tree에는 없는 메서드를 Hash에서 썻을 수도 있기 때문에 아래의 코드를 다시 확인해야한다
        list.add("1");                              //  근데 참조변수의 타입을 Collection으로 하면 Collection은 ArrayList(), TreeSet등을 다 포함한 부모 인터페이스이기 때문에 아래 코드를 확인하지 않아도 된다.
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();      //  iterator는 1회용이라 다 쓰고나면 다시 얻어와야 한다.

        while(it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }

        it = list.iterator();               //  이렇게 다시 얻어오면 12345가 다시 출력된다

        while(it.hasNext()) {               //  이건 it.hasNext()가 계속 false가 됨 이미 위에서 다 읽어버려서 따라서 다시 얻어와야하므로
            Object obj = it.next();
            System.out.println(obj);
        }
        //  이렇게해도 됨 근데 이렇게 할 경우 위에 ArrayList()를 HashSet으로 바꾸면 HashSet는 get()메서드가 없기 때문에 이 코드는 작동이 안됨 따라서 HashSet, ArrayList에 둘다 있는 Iterator를 쓰면 코드는 바껴도 재사용이 가능함
//        for (int i = 0; i < list.size(); i++) {
//            Object obj = list.get(i);
//            System.out.println(obj);
//        }
    }   //  main
}
