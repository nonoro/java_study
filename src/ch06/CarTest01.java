package ch06;

class Car {
    String color;    //  색상
    String gearType;   //  변속기종류 - auto(자동), manual(수동)
    int door;        //  ansdml rotn

    Car()  {}

    Car(String c, String g, int d)  {
        color = c;
        gearType = g;
        door = d;
    }
}

class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "white";
        c1.gearType = "aute";
        c1.door = 4;

         Car c2 = new Car("white", "aute", 4);

        System.out.println("c1의 color=" + c1.color + ", gearTyp=" + c1.gearType + ", door=" + c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearTyp=" + c2.gearType + ", door=" + c1.door);
    }
}
