package ch07.inner_class08;

class InnerEx06 {
    Object iv = new Object() {
        void method() {
        }
    };               //  익명 클래스

    static Object cv = new Object() { void method() {
    }              //  익명 클래스
};

    void myMethod() {
        Object lv = new Object(){
        void method(){
        }
    };              //  익명 클래스
    }
}

