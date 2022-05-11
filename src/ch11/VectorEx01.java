package ch11;

import java.util.*;

class VectorEx01 {
    public static void main(String[] args) {
        Vector v = new Vector(5);       //  용량(capacity)이 5인 Vector를 생성한다.
        v.add("1");
        v.add("2");
        v.add("3");
        print(v);

        v.trimToSize();         //  빈 공간을 없앤다.(용량과 크기가 같아진다.)
        System.out.println("=== After trimToSize() ===");
        print(v);

        v.ensureCapacity(6);
        System.out.println("=== After ensureCapacity(6) ===");
        print(v);

        v.setSize(7);
        System.out.println("=== After setSize(7) ===");     //  여기서 capacity가 6자리이기 때문에 size가 7이 되기위해선 용량이 늘어나야된다
        print(v);                                           //  이때 보통 capacity는 자신의 크기의 2배로 커진다 그래서 capacity는 12이다. 그리고 size는 7이다

        v.clear();
        System.out.println("=== After clear() ===");
        print(v);
    }

    public static void print(Vector v) {
        System.out.println(v);
        System.out.println("size :" + v.size());
        System.out.println("capacity :" + v.capacity());
    }
}
