package ch03;

public class OperatorEx12 {
    public static void main (String[] args) {
        char c1 = 'a'; // c1 에는 문자 'a'의 코드값인 97이 저장된다.
        char c2 = c1; // c1에 저장되어있는 값이 c2에 저장된다
        char c3 =' '; // c3를 공백으로 초기화 한다.

        int i = c1 + 1; // 'a'+1 -> 97+1 -> 98

        c3 = (char) (c1 + 1); // 덧셈연산 c1+1의 결과가 int이므로 이 결과를 char형 변수 c3에 담기위해선 char 형으로의 변환이 필요하다
        c2++; //형변환없이 c2에 들어있는 값을 1 증가
        c2++; //c2++대신에  c2=c2+1을 사용하면 에러가발생 왜냐면 c2=c2+1은 int형 그 결과를 다시 c2에 담으려면 (char)로 형변화해줘야함

        System.out.println("i=" + i);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
    }
}
