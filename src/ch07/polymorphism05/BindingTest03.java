package ch07.polymorphism05;

class Parent2 {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child2 extends Parent2 {
    int x = 200;

    void method() {
        System.out.println("x=" + x);   //  this.x와 같다
        System.out.println("super.x=" + super.x);
        System.out.println("this.x=" + this.x);
    }
}

class BindingTest03 {
    public static void main(String[] args) {
        Parent2 p = new Child2();
        Child2 c = new Child2();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}

