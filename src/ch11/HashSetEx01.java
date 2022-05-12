package ch11;

import java.util.*;

class HashSetEx01 {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4",};        //  여기서 1이 두갠대 하나는 문자열이고 하나는 숫자이다 그래서 같은z
        Set set = new HashSet();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);     //   HashSet에 objArr의 요소들을 저장한다.
        }
        //  HashSet에 저장된 요소들을 출력한다.
        System.out.println(set);

        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
