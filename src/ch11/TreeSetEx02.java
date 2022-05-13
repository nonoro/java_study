package ch11;

import java.util.*;

class TreeSetEx02 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();            //  여기서 참조변수 타입을 Set으로 바꾸면 안됨 왜냐면 headSet, tailSet, subSet은 TreeSet에만 존재하는 메서드이기 때문에
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set.add(score[i]);
        }

        //  set.headSet(기준값) = 기준값보다 작은 값 찾아서 정렬
        //  set.tailSet(기준값) = 기준값보다 큰 값 찾아서 정렬
        System.out.println("50보다 작은 값 :" + set.headSet(new Integer(50)));
        System.out.println("50보다 큰 값 :" + set.tailSet(50));     //  new Integer(50)을 해도 되지만 오토박싱이 있어서 그냥 50해도됨
        System.out.println("40과 80사이에 값 :" + set.subSet(40, 80));

    }
}
