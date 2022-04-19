package ch07.polymorphism05;

class InstanceofTest {
    public static void main(String[] args) {
        FireEngine1 fe = new FireEngine1();

        if (fe instanceof FireEngine1) {
            System.out.println("This is a FireEngine1 instance.");
        }

        if (fe instanceof Car1) {
            System.out.println("This is a Car1 instance.");
        }

        if(fe instanceof Object) {
            System.out.println("This is an Object Instance.");
        }

        System.out.println(fe.getClass().getName());    //  클래스의 이름을 출력
    }
} //  class

class Car1 {}
class FireEngine1 extends  Car1 {}
