package ch07.overriding02;

class MyPoint {           // 컴파일시 여기에 extends Object 가 자동으로 추가됨
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // Object클래스의 toString()을 오버라이딩
    public String toString() {           //  public은 원래 Object 클래스에 public이 붙어있어서 써준거임 선언부는 같아야하기 때문에 public을 써줌
        return "x:" + x + ", y:" + y;
    }
}


public class OverrideTest02 {
    public static void main(String[] args) {
        MyPoint p = new MyPoint(3,5);
        System.out.println(p);
//        p.x = 3;
//        p.y = 5;
//        System.out.println("p.x=" + p.x);
//        System.out.println("p.y=" + p.y);
//        System.out.println(p.toString());

    }
}
