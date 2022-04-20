package ch07.polymorphism05;

import java.util.*;                 //  Vector클래스를 사용하기 위해 추가

class Product03 {
    int price;      //  제품의 가격
    int bonusPoint; //  제품구매 시 제공하는 보너스점수

    Product03(int price) {
        this.price = price;
        bonusPoint = (int) (price/10.0);
    }
    Product03() {
        price = 0;
        bonusPoint = 0;
    }
}

class Tv03 extends Product03 {
    Tv03() {
        super(100);
    }

    public String toString() {
        return "Tv03";
    }
}

    class Computer03 extends Product03 {
        Computer03() {
            super(200);
        }

        public String toString() {
            return "Computer03";
        }
    }

    class Audio03 extends Product03 {
        Audio03() {
            super(50);
        }

        public String toString() {
            return "Audio03";
        }
    }

    class Buyer03 {                                  //  고객, 물건을 사는 사람
        int money = 1000;                        //  소유금액
        int bonusPoint = 0;                      //  보너스점수
        Vector item03 = new Vector();              //  구입한 제품을 저장하는데 사용될 Vector객체

        void buy(Product03 product03) {
            if (money < product03.price) {
                System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
                return;
            }

            money -= product03.price;
            bonusPoint += product03.bonusPoint;
            item03.add(product03);
            System.out.println(product03 + "을/를 구입하셨습니다.");
        }

        void refund(Product03 product03) {      //  구입한 제품을 환불한다.
            if (item03.remove(product03)) {        //  제품을 Vector에서 제거한다.
                money += product03.price;
                bonusPoint -= product03.bonusPoint;
                System.out.println(product03 + "을/를 반품하셨습니다.");
            } else {                            //  제거에 실패한 경우
                System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
            }
        }

        void summary() {                    //  구매한 물품에 대한 정보를 요약해서 보여준다
            int sum = 0;                //  구입한 물품의 가격합계
            String itemList = "";       //  구입한 물품목록

            if (item03.isEmpty()) {         //  Vector가 비어있는지 확인한다.
                System.out.println(("구입하신 제품이 없습니다."));
                return;
            }

            //  반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
            for (int i = 0; i < item03.size(); i++) {
                Product03 product03 = (Product03) item03.get(i);
                sum += product03.price;
                itemList += (i == 0) ? "" + product03 : ", " + product03;
            }
            System.out.println("구입하신 물품의 총금액은" + sum + "만원입니다.");
            System.out.println("구입하신 제품은 " + itemList + "입니다");
        }
    }

    class PolyArgumentTest03 {
        public static void main(String[] args) {
            Buyer03 buyer03 = new Buyer03();
            Tv03 tv03 = new Tv03();
            Computer03 computer03 = new Computer03();
            Audio03 audio03 = new Audio03();

            buyer03.buy(tv03);
            buyer03.buy(computer03);
            buyer03.buy(audio03);
            buyer03.summary();
            System.out.println();
            buyer03.refund(computer03);
            buyer03.summary();

        }
    }


