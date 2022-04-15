package ch07.overriding02;

class Point04 {
    int x = 10;
    int y = 20;

    Point04() {                        //  생성자의 첫 줄에는 반드시 생성자를 호출해야 한다. 얘는 기본생성자라서 기본으로 생성이됨 선언 안해도
        this(0,0);
    }

    Point04(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D04 extends Point04 {
    int z = 30;

    Point3D04() {
        this(100, 200, 300);    //  Point3D04(int x, int y, int z)를 호출한다.
    }

    Point3D04(int x, int y, int z) {
        super(x, y);                    //  Point04(int x, int y)를 호출한다. , 얘도 생성자의 첫줄에는 반드시 생성자를 호출해야 한다.
        this.z = z;
    }


}

class PointTest02 {
    public static void main(String[] args) {
        Point3D04 p4 = new Point3D04();
        System.out.println("p4.x=" + p4.x);
        System.out.println("p4.y=" + p4.y);
        System.out.println("p4.z=" + p4.z);

    }
}