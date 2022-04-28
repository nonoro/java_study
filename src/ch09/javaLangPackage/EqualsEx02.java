package ch09.javaLangPackage;

class Person {
    long id;
@Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {                //  아래 else 없애고 if (!(obj instanceof Person))
            return id == ((Person)obj).id;          //                     return false; 이렇게 해도됨
        }                                           // return id == ((Person)obj).id; 얘도
        else {                                      // Person p = (Person)obj 이렇게 선언하고
            return false;                           // return this.id == p.id 이렇게 해도됨
        }                                           // 그리고 return this.id 에서 this는 어짜피 여기 Person 클래스안에 있는것을 말하는것이므로 생략해도됨
    }

    Person(long id) {
        this.id = id;
    }
}

class EqualsEx02 {
    public static void main(String[] args) {
        Person p1 = new Person(8011081111222L);
        Person p2 = new Person(8011081111222L);

        if (p1 == p2) {
            System.out.println("p1과 p2는 같은 사람입니다.");
        }
        else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }

        if (p1.equals((p2))) {
            System.out.println("p1과 p2는 같은 사람입니다.");
        }
        else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }
    }
}
