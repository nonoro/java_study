package ch06;

class Car03 {
    String color;
    String gearType;
    int door;

    Car03() {
        this("white", "auto", 4);
    }

    Car03(Car03 c) {      //  인스턴스 복사를 위한 생성자
        color = c.color;
        gearType = c.gearType;
        door = c.door;
    }

    Car03(String color, String gearType, int door)  {
        this.color = color ;
        this.gearType = gearType;
        this. door = door;
    }
}

class CarTest03   {
    public static void main(String[] args) {
        Car03 c1 = new Car03();
        Car03 c2 = new Car03(c1);    //  c1의 복사본 c2를 생성한다.
        System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);

        c1.door = 100;   //  c1의 인스턴스변수 door의 값을 변경한다.
        System.out.println("c1.door = 100; 수행 후");
        System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);
    }
}
