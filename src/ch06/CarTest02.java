package ch06;

class Car02 {
    String color;       //  색상
    String gearType;    //  변속기 종류 - auto(자동), manual(수동)
    int door;           //  문의 개수

    Car02() {
        this("white", "auto", 4);
    }

    Car02(String color) {
        this(color, "auto", 4);
    }

    Car02(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}

class CarTest02 {
    public static void main(String[] args) {
        Car02 c1 = new Car02();
        Car02 c2 = new Car02("blue");

        System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);

    }
}