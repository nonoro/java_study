package ch07.polymorphism05;

class Product02 {
    int price;                //  제품의 가격
    int bonusPoint;           //  제품구매 시 제공하는 보너스점수

    Product02(int price) {
        this.price = price;
        bonusPoint = (int) (price/10.0);
    }
    Product02() {               //  기본생성자
    }
}

class Tv02 extends Product02 {
    Tv02() {
        super(100);
    }


        public String toString() {
            return "Tv02";
        }

    }

class Computer02 extends Product02 {
    Computer02() {
        super(200);
    }

    public String toString() {
        return "Computer02";
    }
}

class Audio02 extends Product02 {
        Audio02() {
            super(50);
        }

        public String toString() {
            return "Audio02";
        }
}

class Buyer02 {                 // 고객, 물건을 사는 사람
    int money = 1000;           //  소유금액
    int bonusPoint = 0;         //  보너스점수
    Product02[] item = new Product02[10];     //  구입한 제품을 저장하기 위한 배열
    int i = 0;                  //  Product02 배열에 사용될 카운터

    void buy(Product02 product02) {
        if (money < product02.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= product02.price;     //   가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += product02.bonusPoint;   //  제품의 보너스 점수를 추가한다.
        item[i++] = product02;                //  제품을 Product[] item에 저장한다.
        System.out.println(product02 + "을/를 구입하셨습니다.");
    }

    void summary() {                    //  구입한 물품에 대한 정보를 요약해서 보여 준다.
        int sum = 0;                    //  구입한 물품의 가격합계
        String itemList = "";           //  구입한 물품목록

        // 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
        for (int i = 0; i < item.length; i++) {

            if (item[i] == null) {
                break;
            }


            sum += item[i].price;
            itemList += item[i] + ", ";
        }
        System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}

class PolyArgumentTest02 {
    public static void main(String[] args) {
        Buyer buyer02 = new Buyer();

        buyer02.buy(new Tv02());
        buyer02.buy(new Computer02());
        buyer02.buy(new Audio02());
        buyer02.summary();

    }
}


