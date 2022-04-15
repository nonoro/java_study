package ch07.overriding02;

class Point03 {
    int x;
    int y;
    String getLocation() {
        return "x:" + x + ", y:" + y;
    }
}

class Point3D03 extends Point03 {

    String getLocation() {
        return super.getLocation();             //  위아래가 같음 메서드도 super. 으로 가능
//        return "x:" + x + ", y:" + y ;
    }
}

public class SuperTest03 {
    public static void main(String[] args) {
        Point3D03 p = new Point3D03();
        p.x = 3;
        p.y = 5;
        System.out.println(p.getLocation());
    }
}
