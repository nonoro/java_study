package ch09.javaLangPackage;

class EqualsEx01 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if (v1.equals(v2)) {                //  equals메서드는 주소값으로 비교를 하기 때문에 v1과 v2의 인스턴스변수의 값이 10 으로 서로 같아도 equals메서드로 비교한 결과는 false이다.
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }

        v2 = v1;

        if (v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }                                                       //  이렇게 v1 = v2를 해서 v1과 v2의 주소를 같게하면 equals 가 true가 되지만
    }   //  main                                                  //  Object의 equals()를 오버라이딩해서 하는 방법도있다
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }
}


//@Override
//    //  Object의 equals()를 오버라이딩해서 주소가 아닌 value를 비교
//    public boolean equals(Object obj) {
//        //  return this == obj;   // 이건 this와 obj의 주소 비교. 때문에 서로 다른 객체는 항상 거짓
//        //  참조변수의 형변환을 해야하고 참조변수 형변환 전에는 반드시 instanceof로 확인해야함. 왜냐면 참조변수가 obj타입이기 때문에 뭐가 들어올지 몰라서
//        if (!(obj instanceof Value)) {
//            return false;
//        }
//
//        Value v = (Value)obj;   //  obj를 value로 형변환
//
//        return this.value == v.value;
//    }
//}