package ch07.interface07;

class InterfaceTest03 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.methodA2();
    }
}

class A2 {
    void methodA2() {
        I2 i = InstanceManager.getInstance();
        i.methodB2();
        System.out.println(i.toString());           //  i로 Object클래스의 메서드 호출가능
    }
}

interface I2 {
    public abstract void methodB2();   //  이곳에 toString()이 존재하진 않는다 하지만 모든 객체는 Object클래스에 정의된 메서드를 가지고 있을 것이기 때문에 허용된다. 보이지않는 toString버튼이 있다고 보면됨
}

class B2 implements I2 {
    @Override
    public void methodB2() {
        System.out.println("methodB2 in B2 class");
    }
    @Override
    public String toString() {
        return "class B2";
    }
}

class InstanceManager {
    public static I2 getInstance() {
        return new B2();
    }
}