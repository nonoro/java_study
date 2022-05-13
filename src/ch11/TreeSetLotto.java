package ch11;

import java.util.*;

class TreeSetLotto {
    public static void main(String[] args) {
        Set set = new TreeSet();        //  TreeSet은 정렬 필요 없음
//        Set set = new HashSet();        //  HashSet은 따로 정렬해야됨
        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);       //  set.add(new Integer(num));  오토박싱으로 그냥 num만 해도됨
                                //  이 Integer클래스가 가지고 있는 정렬기준을 이용해서 에러가 안뜸
        }

        System.out.println(set);
    }
}
