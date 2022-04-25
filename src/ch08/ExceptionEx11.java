package ch08;

class ExceptionEx11 {
    public static void main(String[] args) {
        throw new RuntimeException();    //  RuntimeException을 고의로 발생시킨다.
    }
}

//  RuntimeException클래스와 그 자손에 해당하는 예외는 프로그래머에 의해 실수로 발생하는 것들이기 때문에 예외처리를 강제하지 않아서
//  이 코드는 실행된다.