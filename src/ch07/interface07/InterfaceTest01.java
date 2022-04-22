package ch07.interface07;

class A {
//    public void methodA(B b) {
    public void methodA(I i) {
        i.methodB();
    }
}

interface I {
    public void methodB();
}

class B implements I {
    public void methodB() {
        System.out.println("method()");
    }
}

//class B {
//    public void methodB() {
//        System.out.println("method()");
//    }
//}

class InterfaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(new B());
    }
}