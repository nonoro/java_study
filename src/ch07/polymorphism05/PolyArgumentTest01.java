package ch07.polymorphism05;

import kotlin.OverloadResolutionByLambdaReturnType;

class Product {
    private int price;         //  제품의 가격
    private int bonusPoint;    //  제품구매 시 제공하는 보너스 점수


    Product (int price) {
        this.price = price;
        bonusPoint = (int) (price/10.0);   //  보너스점수는 제품가격의 10%
    }

    public int getPrice() {
        return this.price;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }
}

class Tv extends Product {
    Tv() {                  //  조상클래스의 생성자 Product(int price)를 호출한다.
        super(100);         //  Tv의 가격을 100만원으로 한다.
    }

    Tv(int price) {
        super(price);
    }

    // Object클래스의 toString()을 오버라이딩한다,.
    @Override
    public String toString() {
        return "TV";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    Computer(int price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer {               //  고객, 물건을 사는 사람
    private int money = 1000;       //  소유금액
    private int bonusPoint = 0;     //  보너스점수

    Buyer(int money) {
        this.money = money;
    }

    public int getMoney() {     //  alt + insert 로 해서 만듬
        return money;
    }

//    public void setMoney(int money) {
//        this.money = money;
//    }

    public int getBonusPoint() {
        return bonusPoint;
    }

//    public void setBonusPoint(int bonusPoint) {
//        this.bonusPoint = bonusPoint;
//    }

    void buy(Product product)  {                            //    shift + f6하면 같은 문자들 다 바뀜
        if (money < product.getPrice()) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= product.getPrice();        //  가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += product.getBonusPoint();    //  제품의 보너스 점수를 추가한다.
        System.out.println(product + "을/를 구입하셨습니다.");    //  product = product.toString()
    }
}

public class PolyArgumentTest01 {
    public static void main(String[] args) {
        Buyer buyer = new Buyer(30000);     //  (100000000) 이렇게 수동으로 넣고싶으면 위에 Buyer 클래스에 생성자를 만들어줘야댐  Tv랑 Computer도 마찬가지

        buyer.buy(new Tv(5500));
        buyer.buy(new Computer(9000));

//  Tv tv = new Tv();
// Computer computer = new Computer();
// buyer.buy(tv);
// buyer.buy(computer);

//        buyer.setMoney(1000);
        System.out.println("현재 남은 돈은 " + buyer.getMoney() + "만원입니다.");

//        buyer.setBonusPoint(50000);
        System.out.println("현재 보너스 점수는 " + buyer.getBonusPoint() + "점입니다.");
    }
}
