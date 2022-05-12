package ch11;

import java.util.*;

class HashSetEx03 {
    public static void main(String[] args) {
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");
        System.out.println("A = " + setA);

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");
        System.out.println("B = " + setB);

        //  교집합
        Iterator it = setB.iterator();
        while (it.hasNext()) {
            Object tmp = it.next();
            if (setA.contains(tmp)) {       //  처음에 B에있는 4를 꺼내서 A에 있는지 확인 있으면 setKyo에 추가
                setKyo.add(tmp);
            }
        }

        // 차집합
        it = setA.iterator();
        while (it.hasNext()) {
            Object tmp = it.next();
            if (!setB.contains(tmp)) {      //  setB에 없는것만 차집합 setCha에 저장
                setCha.add(tmp);
            }
        }
        //  합집합
        //  setA와 setB를 setHap에 다 넣어보면 set의 특징인 순서가 없고 중복이 없는 특징으로 인하여 합집합완성
        it = setA.iterator();
        while (it.hasNext()) {
            setHab.add(it.next());
        }

        it = setB.iterator();
        while (it.hasNext()) {
            setHab.add(it.next());
        }

        //  사실 위에 있는것은 학습을 위한것이고 쉬운 메서드가있음
//        setA.retainAll(setB);       //  교집합. setA와 setB의 공통된 요소만 남기고 삭제
//        setA.addAll(setB);          //  합집합. setA에 setB의 모든 요소를 추가(중복제외)
//        setA.removeAll(setB);       //  차집합. setB와 공통 요소를 제거

        System.out.println("A ∩ B = " + setKyo);        //  한글 ㄷ을 누르고 한자키
        System.out.println("A ∪ B = " + setHab);        //  한글 ㄷ을 누르고 한자키
        System.out.println("A - B = " + setCha);
    }
}
