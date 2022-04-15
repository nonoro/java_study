package ch07.overriding02;

class SuperTest01 {
    public static void main(String[] args) {
        Child c = new Child();                       //  현재 Child객체를 c 참조변수로 생성했고 그 객체 안에는 Parent클래스의 x = 10과 Child 클래스의 x = 20이 들어있고 Child 클래스의 void method()가 들어있다
        c.method();                                  //  여기서 Child와 Parent 클래스의 x 변수가 이름이 같아서 상속받은 Parent클래스의 x 는 super.x로 Child클래스의 x 는 this.x로 표현하여 구분한다.
    }
}

class Parent {
    int x = 10;     //  얘는 super.x
}

class Child extends Parent {
    int x = 20;     //  얘는 this.x

    void method() {
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x);
        System.out.println("super.x=" + super.x);
    }
}

