package ch07.overriding02;

class SuperTest02 {
    public static void main(String[] args) {
        Child02 c = new Child02();
            c.method();
    }
}

class Parent02 {            //  변수가 부모클래스에만 있고 자손클래스에는 없을 경우 super.x와 this.x 둘다 10 이다
    int x = 10;
}

class Child02 extends Parent02 {
    void method() {
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x);
        System.out.println("super.x=" + super.x);
    }
}
