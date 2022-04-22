package ch07.inner_class08;

public class InnerEx02 {
    class InstanceInner {
    }

    static class StaticInner {
    }

    //  인스턴스멤버 간에는 서로 직접 접근이 가능하다.
    InstanceInner iv = new InstanceInner();
    //  static멤버 간에는 서로 직접 접근이 가능하다.
    StaticInner cv = new StaticInner();

    static void staticMethod() {
        //  static멤버는 인스턴스멤버에 직접 접근할 수 없다
//        InstanceInner iv = new InstanceInner();
        StaticInner cv = new StaticInner();

        //  굳이 접근하려면 아래와 같이 객체를 생성해야 한다.
        //  인스턴스클래스는 외부 크랠스를 먼저 생성해야만 생성할 수 있다.
        InnerEx02 outer = new InnerEx02();
        InstanceInner obj1 = outer.new InstanceInner();    //   근데 이건 잘 안씀
    }

    void instanceMethod() {
        //  인스턴스메서드에서는 인스턴스멤버와 static멤버 모두 접근 가능하다.
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();
        //  메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
//        LocalInner lv = new LocalInner();
    }

    void myMethod() {
        class LocalInner {
        }
        LocalInner lv = new LocalInner();
    }
}