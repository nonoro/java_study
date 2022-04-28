package ch09.javaLangPackage;

class Point implements Cloneable {          //  Cloneable인터페이스를 구현한 클래스의 인스턴스만 clone()을 통한 복제가 가능하다 그 이유는 인스턴스의 데이터를 보호하기 위해서이다.
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
@Override
    public String toString() {
     return "x=" + x + ", y =" + y;
    }
@Override
    public Object clone() {         //  원래 오버라이딩 전에는 public이 아니라 protected임
        Object obj = null;
        try {
            obj = super.clone();    //  clone()은 반드시 예외처리를 해주어야 한다.
        } catch(CloneNotSupportedException e) {
        }
        return obj;
    }
}

class CloneEx01 {
    public static void main(String[] args) {
        Point original = new Point(3,5);
        Point copy = (Point)original.clone();   //  복제(clone)해서 새로운 객체를 생성
        System.out.println(original);
        System.out.println(copy);
    }
}
