package ch07.overriding02;

class PointTest {
    public static void main(String[] args) {
        Point3D02 p3 = new Point3D02(1, 2, 3);
    }
}

class Point02 {
    int x, y;

    Point02(){}

    Point02(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x :" + x + ", y=" + y;
    }
}

class Point3D02 extends Point02 {
     int z ;

     Point3D02(int x, int y, int z) {

//         this.x = x;   // x, y는 이미 조상클래스에서 초기화가 되어있기 때문에 자손클래스에서 하면안됨 오류뜸
//         this.y = y;
//         super(x, y);    // super(x, y)로 조상클래스의 생성자를 호출해서 Point04(int x, int y) 를 사용하여 조상의 생성자가 자손클래스에 있는 조상멤버를 초기화하도록 한다.
         super();     // Point04클래스에 Point() {} 이 기본생성자를 선언하면 super();을 쓰면되고 만약 기본생성자를 호출하지 않았을 경우 위에처럼 super(x, y)를 선ㅇ넌하면 된다.
         this.z = z;
     }

     String getLocation() {
         return "x :" + x + ", y=" + y + ", z=" + z;
     }
}