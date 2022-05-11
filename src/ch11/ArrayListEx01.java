package ch11;

import java.util.*;


class ArrayListEx01 {
    public static void main(String[] args) {
        //  기본 길이(용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);
        //  ArrayList에는 객체만 저장가능
        //  autoboxing에 의해 기본형이 참조형으로 자동 변환
        list1.add(new Integer(5));      //  list1.add(5) 이렇게하면 기본형이라 원래 안되는데 오토박싱 때문에 가능
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1, 4));       //  list2에 4, 2, 0 이 담긴 새로운 객체를 만든다 subList는 읽기전용
        print(list1, list2);

        //  Collection은 인터페이스, Collections는 유틸 클래스
        Collections.sort(list1);     //  list1과 list2를 정렬한다.
        Collections.sort(list2);     //  Collection.sort(List 1)
        print(list1, list2);

        System.out.println("list1.containsAll(list2) :" + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");

        list2.set(3,"AA");

        print(list1, list2);

        //  list1.remove(1);        //  인덱스가 1인 객체를 삭제
        //  list1.remove(new Integer(1));       //  1을 삭제


        System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));     //  list1에서 list2와 공통요소만 가지고 나머지 버린뒤 list1출력하고 list2는 그대로 출력
        print(list1, list2);

        //  list1에서 list2에 포함된 객체들을 삭제한다.
        for (int i = list2.size() - 1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) ;{
                list2.remove(i);
            }
        }
        print(list1, list2);
    }   //  main의 끝

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println();
    }
}   //  class
