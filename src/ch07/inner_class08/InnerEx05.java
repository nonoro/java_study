package ch07.inner_class08;

class Outer02 {
    int value = 10; //  Outer02.this.value

    class Inner {
        int value = 20; //  this.value

        void method1()  {
            int value = 30;
            System.out.println("             value :" + value);
            System.out.println("        this.value :" + this.value);
            System.out.println("Outer02.this.value :" + Outer02.this.value);
        }
    }       //  Inner클래스의 끝
}       //  Outer클래스의 끝

class InnerEx05 {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        Outer02.Inner inner = outer02.new Inner();
        inner.method1();
    }
}   //  InnerEx5 끝