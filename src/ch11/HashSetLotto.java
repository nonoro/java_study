package ch11;

import java.util.*;

class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet();

        //  set의 크기가 6보다 작은 동안 1~45사이의 난수를 저장
        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(new Integer(num));  //  set.add(num) 이렇게만 써도 오토박싱됨
        }

        // set의 출력결과를 오름차순으로 정렬 근데 set은 정렬불가 그래서 set을 list로 옮기고 list를 정렬
        //  1. set의 모든요소를 List에 저장
        //  2. list를 정렬
        //  3. list를 출력
    List list = new LinkedList(set);        //  LinkedList(Collection c)
    Collections.sort(list);                 //  Collections.sort(List list)
        System.out.println(list);
}
}
