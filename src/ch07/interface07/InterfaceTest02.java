package ch07.interface07;

class A1 {
    void autoPlay(I1 i) {
        i.play();
    }
}

interface I1 {
    void play();
}

class B1 implements I1 {
    @Override
    public void play() {
        System.out.println("play in B class");
    }
}

class C1 implements I1 {
    @Override
    public void play() {
        System.out.println("play in C class");
    }
}

class InterfaceTest02 {
    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.autoPlay(new B1());          //  void autoPlay(I i)호출
        a1.autoPlay(new C1());          //  void autoPlay(I i)호출
//        B1 b1 = new B1();
//        C1 c1 = new C1();
//        a1.autoPlay(b1);
//        a1.autoPlay(c1);
    }
}





