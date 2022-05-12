package ch11;

import java.util.*;

class HashSetEx02 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");     //  중복이라 저장안됨
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));       //  얜 중복인데 저장됨 이유는 클래스에 equals()와 hashcode()가 없음 그래서 출력됨 그래서 아래 equals와 hashcode를 Override해줌

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person p = (Person)obj;
        //  나자신(this)의 이름과 나이를 p와 비교
        return this.name.equals(p.name) && this.age == p.age;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    Person() {
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + ":" + age;
    }
}