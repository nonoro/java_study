package ch11;

import java.util.*;

class HashMapEx02 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김자바", new Integer(100));
        map.put("이자바", new Integer(100));
        map.put("강자바", new Integer(80));
        map.put("안자바", new Integer(90));

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();             //  Entry는 Map의 인터페이스 안에 들어있는 인터페이스
            System.out.println("이름 : " + e.getKey() + "점수 : " + e.getValue());
        }

        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;

        while (it.hasNext()) {
            Integer i = (Integer)it.next();     //   int i = (int)it.next();로 바꿀 수 있음 오토박싱때문에
            total += i.intValue();              //   얘도 total += i로 바꿀 수 있음
        }

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float)total/set.size());
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));

    }
}
