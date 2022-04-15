package ch07.overriding02;

class Point {
    int x;
    int y;
    String getLocation() {
        return "x:" + x + ", y:" + y;
    }
}

class Point3D extends Point {
    int z;

    String getLocation() {
        // 조상의 getLocation()을 오버라이딩 이걸 안하면 z값이 안뜸 조상의 getLocation()를 상속을 받긴 받지만 에는 z값이 없기 때문에 오버라이딩 안하면 z값이 안뜸
        return "x:" + x + ", y:" + y + ", z:" + z;
    }
}

    public class OverrideTest01 {
        public static void main(String[] args) {
            Point3D p = new Point3D();
            p.x = 3;
            p.y = 5;
            p.z = 7;
            System.out.println(p.getLocation());
        }
    }
