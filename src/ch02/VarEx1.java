package ch02;
// 변수의 초기화(변수를 사용하기 전에 처음으로 값을 정하는 것)
public class VarEx1 {
    public static void main(String[] args) {
        int year = 0; // 변수 year를 선언하고 0으로 초기화 한다
        int age = 14; // 변수를 age로 선언하고 14로 초기화 한다

        System.out.println(year);
        System.out.println(age);

        year = age + 2000; // 변수 age의 값에 2000을 더해서 변수 year에 저장
        age = age + 1; // 변수 age에 저장된 값을 1증가시킨다.

        System.out.println(year);
        System.out.println(age);

    }
}
