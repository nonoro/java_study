package ch06;

class Data1 {
    int value;
}

class Data2 {
    int value;

    Data2(int x)  {    // 매개변수가 있는 생성자.
        value = x;
    }
}

class ConstructorTest {
    public static void main(String[] args) {
        Data1 d1 = new Data1();   // 얘는 Data1에 생성자가 없어 자동으로 컴파일러가 Data1()이라는 생성자를 생성해서 오류가 안떳지만
    }
}



