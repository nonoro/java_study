package ch07.polymorphism05;

class CastingTest01 {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine("blue");
        FireEngine fe2 = null;
        FireEngine fe3 = new FireEngine();

        fe.water();
        car = (Car)fe;             //  조상타입 <- 자손타입
//        car.water();
        fe2 = (FireEngine)car;     //  자손타입 <- 조상타입
        fe2.water();
        fe2.printColor();
        fe3.printColor();
    }
}

class Car {
    String color;
    int door;

    Car(String color) {
        this.color = color;
    }

    Car() {
        this.color = "black";
    }

    void printColor() {
        System.out.println("color :" + color);
    }

    void drive()  {                 //  운전하는 기능
        System.out.println("drive, Brrrr~");
    }

    void stop()  {                  //  멈추는 기능
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car  {     //  소방차
    void water()  {                 //  물을 뿌리는 기능
        System.out.println("water!!!");
    }

    FireEngine() {

    }

    FireEngine(String color) {
        this.color = color;
    }
}

